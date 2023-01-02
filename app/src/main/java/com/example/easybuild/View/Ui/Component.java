package com.example.easybuild.View.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.easybuild.MainActivity;
import com.example.easybuild.R;

public class Component extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        CardView cardView = findViewById(R.id.motherboard);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MotherBoard.class));
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_item, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.setting){

        }
        else if (item_id == R.id.logout){

        }
        else if (item_id == R.id.home){
            startActivity(new Intent(getApplicationContext(), BuildPc.class));
        }
        else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem component = menu.findItem(R.id.component);
        MenuItem login = menu.findItem(R.id.login);
        MenuItem setting = menu.findItem(R.id.setting);

        login.setVisible(false);
        setting.setVisible(false);
        component.setVisible(false);

        return true;
    }
}