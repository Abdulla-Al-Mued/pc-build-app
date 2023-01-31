package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.graphicsCardAdapter;
import com.example.easybuild.ViewModel.GraphicsCardViewModel;

public class GraphicsCard extends AppCompatActivity {

    RecyclerView recyclerView;
    com.example.easybuild.View.Adapter.graphicsCardAdapter graphicsCardAdapter;
    private GraphicsCardViewModel graphicsCardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_card);


        recyclerView = findViewById(R.id.gpuRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        graphicsCardViewModel = new ViewModelProvider(this).get(GraphicsCardViewModel.class);
        graphicsCardViewModel.graphicsCards().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {
                graphicsCardAdapter = new graphicsCardAdapter(getApplicationContext(), root.getGraphicscards());
                recyclerView.setAdapter(graphicsCardAdapter);
            }
        });

    }
}