package com.instazam.instazambackend.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.instazam.instazambackend.service.client.InstagramClient;
import com.instazam.instazambackend.service.client.response.InstagramDataResponse;
import com.instazam.instazambackend.util.InstazamUtils;
import lombok.SneakyThrows;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Map;

/**
 * @author Onur Yurteri
 */
public class InstagramServiceImpl implements InstagramService {

    private final String INSTAGRAM_BASE_URL = "https://instagram.com/";

    InstagramClient instagramClient;

    @SneakyThrows
    @Override
    public String getVideoUrlFromLink(String postUrl) {
        String postId = InstazamUtils.getInstagramPostId(postUrl);
        final InstagramDataResponse body = getInstagramClient().getPostDetails(postId).execute().body();
        System.out.println(body);
        return postUrl;
    }

    private InstagramClient getInstagramClient() {
        if (instagramClient != null) {
            return instagramClient;
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(INSTAGRAM_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        instagramClient = retrofit.create(InstagramClient.class);

        return instagramClient;
    }

}
