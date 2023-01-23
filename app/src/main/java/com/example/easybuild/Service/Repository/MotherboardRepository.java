package com.example.easybuild.Service.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.MotherboardResponse;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Network.ApiService;
import com.example.easybuild.Service.Network.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MotherboardRepository {

    private static MotherboardRepository instance = null;
    private static Context ctx;
    private static MutableLiveData<Root> motherboard;
    private static MutableLiveData<MotherboardResponse> addMotherboard, editMotherboard, deleteMotherboard;

    public static MotherboardRepository getInstance(Context context){

        if (instance==null){
            ctx = context;
            instance = new MotherboardRepository();
        }

        return instance;
    }



    public MutableLiveData<Root> motherboard(){

        if (motherboard == null){
            motherboard = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<Root> call = apiService.allMotherboard();
        call.enqueue(new Callback<Root>() {
            @Override
            public void onResponse(Call<Root> call, Response<Root> response) {
                if (response.body() != null){

                    motherboard.postValue(response.body());

                }
                else
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Root> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


        return motherboard;
    }

    public MutableLiveData<MotherboardResponse> addMotherboard(Motherboard motherboard){

        if (addMotherboard == null){
            addMotherboard = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<MotherboardResponse> call = apiService.addMotherboard(motherboard);
        call.enqueue(new Callback<MotherboardResponse>() {
            @Override
            public void onResponse(Call<MotherboardResponse> call, Response<MotherboardResponse> response) {
                if (response.body() != null){
                    addMotherboard.postValue(response.body());
                }
                else
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MotherboardResponse> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        return addMotherboard;
    }

    public MutableLiveData<MotherboardResponse> modifyMotherboard(Motherboard motherboard, String id){

        if (editMotherboard == null){
            editMotherboard = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<MotherboardResponse> call = apiService.modifyMotherboard(motherboard,id);
        call.enqueue(new Callback<MotherboardResponse>() {
            @Override
            public void onResponse(Call<MotherboardResponse> call, Response<MotherboardResponse> response) {
                if (response.body() != null){
                    editMotherboard.postValue(response.body());
                }

                Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MotherboardResponse> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        return editMotherboard;
    }

    public MutableLiveData<MotherboardResponse> deleteMotherboard(String id){

        if (deleteMotherboard == null){
            deleteMotherboard = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<MotherboardResponse> call = apiService.deleteMotherboard(id);
        call.enqueue(new Callback<MotherboardResponse>() {
            @Override
            public void onResponse(Call<MotherboardResponse> call, Response<MotherboardResponse> response) {
                if (response.body() != null){
                    deleteMotherboard.postValue(response.body());
                }
                else
                    Toast.makeText(ctx, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MotherboardResponse> call, Throwable t) {

                Toast.makeText(ctx, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        return deleteMotherboard;
    }



}
