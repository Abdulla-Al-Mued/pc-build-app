package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Processor;
import com.example.easybuild.Service.Model.Ram1;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class RamDetails extends AppCompatActivity {


    Ram1 ram;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, MemoryType,BusSpeed, Capacity, price;
    Button cancel, update, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ram_details);


        tv = findViewById(R.id.details);
        btn = findViewById(R.id.editBtn);
        relativeLayout = findViewById(R.id.relativeLayout);
        linearLayout = findViewById(R.id.edit);

        cancel = findViewById(R.id.cancel);
        update = findViewById(R.id.update);
        remove = findViewById(R.id.delete);

        vendorName = findViewById(R.id.vendorName);
        model = findViewById(R.id.model);
        price = findViewById(R.id.price);
        MemoryType = findViewById(R.id.memoryType);
        BusSpeed = findViewById(R.id.busSpeed);
        Capacity = findViewById(R.id.Capacity);


        ram = (Ram1) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+ram.getModel()+"\n"+"Vendor Name : "+ram.getVendorName()+"\nMemory Type : "+ram.getMemoryType()+
                "\nPrice : "+ram.getPrice());


        Objects.requireNonNull(vendorName.getEditText()).setText(ram.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(ram.getModel());
        Objects.requireNonNull(MemoryType.getEditText()).setText(ram.getMemoryType());
        Objects.requireNonNull(BusSpeed.getEditText()).setText(ram.getBusSpeed().toString());
        Objects.requireNonNull(Capacity.getEditText()).setText(ram.getCapacity().toString());
        Objects.requireNonNull(price.getEditText()).setText(ram.getPrice().toString());



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.GONE);

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
            }
        });

    }
}