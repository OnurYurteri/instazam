package com.instazam.instazambackend.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.instazam.instazambackend.model.EventType;
import com.instazam.instazambackend.model.Recognition;
import com.instazam.instazambackend.model.RecognitionStatus;
import com.instazam.instazambackend.service.client.ConvertClient;
import com.instazam.instazambackend.service.client.request.ConvertRequest;
import com.instazam.instazambackend.service.client.response.ConvertResponse;
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

/**
 * @author Onur Yurteri
 */
@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    RecognitionService recognitionService;

    ConvertClient convertClient;

    @Value("${convert.baseurl}")
    String CONVERT_BASE_URL;

    @Value("${convert.domain}")
    String CONVERT_DOMAIN;

    @Override
    public void convert(Recognition recognition) {
        ConvertClient client = getConvertClient();
        ConvertRequest request = new ConvertRequest();
        request.setRecognition(recognition.getId());
        request.setUrl(recognition.getVideoUrl());

        client.convert(request).enqueue(new Callback<ConvertResponse>() {
            @Override
            public void onResponse(Call<ConvertResponse> call, Response<ConvertResponse> response) {
                String url = CONVERT_DOMAIN.concat(response.body().getPath());
                recognition.setConvertedUrl(url);
                recognitionService.saveAndFireEvent(recognition, EventType.RECOGNIZE_FROM_AUDD);
            }

            @Override
            public void onFailure(Call<ConvertResponse> call, Throwable throwable) {
                recognition.setStatus(RecognitionStatus.FAILED);
                recognitionService.save(recognition);
            }
        });
    }

    private ConvertClient getConvertClient() {
        if (convertClient != null) {
            return convertClient;
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
                .baseUrl(CONVERT_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();

        convertClient = retrofit.create(ConvertClient.class);

        return convertClient;
    }

}
