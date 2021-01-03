package com.instazam.instazambackend.service.client;

import com.instazam.instazambackend.service.client.request.ConvertRequest;
import com.instazam.instazambackend.service.client.response.ConvertResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @author Onur Yurteri
 */
public interface ConvertClient {

    @POST("/convert")
    Call<ConvertResponse> convert(@Body ConvertRequest request);

}
