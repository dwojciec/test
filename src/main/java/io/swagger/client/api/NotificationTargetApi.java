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

import io.swagger.client.model.NotificationTarget;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationTargetApi {
    private ApiClient apiClient;

    public NotificationTargetApi() {
        this(Configuration.getDefaultApiClient());
    }

    public NotificationTargetApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /* Build call for deleteNotificationTarget */
    private com.squareup.okhttp.Call deleteNotificationTargetCall(Long targetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'targetId' is set
        if (targetId == null) {
            throw new ApiException("Missing the required parameter 'targetId' when calling deleteNotificationTarget(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/notificationtargets/{targetId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "targetId" + "\\}", apiClient.escapeString(targetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Delete notification target
     * Delete a notification target identified by **targetId**. Also deletes associated notifications.
     * @param targetId The **targetId** to delete (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteNotificationTarget(Long targetId) throws ApiException {
        deleteNotificationTargetWithHttpInfo(targetId);
    }

    /**
     * Delete notification target
     * Delete a notification target identified by **targetId**. Also deletes associated notifications.
     * @param targetId The **targetId** to delete (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteNotificationTargetWithHttpInfo(Long targetId) throws ApiException {
        com.squareup.okhttp.Call call = deleteNotificationTargetCall(targetId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete notification target (asynchronously)
     * Delete a notification target identified by **targetId**. Also deletes associated notifications.
     * @param targetId The **targetId** to delete (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteNotificationTargetAsync(Long targetId, final ApiCallback<Void> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = deleteNotificationTargetCall(targetId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /* Build call for getNotificationTarget */
    private com.squareup.okhttp.Call getNotificationTargetCall(Long targetId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        
        // verify the required parameter 'targetId' is set
        if (targetId == null) {
            throw new ApiException("Missing the required parameter 'targetId' when calling getNotificationTarget(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/notificationtargets/{targetId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "targetId" + "\\}", apiClient.escapeString(targetId.toString()));

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
     * Get notification target
     * Retrieve notification target identified by **targetId**.
     * @param targetId The **targetId** to retrieve (required)
     * @return NotificationTarget
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationTarget getNotificationTarget(Long targetId) throws ApiException {
        ApiResponse<NotificationTarget> resp = getNotificationTargetWithHttpInfo(targetId);
        return resp.getData();
    }

    /**
     * Get notification target
     * Retrieve notification target identified by **targetId**.
     * @param targetId The **targetId** to retrieve (required)
     * @return ApiResponse&lt;NotificationTarget&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationTarget> getNotificationTargetWithHttpInfo(Long targetId) throws ApiException {
        com.squareup.okhttp.Call call = getNotificationTargetCall(targetId, null, null);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get notification target (asynchronously)
     * Retrieve notification target identified by **targetId**.
     * @param targetId The **targetId** to retrieve (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationTargetAsync(Long targetId, final ApiCallback<NotificationTarget> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationTargetCall(targetId, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for getNotificationTargets */
    private com.squareup.okhttp.Call getNotificationTargetsCall(final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        

        // create path and map variables
        String localVarPath = "/v2/notificationtargets".replaceAll("\\{format\\}","json");

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
     * List notification targets
     * Retrieve all notification targets for the authenticated client.
     * @return List&lt;NotificationTarget&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public List<NotificationTarget> getNotificationTargets() throws ApiException {
        ApiResponse<List<NotificationTarget>> resp = getNotificationTargetsWithHttpInfo();
        return resp.getData();
    }

    /**
     * List notification targets
     * Retrieve all notification targets for the authenticated client.
     * @return ApiResponse&lt;List&lt;NotificationTarget&gt;&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<List<NotificationTarget>> getNotificationTargetsWithHttpInfo() throws ApiException {
        com.squareup.okhttp.Call call = getNotificationTargetsCall(null, null);
        Type localVarReturnType = new TypeToken<List<NotificationTarget>>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * List notification targets (asynchronously)
     * Retrieve all notification targets for the authenticated client.
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getNotificationTargetsAsync(final ApiCallback<List<NotificationTarget>> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = getNotificationTargetsCall(progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<List<NotificationTarget>>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for postNotificationTarget */
    private com.squareup.okhttp.Call postNotificationTargetCall(NotificationTarget notificationTargetDto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = notificationTargetDto;
        
        // verify the required parameter 'notificationTargetDto' is set
        if (notificationTargetDto == null) {
            throw new ApiException("Missing the required parameter 'notificationTargetDto' when calling postNotificationTarget(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/notificationtargets".replaceAll("\\{format\\}","json");

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Create a new notification target
     * Create a new notification target to receive configured notifications.  The two current supported systems are the Apple Push Notification service (APNs) for &#x60;IOS&#x60; devices and Google Cloud Messaging (GCM) for &#x60;ANDROID&#x60;, which must be supplied in **state**. The **appToken** must contain the unique identifier you receive after registering your device with the messaging services. The **locale** must comply to ISO 3166 language code. Currently only &#x60;de_DE&#x60; is supported. 
     * @param notificationTargetDto The notification target to create (required)
     * @return NotificationTarget
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationTarget postNotificationTarget(NotificationTarget notificationTargetDto) throws ApiException {
        ApiResponse<NotificationTarget> resp = postNotificationTargetWithHttpInfo(notificationTargetDto);
        return resp.getData();
    }

    /**
     * Create a new notification target
     * Create a new notification target to receive configured notifications.  The two current supported systems are the Apple Push Notification service (APNs) for &#x60;IOS&#x60; devices and Google Cloud Messaging (GCM) for &#x60;ANDROID&#x60;, which must be supplied in **state**. The **appToken** must contain the unique identifier you receive after registering your device with the messaging services. The **locale** must comply to ISO 3166 language code. Currently only &#x60;de_DE&#x60; is supported. 
     * @param notificationTargetDto The notification target to create (required)
     * @return ApiResponse&lt;NotificationTarget&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationTarget> postNotificationTargetWithHttpInfo(NotificationTarget notificationTargetDto) throws ApiException {
        com.squareup.okhttp.Call call = postNotificationTargetCall(notificationTargetDto, null, null);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Create a new notification target (asynchronously)
     * Create a new notification target to receive configured notifications.  The two current supported systems are the Apple Push Notification service (APNs) for &#x60;IOS&#x60; devices and Google Cloud Messaging (GCM) for &#x60;ANDROID&#x60;, which must be supplied in **state**. The **appToken** must contain the unique identifier you receive after registering your device with the messaging services. The **locale** must comply to ISO 3166 language code. Currently only &#x60;de_DE&#x60; is supported. 
     * @param notificationTargetDto The notification target to create (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call postNotificationTargetAsync(NotificationTarget notificationTargetDto, final ApiCallback<NotificationTarget> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = postNotificationTargetCall(notificationTargetDto, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /* Build call for putNotificationTarget */
    private com.squareup.okhttp.Call putNotificationTargetCall(Long targetId, NotificationTarget notificationTargetDto, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = notificationTargetDto;
        
        // verify the required parameter 'targetId' is set
        if (targetId == null) {
            throw new ApiException("Missing the required parameter 'targetId' when calling putNotificationTarget(Async)");
        }
        
        // verify the required parameter 'notificationTargetDto' is set
        if (notificationTargetDto == null) {
            throw new ApiException("Missing the required parameter 'notificationTargetDto' when calling putNotificationTarget(Async)");
        }
        

        // create path and map variables
        String localVarPath = "/v2/notificationtargets/{targetId}".replaceAll("\\{format\\}","json")
        .replaceAll("\\{" + "targetId" + "\\}", apiClient.escapeString(targetId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
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
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    /**
     * Update notification target
     * Update a notification target. Usually used to change the **appToken** since the messaging services alter those periodically. The **id** in **notificationDto** must match the **targetId**.
     * @param targetId The **targetId** to update (required)
     * @param notificationTargetDto The notification target with updated token (required)
     * @return NotificationTarget
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public NotificationTarget putNotificationTarget(Long targetId, NotificationTarget notificationTargetDto) throws ApiException {
        ApiResponse<NotificationTarget> resp = putNotificationTargetWithHttpInfo(targetId, notificationTargetDto);
        return resp.getData();
    }

    /**
     * Update notification target
     * Update a notification target. Usually used to change the **appToken** since the messaging services alter those periodically. The **id** in **notificationDto** must match the **targetId**.
     * @param targetId The **targetId** to update (required)
     * @param notificationTargetDto The notification target with updated token (required)
     * @return ApiResponse&lt;NotificationTarget&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<NotificationTarget> putNotificationTargetWithHttpInfo(Long targetId, NotificationTarget notificationTargetDto) throws ApiException {
        com.squareup.okhttp.Call call = putNotificationTargetCall(targetId, notificationTargetDto, null, null);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Update notification target (asynchronously)
     * Update a notification target. Usually used to change the **appToken** since the messaging services alter those periodically. The **id** in **notificationDto** must match the **targetId**.
     * @param targetId The **targetId** to update (required)
     * @param notificationTargetDto The notification target with updated token (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call putNotificationTargetAsync(Long targetId, NotificationTarget notificationTargetDto, final ApiCallback<NotificationTarget> callback) throws ApiException {

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

        com.squareup.okhttp.Call call = putNotificationTargetCall(targetId, notificationTargetDto, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<NotificationTarget>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
