package com.example.epafproject.events;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/post/")
    Call<List<Posts>> getPosts();
}
