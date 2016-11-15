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

import io.swagger.client.model.Provider;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProviderApi {
    private ApiClient apiClient;

    public ProviderApi() {
        this(Configuration.getDefaultApiClient());
    }

    public ProviderApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for getProvider */
    private com.squareup.okhttp.Call getProviderCall(Long providerId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'providerId' is set
        if (providerId == null) {
            throw new ApiException("Missing the required parameter 'providerId' when calling getProvider(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/providers/{providerId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "providerId" + "\\}", apiClient.escapeString(providerId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

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
     * Get provider
     * Retrieve a single provider identified by **providerId**.
     * @param providerId The **providerId** to retrieve (required)
     * @return Provider
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public Provider getProvider(Long providerId) throws ApiException {
        ApiResponse<Provider> resp = getProviderWithHttpInfo(providerId);
        return resp.getData();
    }

    /**
     * Get provider
     * Retrieve a single provider identified by **providerId**.
     * @param providerId The **providerId** to retrieve (required)
     * @return ApiResponse&lt;Provider&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Provider> getProviderWithHttpInfo(Long providerId) throws ApiException {
        com.squareup.okhttp.Call call = getProviderCall(providerId, null, null);
        Type localVarReturnType = new TypeToken<Provider>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get provider (asynchronously)
     * Retrieve a single provider identified by **providerId**.
     * @param providerId The **providerId** to retrieve (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProviderAsync(Long providerId, final ApiCallback<Provider> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getProviderCall(providerId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<Provider>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getProviders */
    private com.squareup.okhttp.Call getProvidersCall(String bankCode, Boolean supported, String query, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v2/providers".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        if (bankCode != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "bankCode", bankCode));
        if (supported != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "supported", supported));
        if (query != null)
        localVarQueryParams.addAll(apiClient.parameterToPairs("", "query", query));

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
     * List bank providers
     * Retrieve a list of bank providers. A provider-**id** is necessary to create an _access_. To retrieve the necessary access fields, you need to query the specific &#x60;provider/{providerId}&#x60;. For performance reasons they are kept separate. 
     * @param bankCode Optional &amp;mdash; if length &#x3D; 8, the response will also contain data describing             the fields required for account setup (optional)
     * @param supported Optional &amp;mdash; response should only contain providers supported for account             setup via this API (optional)
     * @param query Optional &amp;mdash; search parameters for BankCode, BIC, Location, Name. Will be ignored             if the bankCode query parameter is set. (optional)
     * @return List&lt;Provider&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<Provider> getProviders(String bankCode, Boolean supported, String query) throws ApiException {
        ApiResponse<List<Provider>> resp = getProvidersWithHttpInfo(bankCode, supported, query);
        return resp.getData();
    }

    /**
     * List bank providers
     * Retrieve a list of bank providers. A provider-**id** is necessary to create an _access_. To retrieve the necessary access fields, you need to query the specific &#x60;provider/{providerId}&#x60;. For performance reasons they are kept separate. 
     * @param bankCode Optional &amp;mdash; if length &#x3D; 8, the response will also contain data describing             the fields required for account setup (optional)
     * @param supported Optional &amp;mdash; response should only contain providers supported for account             setup via this API (optional)
     * @param query Optional &amp;mdash; search parameters for BankCode, BIC, Location, Name. Will be ignored             if the bankCode query parameter is set. (optional)
     * @return ApiResponse&lt;List&lt;Provider&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<Provider>> getProvidersWithHttpInfo(String bankCode, Boolean supported, String query) throws ApiException {
        com.squareup.okhttp.Call call = getProvidersCall(bankCode, supported, query, null, null);
        Type localVarReturnType = new TypeToken<List<Provider>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List bank providers (asynchronously)
     * Retrieve a list of bank providers. A provider-**id** is necessary to create an _access_. To retrieve the necessary access fields, you need to query the specific &#x60;provider/{providerId}&#x60;. For performance reasons they are kept separate. 
     * @param bankCode Optional &amp;mdash; if length &#x3D; 8, the response will also contain data describing             the fields required for account setup (optional)
     * @param supported Optional &amp;mdash; response should only contain providers supported for account             setup via this API (optional)
     * @param query Optional &amp;mdash; search parameters for BankCode, BIC, Location, Name. Will be ignored             if the bankCode query parameter is set. (optional)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getProvidersAsync(String bankCode, Boolean supported, String query, final ApiCallback<List<Provider>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getProvidersCall(bankCode, supported, query, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<Provider>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
