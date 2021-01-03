package com.instazam.instazambackend.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.model.RecognitionStatus;
import com.instazam.instazambackend.service.client.AuddClient;
import com.instazam.instazambackend.service.client.response.AuddRecognizeResponse;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Onur Yurteri
 */
@Service
public class AuddServiceImpl implements AuddService {

    @Autowired
    RecognitionService recognitionService;

    @Value("${audd.baseurl}")
    private String AUDD_BASE_URL; // = "https://api.audd.io/";

    @Value("${audd.apikey}")
    public String apiKey; // = "e97d6f1012971b7f812707a95fda37fe";

    @Value("${audd.returns}")
    private String apiReturns; // = "apple_music,spotify,deezer,napster";

    AuddClient auddClient;

    @Override
    public void recognize(Recognition recognition) {
        AuddClient client = getAuddClient();
        Map<String, String> map = new HashMap<>(3);
        map.put("api_token", apiKey);
        map.put("url", recognition.getConvertedUrl());
        map.put("return", apiReturns);

        client.recognize(map).enqueue(new Callback<AuddRecognizeResponse>() {
            @Override
            public void onResponse(Call<AuddRecognizeResponse> call, Response<AuddRecognizeResponse> response) {
                final AuddRecognizeResponse body = response.body();
                if ("success".equals(body.getStatus())) {
                    recognition.setStatus(RecognitionStatus.FINISHED);
                    if (body.getResult() != null) {
                        recognition.setResult(body.getResult());
                    } else {
                        recognition.setStatus(RecognitionStatus.NOT_FOUND);
                    }
                } else if ("error".equals(body.getStatus())) {
                    recognition.setStatus(RecognitionStatus.FAILED);
                } else {
                    System.out.println("status something different than success/error");
                }

                recognitionService.save(recognition);
            }

            @Override
            public void onFailure(Call<AuddRecognizeResponse> call, Throwable throwable) {
                throwable.printStackTrace();
                recognition.setStatus(RecognitionStatus.FAILED);
                recognitionService.save(recognition);
            }
        });
    }

    private AuddClient getAuddClient() {
        if (auddClient != null) {
            return auddClient;
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
                .baseUrl(AUDD_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        auddClient = retrofit.create(AuddClient.class);

        return auddClient;
    }

}
