package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.StorageRepository;

public class StorageViewModel extends AndroidViewModel {

    private StorageRepository storageRepository;

    public StorageViewModel(@NonNull Application application) {
        super(application);
        storageRepository = StorageRepository.getInstance(application);
    }

    public MutableLiveData<Root> storage(){
        return storageRepository.storage();
    }
}
