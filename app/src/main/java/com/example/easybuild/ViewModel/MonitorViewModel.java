package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.MonitorRepository;

public class MonitorViewModel extends AndroidViewModel {

    private MonitorRepository monitorRepository;

    public MonitorViewModel(@NonNull Application application) {
        super(application);
        monitorRepository = MonitorRepository.getInstance(application);
    }

    public MutableLiveData<Root> monitor(){
        return monitorRepository.monitors();
    }
}
