package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.monitorAdapter;
import com.example.easybuild.ViewModel.MonitorViewModel;

public class Monitor extends AppCompatActivity {

    RecyclerView recyclerView;
    monitorAdapter monitorAdapter;
    MonitorViewModel monitorViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);

        recyclerView = findViewById(R.id.moniRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        monitorViewModel = new ViewModelProvider(this).get(MonitorViewModel.class);
        monitorViewModel.monitor().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                monitorAdapter = new monitorAdapter(getApplicationContext(), root.getMonitors());
                recyclerView.setAdapter(monitorAdapter);
            }
        });

    }
}