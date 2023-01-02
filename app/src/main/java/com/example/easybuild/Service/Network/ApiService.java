package com.example.easybuild.Service.Network;

import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("auth/register")
    Call<RegisterResponse> register(
            @Body User body
    );

    @POST("auth/login")
    Call<RegisterResponse> logIn(
            @Body User body
    );

    @GET("getpc")
    Call<PcBuild> buildPc(
            @Query("mb") double motherBoard,
            @Query("pros") double processor,
            @Query("ram") double ram,
            @Query("st") double storage,
            @Query("ps") double powerSupply,
            @Query("monitor") double monitor
    );

}
