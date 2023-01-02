package com.example.easybuild.Service.Repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.User;
import com.example.easybuild.Service.Network.ApiService;
import com.example.easybuild.Service.Network.RetroInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthRepository {

    private static AuthRepository instance = null;
    private static Context context;
    private static MutableLiveData<RegisterResponse> registerResponse;
    private static MutableLiveData<RegisterResponse> logInResponse;

    public static AuthRepository getInstance(Context ctx){

        if (instance == null){
            context = ctx;
            instance = new AuthRepository();
        }

        return instance;
    }

    public LiveData<RegisterResponse> registerUser(User user){

        if (registerResponse == null){
            registerResponse = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<RegisterResponse> call = apiService.register(user);
        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null){
                    registerResponse.postValue(response.body());
                }
                else
                    Toast.makeText(context, "Data not found", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

        return registerResponse;
    }


    public LiveData<RegisterResponse> logIn(User user){

        if(logInResponse == null){
            logInResponse = new MutableLiveData<>();
        }

        ApiService apiService = RetroInstance.getRetroInstance().create(ApiService.class);
        Call<RegisterResponse> call = apiService.logIn(user);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.body() != null){
                    logInResponse.postValue(response.body());
                }
                else
                    Toast.makeText(context, "Data not found", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                Toast.makeText(context, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return logInResponse;
    }



}
