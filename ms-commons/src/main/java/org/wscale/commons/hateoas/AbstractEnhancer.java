package org.wscale.commons.hateoas;

/*
 * Copyright 2017 Valentin Durst (www.wscale.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

abstract class AbstractEnhancer<T extends ResourceSupport> {

    T enhanceWithActions(final T obj, final List<HateoasAction> actions) {
        for (final HateoasAction action : actions) {
            for (final Object link : action.getLinks()) {
                obj.add(linkTo(link).withRel(action.getType()));
            }
        }
        return obj;
    }
}
