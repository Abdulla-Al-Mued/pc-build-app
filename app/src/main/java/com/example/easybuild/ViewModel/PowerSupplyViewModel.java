package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.PowerSupplyRepository;

public class PowerSupplyViewModel extends AndroidViewModel {

    private PowerSupplyRepository powerSupplyRepository;

    public PowerSupplyViewModel(@NonNull Application application) {
        super(application);
        powerSupplyRepository = PowerSupplyRepository.getInstance(application);
    }

    public MutableLiveData<Root> powerSupply(){
        return powerSupplyRepository.powerSupply();
    }
}
