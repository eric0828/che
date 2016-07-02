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
package org.eclipse.che.ide.api.constraints;

/**
 * Represents constraints for some action. Constraints are used to specify
 * action's position in the default group, see {@link org.eclipse.che.ide.api.action.DefaultActionGroup}.
 *
 * @author Evgen Vidolob
 */
public class Constraints extends AbstractConstraints {
    public final static Constraints FIRST = new Constraints(Anchor.FIRST, null);
    public final static Constraints LAST  = new Constraints(Anchor.LAST, null);

    public Constraints(Anchor anchor, String relativeToActionId) {
        super(anchor, relativeToActionId);
    }
}
