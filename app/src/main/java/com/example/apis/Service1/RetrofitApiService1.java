package com.example.apis.Service1;

import com.example.apis.Entity1.Message1;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApiService1 {
    //api coronavirus
    @GET("us/daily.json")
    Call<List<Message1>> getMessageId();

}
