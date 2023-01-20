package com.example.easybuild.Service.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Network.ApiService;
import com.example.easybuild.Service.Network.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PcBuildRepository {

    private static PcBuildRepository instance = null;
    private static Context context;
    private static MutableLiveData<PcBuild> allComponent, allComponent2;

    public static PcBuildRepository getInstance(Context ctx){

        if (instance == null){
            context = ctx;
            instance = new PcBuildRepository();
        }

        return instance;
    }


    public LiveData<PcBuild> getPc(double motherBoard, double processor, double ram,
                                   double storage, double powerSupply, double monitor){

        if (allComponent == null){
            allComponent = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<PcBuild> call = apiService.buildPc(motherBoard, processor, ram, storage, powerSupply, monitor);
        call.enqueue(new Callback<PcBuild>() {
            @Override
            public void onResponse(Call<PcBuild> call, Response<PcBuild> response) {
                if (response.body() != null){

                    allComponent.postValue(response.body());

                }
                else
                    Toast.makeText(context, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PcBuild> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


        return allComponent;
    }

    public LiveData<PcBuild> getPcWithGpu(double motherBoard, double processor, double ram,
                                   double storage, double powerSupply, double monitor, double gpu){

        if (allComponent2 == null){
            allComponent2 = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<PcBuild> call = apiService.buildPcWithGPu(motherBoard, processor, ram, storage, powerSupply, monitor, gpu);
        call.enqueue(new Callback<PcBuild>() {
            @Override
            public void onResponse(Call<PcBuild> call, Response<PcBuild> response) {
                if (response.body() != null){

                    allComponent2.postValue(response.body());

                }
                else
                    Toast.makeText(context, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PcBuild> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


        return allComponent2;
    }



}
