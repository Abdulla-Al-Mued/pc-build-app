package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.powerSupplyAdapter;
import com.example.easybuild.ViewModel.PowerSupplyViewModel;

public class PowerSupply extends AppCompatActivity {

    RecyclerView recyclerView;
    PowerSupplyViewModel powerSupplyViewModel;
    powerSupplyAdapter powersupplyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_supply);

        recyclerView = findViewById(R.id.powerRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        powerSupplyViewModel = new ViewModelProvider(this).get(PowerSupplyViewModel.class);
        powerSupplyViewModel.powerSupply().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                powersupplyAdapter = new powerSupplyAdapter(getApplicationContext(), root.getPowersupplies());
                recyclerView.setAdapter(powersupplyAdapter);
            }
        });

    }
}