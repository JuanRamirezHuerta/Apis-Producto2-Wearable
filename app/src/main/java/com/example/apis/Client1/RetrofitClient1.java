package com.example.apis.Client1;

import com.example.apis.Service1.RetrofitApiService1;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient1 { //api coronavirus 1
    public static final String URL_BASE = "https://api.covidtracking.com/v1/";
    private static Retrofit retrofit;
    //metodo que vaa consumir la api

    public static RetrofitApiService1 getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiService1.class);
    }
}
