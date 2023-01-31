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

public class RamRepository {
    private static RamRepository instance = null;
    private static Context ctx;
    private static MutableLiveData<Root> rams;

    public static RamRepository getInstance(Context context){

        if (instance == null){
            ctx = context;
            instance = new RamRepository();
        }

        return instance;
    }

    public MutableLiveData<Root> rams(){

        if (rams == null)
            rams = new MutableLiveData<>();


        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<Root> call = apiService.allRam();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.body()!=null){
                    rams.postValue(response.body());
                }
                else
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {
                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        return rams;
    }

}
