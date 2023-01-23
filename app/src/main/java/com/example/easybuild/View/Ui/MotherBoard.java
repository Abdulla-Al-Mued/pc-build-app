package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.MotherboardResponse;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.motherboardAdapter;
import com.example.easybuild.ViewModel.MotherboardViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

public class MotherBoard extends AppCompatActivity {

    private AlertDialog.Builder dialogueBuilder;
    private AlertDialog dialog;
    Button close, add;
    RecyclerView recyclerView;
    motherboardAdapter adapter;
    private MotherboardViewModel componentViewModel;
    TextInputLayout vendorName, model, memoryType, memorySlots, maxMemory, price, supportedCpu;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_board);

        FloatingActionButton motherBoard = findViewById(R.id.addMotherBoardFab);
        recyclerView = findViewById(R.id.mbRecView);
        context = this;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        componentViewModel = new ViewModelProvider(this).get(MotherboardViewModel.class);
        componentViewModel.motherboard().observe(this, new Observer<Root>() {
            @Override
            public void onChanged(Root root) {

                adapter = new motherboardAdapter(getApplicationContext(), root.getMotherboard());
                recyclerView.setAdapter(adapter);

            }
        });


        motherBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                addMotherboardDialog();

            }
        });

    }

    private void addMotherboardDialog() {

        dialogueBuilder = new AlertDialog.Builder(this);
        final View addMotherboardPopupView = getLayoutInflater().inflate(R.layout.add_mother_board, null);
        dialogueBuilder.setView(addMotherboardPopupView);

        dialogueBuilder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                //Toast.makeText(getApplicationContext(), "Press Cancel", Toast.LENGTH_SHORT).show();
                return i == keyEvent.KEYCODE_BACK;

            }
        });

        dialog = dialogueBuilder.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

        close = addMotherboardPopupView.findViewById(R.id.close);
        add = addMotherboardPopupView.findViewById(R.id.ok);
        vendorName = addMotherboardPopupView.findViewById(R.id.vendorName);
        model = addMotherboardPopupView.findViewById(R.id.model);
        memoryType = addMotherboardPopupView.findViewById(R.id.memoryType);
        memorySlots = addMotherboardPopupView.findViewById(R.id.memorySlots);
        maxMemory = addMotherboardPopupView.findViewById(R.id.maxMemory);
        price = addMotherboardPopupView.findViewById(R.id.price);
        supportedCpu = addMotherboardPopupView.findViewById(R.id.supportedCPU);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer slot = 0, max = 0, pric = 0;

                try {
                    slot = Integer.parseInt(memorySlots.getEditText().getText().toString());
                    max = Integer.parseInt(maxMemory.getEditText().getText().toString());
                    pric = Integer.parseInt(price.getEditText().getText().toString());

                }catch (Exception e){

                }

                Motherboard motherBoard = new Motherboard(
                        vendorName.getEditText().getText().toString(),
                        model.getEditText().getText().toString(),
                        memoryType.getEditText().getText().toString(),
                        slot,
                        max,
                        pric,
                        supportedCpu.getEditText().getText().toString()
                );
//                Motherboard motherBoard = new Motherboard(
//                        "vendorName.getEditText().getText().toString()",
//                        "model.getEditText().getText().toString()",
//                        "memoryType.getEditText().getText().toString()",
//                        2,
//                        256,
//                        1121,
//                        "supportedCpu.getEditText().getText().toString()"
//                );

                addMb(motherBoard);
                dialog.dismiss();

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });


    }

    public void addMb(Motherboard motherboard) {
        componentViewModel = new ViewModelProvider(this).get(MotherboardViewModel.class);
        componentViewModel.addMotherboard(motherboard).observe(this, new Observer<MotherboardResponse>() {
            @Override
            public void onChanged(MotherboardResponse motherboardResponse) {

                Toast.makeText(getApplicationContext(), motherboardResponse.getMsg(), Toast.LENGTH_SHORT).show();

            }
        });
    }


}