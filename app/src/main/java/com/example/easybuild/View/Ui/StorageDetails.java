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
import com.example.easybuild.Service.Model.Ram1;
import com.example.easybuild.Service.Model.Ssd;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class StorageDetails extends AppCompatActivity {

    Ssd storage;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, Type, Interface, Capacity, price;
    Button cancel, update, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage_details);


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
        Type = findViewById(R.id.Type);
        Interface = findViewById(R.id.Interface);
        Capacity = findViewById(R.id.Capacity);


        storage = (Ssd) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+storage.getModel()+"\n"+"Vendor Name : "+storage.getVendorName()+"\nCapacity : "+storage.getCapacity()+
                "\nPrice : "+storage.getPrice());


        Objects.requireNonNull(vendorName.getEditText()).setText(storage.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(storage.getModel());
        Objects.requireNonNull(Type.getEditText()).setText(storage.getType());
        Objects.requireNonNull(Interface.getEditText()).setText(storage.getInterface());
        Objects.requireNonNull(Capacity.getEditText()).setText(storage.getCapacity());
        Objects.requireNonNull(price.getEditText()).setText(storage.getPrice().toString());



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