/**
 * AHOI API
 * AHOI (working title) is our managed and flexible banking API designed to offer easy access to your users bank accounts.  [AHOI cookbook](/ahoi/docs/cookbook/index.html)  [Imprint](https://symbioticon.de/legal-notices/)  [Privacy Disclaimer](https://symbioticon.de/data-protection-guidelines/)  &copy; 2016 Starfinanz - Ein Unternehmen der Finanz Informatik
 *
 * OpenAPI spec version: 2.0.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package io.swagger.client.api;

import io.swagger.client.ApiCallback;
import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.ApiResponse;
import io.swagger.client.Configuration;
import io.swagger.client.Pair;
import io.swagger.client.ProgressRequestBody;
import io.swagger.client.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;

import io.swagger.client.model.TanScheme;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TANSchemesApi {
    private ApiClient apiClient;

    public TANSchemesApi() {
        this(Configuration.getDefaultApiClient());
    }

    public TANSchemesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getTanSchemes */
    private com.squareup.okhttp.Call getTanSchemesCall(Long accessId, Boolean refresh, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'accessId' is set
        if (accessId == null) {
            throw new ApiException("Missing the required parameter 'accessId' when calling getTanSchemes(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/accesses/{accessId}/tanschemes".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "accessId" + "\\}", apiClient.escapeString(accessId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (refresh != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "refresh", refresh));

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "apiKey" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * List TAN schemes for access
     * Retrieves all available TAN schemes for access.
     * @param accessId The **id** for the access for which to retrieve the TAN list (required)
     * @param refresh Optional &amp;mdash; refreshes the TAN scheme list. If not provided, it             defaults to &#x60;false&#x60;. (optional)
     * @return List&lt;TanScheme&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<TanScheme> getTanSchemes(Long accessId, Boolean refresh) throws ApiException {
        ApiResponse<List<TanScheme>> resp = getTanSchemesWithHttpInfo(accessId, refresh);
        return resp.getData();
    }

    /**
     * List TAN schemes for access
     * Retrieves all available TAN schemes for access.
     * @param accessId The **id** for the access for which to retrieve the TAN list (required)
     * @param refresh Optional &amp;mdash; refreshes the TAN scheme list. If not provided, it             defaults to &#x60;false&#x60;. (optional)
     * @return ApiResponse&lt;List&lt;TanScheme&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<TanScheme>> getTanSchemesWithHttpInfo(Long accessId, Boolean refresh) throws ApiException {
        com.squareup.okhttp.Call call = getTanSchemesCall(accessId, refresh, null, null);
        Type localVarReturnType = new TypeToken<List<TanScheme>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List TAN schemes for access (asynchronously)
     * Retrieves all available TAN schemes for access.
     * @param accessId The **id** for the access for which to retrieve the TAN list (required)
     * @param refresh Optional &amp;mdash; refreshes the TAN scheme list. If not provided, it             defaults to &#x60;false&#x60;. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getTanSchemesAsync(Long accessId, Boolean refresh, final ApiCallback<List<TanScheme>> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getTanSchemesCall(accessId, refresh, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<TanScheme>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}