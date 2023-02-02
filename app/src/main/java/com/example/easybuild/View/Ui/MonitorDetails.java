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
import com.example.easybuild.Service.Model.Monitor;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class MonitorDetails extends AppCompatActivity {


    Monitor monitor;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, Resolution, DisplayInHz, price;
    Button cancel, update, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor_details);


        tv = findViewById(R.id.details);
        btn = findViewById(R.id.editBtn);
        relativeLayout = findViewById(R.id.relativeLayout);
        linearLayout = findViewById(R.id.edit);

        cancel = findViewById(R.id.cancel);
        update = findViewById(R.id.update);
        remove = findViewById(R.id.delete);

        vendorName = findViewById(R.id.vendorName);
        model = findViewById(R.id.model);
        Resolution = findViewById(R.id.resolution);
        DisplayInHz = findViewById(R.id.displayInHz);
        price = findViewById(R.id.price);

        monitor = (Monitor) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+monitor.getModel()+"\n"+"Vendor Name : "+monitor.getVendorName()+"\nMemory Type : "+monitor.getDisplayInHz()
                +"\nMax Memory : "+monitor.getResolution()+"\nPrice : "+monitor.getPrice());

        Objects.requireNonNull(vendorName.getEditText()).setText(monitor.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(monitor.getModel());
        Objects.requireNonNull(Resolution.getEditText()).setText(monitor.getResolution());
        Objects.requireNonNull(DisplayInHz.getEditText()).setText(monitor.getDisplayInHz().toString());
        Objects.requireNonNull(price.getEditText()).setText(monitor.getPrice().toString());



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