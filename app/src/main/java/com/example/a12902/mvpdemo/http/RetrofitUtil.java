package com.example.a12902.mvpdemo.http;

import com.example.a12902.mvpdemo.api.ApiConstants;
import com.example.a12902.mvpdemo.api.ApiService;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    private static ApiService apiService;
    private static final String TAG = "RetrofitUtil";

    private RetrofitUtil() {
    }

    public static ApiService getApiService() {
        if (apiService == null) {
            synchronized (RetrofitUtil.class) {
                if (apiService == null) {
                    apiService = new Retrofit
                            .Builder()
                            .baseUrl(ApiConstants.BASEURL)
                            .client(new OkHttpClient.Builder()
                                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                                    .connectTimeout(5, TimeUnit.SECONDS)
                                    .readTimeout(20, TimeUnit.SECONDS)
                                    .build())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(ApiService.class);
                }
            }
        }
        return apiService;
    }

}
