/*
 * Copyright (C) Scott Cranton, Jakub Korab, and Christian Posta
 * https://github.com/CamelCookbook
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camelcookbook.examples.testing.java;

import org.apache.camel.builder.RouteBuilder;

/**
 * Route builder that prepends the body of the exchange that is passed to it.
 */
public class SimpleTransformDIRouteBuilder extends RouteBuilder {
    private String sourceUri;
    private String targetUri;

    public void setSourceUri(String sourceUri) {
        this.sourceUri = sourceUri;
    }

    public void setTargetUri(String targetUri) {
        this.targetUri = targetUri;
    }

    @Override
    public void configure() throws Exception {
        from(sourceUri)
            .transform(simple("Modified: ${body}"))
            .to(targetUri);
    }
}
