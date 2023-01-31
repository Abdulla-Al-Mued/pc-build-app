package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.ramAdapter;
import com.example.easybuild.ViewModel.RamViewModel;

public class Ram extends AppCompatActivity {

    com.example.easybuild.View.Adapter.ramAdapter ramAdapter;
    RecyclerView recyclerView;
    RamViewModel ramViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram);

        recyclerView = findViewById(R.id.ramRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ramViewModel = new ViewModelProvider(this).get(RamViewModel.class);
        ramViewModel.ram().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                ramAdapter = new ramAdapter(getApplicationContext(), root.getRams());
                recyclerView.setAdapter(ramAdapter);
            }
        });

    }
}