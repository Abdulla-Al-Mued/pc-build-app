package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.ProcessorRepository;

public class ProcessorViewModel extends AndroidViewModel {

    private ProcessorRepository processorRepository;

    public ProcessorViewModel(@NonNull Application application) {
        super(application);
        processorRepository = ProcessorRepository.getInstance(application);
    }

    public MutableLiveData<Root> processor(){
        return processorRepository.processors();
    }
}
