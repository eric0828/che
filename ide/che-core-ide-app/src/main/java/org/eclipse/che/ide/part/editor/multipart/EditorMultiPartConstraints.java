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
package org.eclipse.che.ide.part.editor.multipart;

import org.eclipse.che.ide.api.constraints.AbstractConstraints;
import org.eclipse.che.ide.api.constraints.Anchor;
import org.eclipse.che.ide.api.constraints.Direction;
import org.eclipse.che.ide.part.widgets.editortab.EditorTab;

/**
 * Represents constraints for some editor. Constraints are used to specify
 * editor's position in the editor multipart.
 *
 * @author Roman Nikitenko
 */
public class EditorMultiPartConstraints extends AbstractConstraints<EditorTab> {

    public EditorMultiPartConstraints(Direction direction, EditorTab relativeTab) {
        super(direction, relativeTab);
    }
}
