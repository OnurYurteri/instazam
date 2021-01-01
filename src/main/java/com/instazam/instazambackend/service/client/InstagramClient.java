package com.instazam.instazambackend.service.client;

import com.instazam.instazambackend.service.client.response.InstagramDataResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * @author Onur Yurteri
 */
public interface InstagramClient {

    @Headers({
            "authority: www.instagram.com",
            "cache-control: max-age=0",
            "user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 11_1_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36",
            "accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
            "accept-language: en-GB,en;q=0.9,tr-TR;q=0.8,tr;q=0.7,en-US;q=0.6"
    })
    @GET("/p/{postId}/?__a=1")
    Call<InstagramDataResponse> getPostDetails(@Path("postId") String postId);

}
