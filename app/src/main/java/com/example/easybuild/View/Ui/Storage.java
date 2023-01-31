package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.storageAdapter;
import com.example.easybuild.ViewModel.StorageViewModel;

public class Storage extends AppCompatActivity {

    RecyclerView recyclerView;
    StorageViewModel storageViewModel;
    storageAdapter storageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);

        recyclerView = findViewById(R.id.storeRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        storageViewModel = new ViewModelProvider(this).get(StorageViewModel.class);
        storageViewModel.storage().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                storageAdapter = new storageAdapter(getApplicationContext(), root.getStorages());
                recyclerView.setAdapter(storageAdapter);
            }
        });

    }
}