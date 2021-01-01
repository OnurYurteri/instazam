package com.instazam.instazambackend.service.client;

import com.instazam.instazambackend.service.client.response.InstagramDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
public interface InstagramClient {

    @GET("/p/{postId}/?__a=1")
    Call<InstagramDataResponse> getPostDetails(@Path("postId") String postId);

}
