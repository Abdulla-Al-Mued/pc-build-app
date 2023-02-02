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
import com.example.easybuild.Service.Model.Processor;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class ProcessorDetails extends AppCompatActivity {

    Processor processor;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, Cores,Threads, Series, VideoRam, price;
    Button cancel, update, remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processor_details);


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
        Cores = findViewById(R.id.cores);
        Threads = findViewById(R.id.threads);
        Series = findViewById(R.id.series);
        VideoRam = findViewById(R.id.videoRam);


        processor = (Processor) getIntent().getSerializableExtra("product");


        tv.setText("Model : "+processor.getModel()+"\n"+"Vendor Name : "+processor.getVendorName()+"\nCores : "+processor.getCores()
                +"\nGen : "+processor.getSeries()+"\nPrice : "+processor.getPrice());


        Objects.requireNonNull(vendorName.getEditText()).setText(processor.getVendorName());
        Objects.requireNonNull(model.getEditText()).setText(processor.getModel());
        Objects.requireNonNull(Cores.getEditText()).setText(processor.getCores().toString());
        Objects.requireNonNull(Threads.getEditText()).setText(processor.getThreads().toString());
        Objects.requireNonNull(Series.getEditText()).setText(processor.getSeries().toString());
        Objects.requireNonNull(VideoRam.getEditText()).setText(processor.getVideoRam());
        Objects.requireNonNull(price.getEditText()).setText(processor.getPrice().toString());



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