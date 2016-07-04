/*
 * Copyright (c) 2015-2016 Codenvy, S.A.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Codenvy, S.A. - initial API and implementation
 */
'use strict';

/**
 * @ngdoc directive
 * @name administration.stacks.stack-list.directive:stackList
 * @restrict E
 * @element
 *
 * @description
 * <stack-list></stack-list>` for displaying list of stacks.
 *
 * @usage
 *   <stack-list></stack-list>
 *
 * @author Oleksii Orel
 */
export class StackList {

  /**
   * Default constructor that is using resource
   * @ngInject for Dependency injection
   */
  constructor() {
    this.restrict = 'E';
    this.templateUrl = 'app/administration/stacks/stack-list/stack-list.html';
    this.replace = false;

    this.controller = 'StackListController';
    this.controllerAs = 'stackListController';

    this.bindToController = true;

    this.scope = true;

  }

}
