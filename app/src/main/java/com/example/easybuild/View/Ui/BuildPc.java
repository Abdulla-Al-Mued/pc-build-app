package com.example.easybuild.View.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.easybuild.MainActivity;
import com.example.easybuild.R;
import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.ViewModel.PcBuildViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class BuildPc extends AppCompatActivity {

    TextInputLayout budget;
    private PcBuildViewModel pcBuildViewModel;
    Button build;
    double motherboard, processor, ram, storage, power, monitor, totalBudget;
    double motherboardBudget, processorBudget, ramBudget, storageBudget, powerBudget, monitorBudget;
    TextView message, mb, pro, rm, st, ps, mon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build_pc);

        budget = findViewById(R.id.budget);
        build = findViewById(R.id.build);
        message = findViewById(R.id.message);
        mb = findViewById(R.id.motherboard);
        pro = findViewById(R.id.Processor);
        rm = findViewById(R.id.Ram);
        st = findViewById(R.id.storage);
        ps = findViewById(R.id.powerSupply);
        mon = findViewById(R.id.monitor);


        motherboard = 0.13;
        processor = 0.30;
        ram = 0.10;
        storage = 0.17;
        power = 0.08;
        monitor = 0.22;

        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getAllComponent();

            }
        });


    }

    private void getAllComponent() {

        String bgt = budget.getEditText().getText().toString().trim();

        if (bgt.isEmpty()){
            budget.getEditText().setError("Field cannot be empty");
            return;
        }

        totalBudget = Double.parseDouble(bgt);

        motherboardBudget = totalBudget * motherboard;
        processorBudget = totalBudget * processor;
        ramBudget = totalBudget * ram;
        storageBudget = totalBudget * storage;
        powerBudget = totalBudget * power;
        monitorBudget = totalBudget * monitor;



        pcBuildViewModel = new ViewModelProvider(this).get(PcBuildViewModel.class);
        pcBuildViewModel.buildPc(motherboardBudget, processorBudget, ramBudget, storageBudget, powerBudget, monitorBudget)
                .observe(this, new Observer<PcBuild>() {
                    @Override
                    public void onChanged(PcBuild pcBuild) {
                        double tp = 0;

                        if (pcBuild.getSuccess()){

                            tp = +pcBuild.getMotherboard().get(0).getPrice()+pcBuild.getProcessor().get(0).getPrice()
                                    +pcBuild.getRam().get(0).getPriceTk()+pcBuild.getStorage().get(0).getPrice()+pcBuild.getPowerSupply().get(0).getPrice()+pcBuild.getMonitor().get(0).getPrice();

                            mb.setText("Model :"+pcBuild.getMotherboard().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getMotherboard().get(0).getPrice()+"\n"+motherboardBudget);
                            pro.setText("Model :"+pcBuild.getProcessor().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getProcessor().get(0).getPrice()+"\n"+processorBudget);
                            rm.setText("Model :"+pcBuild.getRam().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getRam().get(0).getPriceTk()+"\n"+ramBudget);
                            st.setText("Model :"+pcBuild.getStorage().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getStorage().get(0).getPrice()+"\n"+storageBudget);
                            ps.setText("Model :"+pcBuild.getPowerSupply().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getPowerSupply().get(0).getPrice()+"\n"+powerBudget);
                            mon.setText("Model :"+pcBuild.getMonitor().get(0).getModel()+"\nPrice(tk) :"+pcBuild.getMonitor().get(0).getPrice()+"\n"+monitorBudget);

                        }



                        message.setText(pcBuild.getMsg()+"\n total :"+tp);

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
        else if(item_id == R.id.login){

            startActivity(new Intent(getApplicationContext(), MainActivity.class));

        }
        else if (item_id == R.id.logout){

        }
        else if (item_id == R.id.component){

            startActivity(new Intent(getApplicationContext(), Component.class));

        }
        else {
            return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        MenuItem home = menu.findItem(R.id.home);
        MenuItem logOut = menu.findItem(R.id.logout);
        logOut.setVisible(false);
        home.setVisible(false);
        return true;
    }
}