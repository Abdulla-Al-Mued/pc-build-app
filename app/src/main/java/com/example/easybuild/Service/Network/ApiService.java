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

    //motherboard

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

    //monitor

    @POST("monitor")
    Call<MotherboardResponse> addMonitor(
            @Body Motherboard body
    );

    @PUT("monitor/{id}")
    Call<MotherboardResponse> modifyMonitor(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("monitor/{id}")
    Call<MotherboardResponse> deleteMonitor(
            @Path("id") String id
    );

    //power supply
    @POST("powersupply")
    Call<MotherboardResponse> addPowerSupply(
            @Body Motherboard body
    );

    @PUT("powersupply/{id}")
    Call<MotherboardResponse> modifyPowerSupply(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("powersupply/{id}")
    Call<MotherboardResponse> deletePowerSupply(
            @Path("id") String id
    );

    //processor

    @POST("processor")
    Call<MotherboardResponse> addProcessor(
            @Body Motherboard body
    );

    @PUT("processor/{id}")
    Call<MotherboardResponse> modifyProcessor(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("processor/{id}")
    Call<MotherboardResponse> deleteProcessor(
            @Path("id") String id
    );

    //ram
    @POST("ram")
    Call<MotherboardResponse> addRam(
            @Body Motherboard body
    );

    @PUT("ram/{id}")
    Call<MotherboardResponse> modifyRam(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("ram/{id}")
    Call<MotherboardResponse> deleteRam(
            @Path("id") String id
    );

    //storage
    @POST("storage")
    Call<MotherboardResponse> addStorage(
            @Body Motherboard body
    );

    @PUT("storage/{id}")
    Call<MotherboardResponse> modifyStorage(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("storage/{id}")
    Call<MotherboardResponse> deleteStorage(
            @Path("id") String id
    );

    //gpu
    @POST("gpu")
    Call<MotherboardResponse> addGpu(
            @Body Motherboard body
    );

    @PUT("gpu/{id}")
    Call<MotherboardResponse> modifyGpu(
            @Body Motherboard body,
            @Path("id") String id
    );

    @DELETE("gpu/{id}")
    Call<MotherboardResponse> deleteGpu(
            @Path("id") String id
    );





    //pc build

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
    @GET("monitor")
    Call<Root> allMonitor();
    @GET("powersupply")
    Call<Root> allPowerSupply();
    @GET("processor")
    Call<Root> allProcessor();
    @GET("ram")
    Call<Root> allRam();
    @GET("storage")
    Call<Root> allStorage();
    @GET("gpu")
    Call<Root> allGpu();



}
