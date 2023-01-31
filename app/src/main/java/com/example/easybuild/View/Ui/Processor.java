package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.processorAdapter;
import com.example.easybuild.ViewModel.PowerSupplyViewModel;
import com.example.easybuild.ViewModel.ProcessorViewModel;

public class Processor extends AppCompatActivity {

    RecyclerView recyclerView;
    com.example.easybuild.View.Adapter.processorAdapter processorAdapter;
    ProcessorViewModel processorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor);

        recyclerView =findViewById(R.id.proRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        processorViewModel = new ViewModelProvider(this).get(ProcessorViewModel.class);
        processorViewModel.processor().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                processorAdapter = new processorAdapter(getApplicationContext(), root.getProcessors());
                recyclerView.setAdapter(processorAdapter);
            }
        });

    }
}