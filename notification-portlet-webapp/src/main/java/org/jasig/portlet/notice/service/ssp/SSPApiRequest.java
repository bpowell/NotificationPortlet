/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.notice.service.ssp;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Josh Helmer, jhelmer.unicon.net
 */
public class SSPApiRequest<T> {
    private String urlFragment;
    private HttpMethod method = HttpMethod.GET;
    private HttpHeaders headers = new HttpHeaders();
    private Object postData;
    private Class<T> responseClass;
    private Map<String, Object> uriParameters = new HashMap<>();


    public SSPApiRequest(final String urlFragment, final Class<T> responseClass) {
        this.urlFragment = urlFragment;
        this.responseClass = responseClass;
    }


    public String getUrlFragment() {
        return urlFragment;
    }


    public SSPApiRequest setUrlFragment(final String urlFragment) {
        this.urlFragment = urlFragment;
        return this;
    }


    public HttpMethod getMethod() {
        return method;
    }


    public SSPApiRequest setMethod(final HttpMethod method) {
        this.method = method;
        return this;
    }


    public HttpHeaders getHeaders() {
        return headers;
    }


    public SSPApiRequest setHeaders(final HttpHeaders headers) {
        this.headers = (headers == null) ? new HttpHeaders() : headers;
        return this;
    }


    public SSPApiRequest setHeader(final String name, final String value) {
        this.headers.set(name, value);
        return this;
    }


    public Object getPostData() {
        return postData;
    }


    public SSPApiRequest setPostData(final Object postData) {
        this.postData = postData;
        return this;
    }


    public Class<T> getResponseClass() {
        return responseClass;
    }


    public Map<String, Object> getUriParameters() {
        return uriParameters;
    }


    public SSPApiRequest setUriParameters(final Map<String, Object> uriParameters) {
        this.uriParameters = (uriParameters == null) ? new HashMap<String, Object>() : uriParameters;
        return this;
    }


    public SSPApiRequest addUriParameter(final String name, final Object value) {
        this.uriParameters.put(name, value);
        return this;
    }


    public HttpEntity<?> getRequestEntity() {
        return new HttpEntity<>(postData, headers);
    }
}
