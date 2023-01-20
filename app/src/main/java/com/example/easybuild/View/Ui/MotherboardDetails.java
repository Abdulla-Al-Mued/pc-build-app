package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Motherboard;

public class MotherboardDetails extends AppCompatActivity {

    Motherboard motherBoard;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard_details);


        tv = findViewById(R.id.details);


        motherBoard = (Motherboard) getIntent().getSerializableExtra("product");

        tv.setText(motherBoard.getModel()+"\n"+motherBoard.getVendorName());

    }
}