package com.example.apis.Service2;

import com.example.apis.Entity2.Message2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiService2 {
    //api on water 2
    @GET("results/{lat},{lon}?access_token=8cp7SPLH5cE98zdzDxvA")
    Call<Message2> getMessageId(@Path("lat")Double lat, @Path("lon")Double lon);


}
