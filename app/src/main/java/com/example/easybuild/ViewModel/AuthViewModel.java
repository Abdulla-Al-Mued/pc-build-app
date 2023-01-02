package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.User;
import com.example.easybuild.Service.Repository.AuthRepository;

public class AuthViewModel extends AndroidViewModel {

    private AuthRepository authRepository;

    public AuthViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance(application);
    }

    public LiveData<RegisterResponse> userRegistered(User user){
        return authRepository.registerUser(user);
    }

    public LiveData<RegisterResponse> userLogIn(User user){
        return authRepository.logIn(user);
    }

}
