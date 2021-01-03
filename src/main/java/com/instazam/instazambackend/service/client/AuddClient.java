package com.instazam.instazambackend.service.client;

import com.instazam.instazambackend.service.client.response.AuddRecognizeResponse;
import com.instazam.instazambackend.service.client.response.InstagramDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
public interface AuddClient {

    @GET("/")
    @Headers(
            {
                    "Content-Type:application/x-www-form-urlencoded",
            }
    )
    Call<AuddRecognizeResponse> recognize(@QueryMap Map<String, String> params);

}
