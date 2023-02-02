package com.example.easybuild.View.Ui;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.MotherboardResponse;
import com.example.easybuild.ViewModel.MotherboardViewModel;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MotherboardDetails extends AppCompatActivity {

    Motherboard motherBoard;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, memoryType, memorySlots, maxMemory, price, supportedCpu;
    Button cancel, update, remove;
    private MotherboardViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motherboard_details);


        tv = findViewById(R.id.details);
        btn = findViewById(R.id.editBtn);
        relativeLayout = findViewById(R.id.relativeLayout);
        linearLayout = findViewById(R.id.edit);

        vendorName = findViewById(R.id.vendorName);
        model = findViewById(R.id.model);
        memoryType = findViewById(R.id.memoryType);
        memorySlots = findViewById(R.id.memorySlots);
        maxMemory = findViewById(R.id.maxMemory);
        price = findViewById(R.id.price);
        supportedCpu = findViewById(R.id.supportedCPU);

        cancel = findViewById(R.id.cancel);
        update = findViewById(R.id.update);
        remove = findViewById(R.id.delete);



        motherBoard = (Motherboard) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+motherBoard.getModel()+"\n"+"Vendor Name : "+motherBoard.getVendorName()+"\nMemory Type : "+motherBoard.getMemoryType()
        +"\nMemory Slots : "+motherBoard.getMemorySlots()+"\nMax Memory : "+motherBoard.getMaxMemory()+"\nPrice : "+motherBoard.getPrice()+"\nSupported Cpu : "+motherBoard.getSupportedCPU());


        Objects.requireNonNull(vendorName.getEditText()).setText(motherBoard.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(motherBoard.getModel());
        Objects.requireNonNull(memoryType.getEditText()).setText(motherBoard.getMemoryType());
        Objects.requireNonNull(memorySlots.getEditText()).setText(motherBoard.getMemorySlots().toString());
        Objects.requireNonNull(maxMemory.getEditText()).setText(motherBoard.getMaxMemory().toString());
        Objects.requireNonNull(price.getEditText()).setText(motherBoard.getPrice().toString());
        Objects.requireNonNull(supportedCpu.getEditText()).setText(motherBoard.getSupportedCPU());


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


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeMotherboard(motherBoard.getId());

            }
        });



        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer slot = 0, max = 0, pric = 0;

                try {
                    slot = Integer.parseInt(memorySlots.getEditText().getText().toString());
                    max = Integer.parseInt(maxMemory.getEditText().getText().toString());
                    pric = Integer.parseInt(price.getEditText().getText().toString());

                }catch (Exception e){

                }

                Motherboard mb = new Motherboard(
                        vendorName.getEditText().getText().toString(),
                        model.getEditText().getText().toString(),
                        memoryType.getEditText().getText().toString(),
                        slot,
                        max,
                        pric,
                        supportedCpu.getEditText().getText().toString()
                );
                updateMotherboard(mb, motherBoard.getId());
            }
        });



    }

    private void removeMotherboard(String id) {
        componentViewModel = new ViewModelProvider(this).get(MotherboardViewModel.class);
        componentViewModel.deleteMotherboard(id).observe(this, new Observer<MotherboardResponse>() {
            @Override
            public void onChanged(MotherboardResponse motherboardResponse) {
                Toast.makeText(getApplicationContext(), motherboardResponse.getMsg(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MotherBoard.class));
            }
        });
    }

    private void updateMotherboard(Motherboard motherboard, String id) {

        componentViewModel = new ViewModelProvider(this).get(MotherboardViewModel.class);
        componentViewModel.modifyMotherboard(motherboard, id).observe(this, new Observer<MotherboardResponse>() {
            @Override
            public void onChanged(MotherboardResponse motherboardResponse) {
                Toast.makeText(getApplicationContext(), motherboardResponse.getMsg(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), MotherBoard.class));
            }
        });

    }
}