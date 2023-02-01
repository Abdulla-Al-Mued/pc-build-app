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
import com.example.easybuild.Service.Model.Graphicscard;
import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.ViewModel.GraphicsCardViewModel;
import com.example.easybuild.ViewModel.MotherboardViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class GraphicsCardDetails extends AppCompatActivity {

    Graphicscard graphicscard;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout;
    TextView tv;
    ImageView btn;
    TextInputLayout vendorName, model, Type, capacity, resolution, price;
    Button cancel, update, remove;
    private GraphicsCardViewModel graphicsCardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics_card_details);

        tv = findViewById(R.id.details);
        btn = findViewById(R.id.editBtn);
        relativeLayout = findViewById(R.id.relativeLayout);
        linearLayout = findViewById(R.id.edit);

        cancel = findViewById(R.id.cancel);
        update = findViewById(R.id.update);
        remove = findViewById(R.id.delete);

        vendorName = findViewById(R.id.vendorName);
        model = findViewById(R.id.model);
        Type = findViewById(R.id.type);
        capacity = findViewById(R.id.capacity);
        resolution = findViewById(R.id.resolution);
        price = findViewById(R.id.price);

        graphicscard = (Graphicscard) getIntent().getSerializableExtra("product");

        tv.setText("Model : "+graphicscard.getModel()+"\n"+"Vendor Name : "+graphicscard.getVendorName()+"\nMemory Type : "+graphicscard.getType()
                +"\nMemory Slots : "+graphicscard.getCapacity()+"\nMax Memory : "+graphicscard.getResolution()+"\nPrice : "+graphicscard.getPrice());



        vendorName.getEditText().setText(graphicscard.getVendorName());
        model.getEditText().setText(graphicscard.getModel());
        Type.getEditText().setText(graphicscard.getType());
        capacity.getEditText().setText(graphicscard.getCapacity());
        resolution.getEditText().setText(graphicscard.getResolution());
        price.getEditText().setText(graphicscard.getPrice());


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linearLayout.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.GONE);

            }
        });


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeData(graphicscard.getId());
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer pric = 0;

                try {
                    pric = Integer.parseInt(price.getEditText().getText().toString());

                }catch (Exception e){

                }

                Graphicscard gpu = new Graphicscard(
                        vendorName.getEditText().getText().toString(),
                        model.getEditText().getText().toString(),
                        Type.getEditText().getText().toString(),
                        capacity.getEditText().getText().toString(),
                        resolution.getEditText().getText().toString(),
                        pric
                );


                updateData(graphicscard.getId(), gpu);
            }
        });


    }

    private void updateData(String id, Graphicscard gpu) {

    }

    private void removeData(String id) {

    }
}