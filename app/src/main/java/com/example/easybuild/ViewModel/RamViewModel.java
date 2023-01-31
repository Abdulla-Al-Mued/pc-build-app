package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.RamRepository;

public class RamViewModel extends AndroidViewModel {

    private RamRepository ramRepository;

    public RamViewModel(@NonNull Application application) {
        super(application);
        ramRepository = RamRepository.getInstance(application);
    }

    public MutableLiveData<Root> ram(){
        return ramRepository.rams();
    }
}
