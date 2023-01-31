package com.example.easybuild.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.Service.Repository.GraphicsCardRepository;

public class GraphicsCardViewModel extends AndroidViewModel {

    private GraphicsCardRepository graphicsCardRepository;

    public GraphicsCardViewModel(@NonNull Application application) {
        super(application);
        graphicsCardRepository = GraphicsCardRepository.getInstance(application);
    }

    public MutableLiveData<Root> graphicsCards(){
        return graphicsCardRepository.graphicsCard();
    }
}
