package com.example.listmovieconan.httpclient;

import com.example.listmovieconan.model.ResponseMovie;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("movie")
    Call<ResponseMovie> getMovie();
}

