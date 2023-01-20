package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Model.Root;
import com.example.easybuild.View.Adapter.motherboardAdapter;
import com.example.easybuild.ViewModel.ComponentViewModel;
import com.example.easybuild.ViewModel.PcBuildViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MotherBoard extends AppCompatActivity {

    private AlertDialog.Builder dialogueBuilder;
    private AlertDialog dialog;
    Button close;
    RecyclerView recyclerView;
    motherboardAdapter adapter;
    private ComponentViewModel componentViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_board);

        FloatingActionButton motherBoard = findViewById(R.id.addMotherBoardFab);
        recyclerView = findViewById(R.id.mbRecView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        componentViewModel = new ViewModelProvider(this).get(ComponentViewModel.class);
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
                
                addRamDialog();

            }
        });

    }

    private void addRamDialog() {

        dialogueBuilder = new AlertDialog.Builder(this);
        final View addRamPopupView = getLayoutInflater().inflate(R.layout.add_mother_board, null);
        dialogueBuilder.setView(addRamPopupView);

        dialogueBuilder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                Toast.makeText(getApplicationContext(), "Press Cancel", Toast.LENGTH_SHORT).show();
                return i == keyEvent.KEYCODE_BACK;

            }
        });

        dialog = dialogueBuilder.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);

        close = addRamPopupView.findViewById(R.id.close);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });


    }
}