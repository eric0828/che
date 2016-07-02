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
public abstract class AbstractConstraints<T> {
    /** Anchor. */
    public Anchor    anchor;
    public Direction direction;
    public String    relativeId;
    public T         dataObject;


    public AbstractConstraints(Anchor anchor, String relativeId) {
        this(anchor, relativeId, null);
    }

    public AbstractConstraints(Direction direction, T dataObject) {
        this(null, null, direction, dataObject);
    }

    public AbstractConstraints(Anchor anchor, String relativeId, T dataObject) {
        this(anchor, relativeId, null, dataObject);
    }

    public AbstractConstraints(Anchor anchor, String relativeId, Direction direction, T dataObject) {
        this.anchor = anchor;
        this.relativeId = relativeId;
        this.direction = direction;
        this.dataObject = dataObject;
    }

    public Anchor getAnchor() {
        return anchor;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getRelativeId() {
        return relativeId;
    }

    public Object getDataObject() {
        return dataObject;
    }
}
