package com.example.easybuild.Service.Network;

import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.MotherboardResponse;
import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
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

    @POST("motherboard")
    Call<MotherboardResponse> addMotherboard(
            @Body Motherboard body
    );

    @PUT("motherboard/{id}")
    Call<MotherboardResponse> modifyMotherboard(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("motherboard/{id}")
    Call<MotherboardResponse> deleteMotherboard(
            @Path("id") String id
    );

    @GET("getpc2")
    Call<PcBuild> buildPc(
            @Query("mb") double motherBoard,
            @Query("pros") double processor,
            @Query("ram") double ram,
            @Query("st") double storage,
            @Query("ps") double powerSupply,
            @Query("monitor") double monitor
    );

    @GET("getpcwithgpu")
    Call<PcBuild> buildPcWithGPu(
            @Query("mb") double motherBoard,
            @Query("pros") double processor,
            @Query("ram") double ram,
            @Query("st") double storage,
            @Query("ps") double powerSupply,
            @Query("monitor") double monitor,
            @Query("gpu") double gpu
    );

    @GET("motherboard")
    Call<Root> allMotherboard();

}
