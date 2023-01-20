package com.example.easybuild.Service.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static Retrofit instance = null;
    public static String BASE_URL = "https://easybuild.onrender.com/api/";

    public static Retrofit getRetroInstance(){

        if (instance==null){
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return instance;

    }


}
