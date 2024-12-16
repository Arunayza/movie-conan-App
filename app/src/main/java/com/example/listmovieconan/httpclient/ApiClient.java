package com.example.listmovieconan.httpclient;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "https://arunations.online/api/";
    private static Retrofit retrofit = null;

    // Fungsi untuk mendapatkan instance Retrofit
    public static Retrofit getApiClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    // Fungsi untuk mendapatkan instance ApiInterface
    public static ApiInterface getApiInterface() {
        return getApiClient().create(ApiInterface.class);
    }
}
