package com.pochekuev.application.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClient mInstance;
    private Retrofit retrofit;
    private static final String URL = "http://192.168.3.57:10018";
    //private static final String URL = "https://omgtu.ru/";

    public static ApiClient getInstance() {
        if(mInstance == null) {
            mInstance = new ApiClient();
        }

        return mInstance;
    }

    public ApiClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient().build())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient.Builder okHttpClient() {
        return new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();
                builder.header("Content-Type", "application/json");
                builder.header("up.omgtu.ru", "a2f187fc-9c37-4b77-a7e9-07e5860c6739");
                return chain.proceed(builder.build());
            }
        });
    }

    public IApiRequests getJsonApi() {
        return retrofit.create(IApiRequests.class);
    }

    public static  <T> void getResponse(Call<T> responseDataCall, OnApiGetResponse<T> onApiGetResponse) {
        responseDataCall.enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, retrofit2.Response<T> response) {
                if(response.body() != null) {
                    onApiGetResponse.onGetResponseSuccessfully(response.body());
                } else {
                    onApiGetResponse.onGetResponseFailed(new NullPointerException());
                }
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                onApiGetResponse.onGetResponseFailed(t);

                t.printStackTrace();
            }
        });
    }
}
