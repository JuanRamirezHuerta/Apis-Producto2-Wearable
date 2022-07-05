package com.example.apis.Client2;

import com.example.apis.Service2.RetrofitApiService2;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient2 { //api on water 2
    public static final String URL_BASE = "https://api.onwater.io/api/v1/";
    private static Retrofit retrofit;
    //metodo que vaa consumir la api

    public static RetrofitApiService2 getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(RetrofitApiService2.class);
    }

}
