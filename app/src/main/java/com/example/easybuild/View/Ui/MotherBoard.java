package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.easybuild.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MotherBoard extends AppCompatActivity {

    private AlertDialog.Builder dialogueBuilder;
    private AlertDialog dialog;
    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_board);

        FloatingActionButton motherBoard = findViewById(R.id.addMotherBoardFab);
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