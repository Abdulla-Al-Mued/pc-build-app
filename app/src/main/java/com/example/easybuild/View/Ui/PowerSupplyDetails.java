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
import com.example.easybuild.Service.Model.Powersupply;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class PowerSupplyDetails extends AppCompatActivity {

    Powersupply powersupply;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, PowerInW, price;
    Button cancel, update, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_supply_details);


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
        PowerInW = findViewById(R.id.powerInW);

        powersupply = (Powersupply) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+powersupply.getModel()+"\n"+"Vendor Name : "+powersupply.getVendorName()+"\nPower in watt : "+powersupply.getPowerInW()
                +"\nPrice : "+powersupply.getPrice());


        Objects.requireNonNull(vendorName.getEditText()).setText(powersupply.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(powersupply.getModel());
        Objects.requireNonNull(PowerInW.getEditText()).setText(powersupply.getPowerInW().toString());
        Objects.requireNonNull(price.getEditText()).setText(powersupply.getPrice().toString());



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