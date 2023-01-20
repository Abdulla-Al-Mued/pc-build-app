package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Repository.PcBuildRepository;

public class PcBuildViewModel extends AndroidViewModel {

    private PcBuildRepository pcBuildRepository;

    public PcBuildViewModel(@NonNull Application application) {
        super(application);
        pcBuildRepository = PcBuildRepository.getInstance(application);
    }


    public LiveData<PcBuild> buildPc(double motherBoard, double processor, double ram,
                                            double storage, double powerSupply, double monitor){
        return pcBuildRepository.getPc(motherBoard, processor, ram, storage, powerSupply, monitor);
    }

    public LiveData<PcBuild> buildPcWithGpu(double motherBoard, double processor, double ram,
                                     double storage, double powerSupply, double monitor, double gpu){
        return pcBuildRepository.getPcWithGpu(motherBoard, processor, ram, storage, powerSupply, monitor, gpu);
    }

}
