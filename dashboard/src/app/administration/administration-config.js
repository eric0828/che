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


import {AdministrationController} from './administration.controller';
import {DockerRegistryList} from './docker-registries/docker-registry-list/docker-registry-list.directive';
import {DockerRegistryListController} from './docker-registries/docker-registry-list/docker-registry-list.controller';
import {AddRegistryController} from './docker-registries/docker-registry-list/add-registry/add-registry.controller';
import {EditRegistryController} from './docker-registries/docker-registry-list/edit-registry/edit-registry.controller';

import {StackList} from './stacks/stack-list/stack-list.directive';
import {StackListController} from './stacks/stack-list/stack-list.controller';


export class AdministrationConfig {

  constructor(register) {
    register.controller('AdministrationController', AdministrationController);

    register.directive('dockerRegistryList', DockerRegistryList);
    register.controller('DockerRegistryListController', DockerRegistryListController);

    register.controller('AddRegistryController', AddRegistryController);

    register.controller('EditRegistryController', EditRegistryController);

    // config routes
    register.app.config(($routeProvider) => {
      $routeProvider.accessWhen('/administration', {
        templateUrl: 'app/administration/administration.html',
        controller: 'AdministrationController',
        controllerAs: 'administrationController'
      });
    });

  }
}
