/*******************************************************************************
 * Copyright (c) 2012-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 *******************************************************************************/
package org.eclipse.che.ide.actions;

import com.google.common.base.Optional;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import org.eclipse.che.ide.Resources;
import org.eclipse.che.ide.api.action.AbstractPerspectiveAction;
import org.eclipse.che.ide.api.action.ActionEvent;
import org.eclipse.che.ide.api.app.AppContext;
import org.eclipse.che.ide.api.resources.Container;
import org.eclipse.che.ide.api.resources.Resource;
import org.eclipse.che.ide.projecttype.wizard.presenter.ProjectWizardPresenter;
import org.eclipse.che.ide.resource.Path;

import javax.validation.constraints.NotNull;

import static java.util.Collections.singletonList;
import static org.eclipse.che.ide.workspace.perspectives.project.ProjectPerspective.PROJECT_PERSPECTIVE_ID;

/**
 * @author Evgen Vidolob
 * @author Dmitry Shnurenko
 * @author Vlad Zhukovskyi
 */
@Singleton
public class CreateProjectAction extends AbstractPerspectiveAction {

    private final ProjectWizardPresenter wizard;
    private final AppContext appContext;

    @Inject
    public CreateProjectAction(Resources resources,
                               ProjectWizardPresenter wizard,
                               AppContext appContext) {
        super(singletonList(PROJECT_PERSPECTIVE_ID), "Create Project...", "Create new project", null, resources.newProject());
        this.wizard = wizard;
        this.appContext = appContext;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        final Resource[] resources = appContext.getResources();

        if (resources != null && resources.length == 1) {
            final Resource resource = resources[0];
            final Path path;

            if (resource.getResourceType() == Resource.FILE) {
                final Optional<Container> parent = resource.getParent();

                if (parent.isPresent()) {
                    path = parent.get().getLocation();
                } else {
                    wizard.show();
                    return;
                }
            } else {
                path = resource.getLocation();
            }

            wizard.show(path);
        } else {
            wizard.show();
        }
    }

    @Override
    public void updateInPerspective(@NotNull ActionEvent event) {
        event.getPresentation().setEnabledAndVisible(true);
    }
}
