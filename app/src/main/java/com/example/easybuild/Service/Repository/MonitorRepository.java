package com.example.easybuild.Service.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Network.ApiService;
import com.example.easybuild.Service.Network.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonitorRepository {

    private static MonitorRepository instance = null;
    private static MutableLiveData<Root> monitor;
    private static Context ctx;

    public static MonitorRepository getInstance(Context context){

        if (instance == null){
            ctx = context;
            instance = new MonitorRepository();
        }

        return instance;
    }

    public MutableLiveData<Root> monitors(){

        if (monitor == null){
            monitor = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<Root> call = apiService.allMonitor();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.body()!=null){
                    monitor.postValue(response.body());
                }
                else
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return monitor;
    }

}
