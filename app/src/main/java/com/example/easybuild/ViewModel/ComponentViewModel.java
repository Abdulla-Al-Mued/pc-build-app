package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.ComponentRepository;

public class ComponentViewModel extends AndroidViewModel {

    private ComponentRepository componentRepository;

    public ComponentViewModel(@NonNull Application application) {
        super(application);

        componentRepository = ComponentRepository.getInstance(application);

    }

    public MutableLiveData<Root> motherboard(){

        return componentRepository.motherboard();
    }

}
