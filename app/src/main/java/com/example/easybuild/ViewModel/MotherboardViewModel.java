package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.MotherboardResponse;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.MotherboardRepository;

public class MotherboardViewModel extends AndroidViewModel {

    private MotherboardRepository componentRepository;

    public MotherboardViewModel(@NonNull Application application) {
        super(application);

        componentRepository = MotherboardRepository.getInstance(application);

    }

    public MutableLiveData<Root> motherboard(){

        return componentRepository.motherboard();
    }

    public MutableLiveData<MotherboardResponse> addMotherboard(Motherboard motherboard){

        return componentRepository.addMotherboard(motherboard);
    }

    public MutableLiveData<MotherboardResponse> modifyMotherboard(Motherboard motherboard, String id){

        return componentRepository.modifyMotherboard(motherboard, id);
    }

    public MutableLiveData<MotherboardResponse> deleteMotherboard(String id){

        return componentRepository.deleteMotherboard(id);
    }

}
