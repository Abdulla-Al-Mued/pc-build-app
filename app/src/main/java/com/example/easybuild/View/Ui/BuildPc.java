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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.easybuild.MainActivity;
import com.example.easybuild.R;
import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.ViewModel.PcBuildViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class BuildPc extends AppCompatActivity {

    TextInputLayout budget;
    LinearLayout gpuLayout;
    String bgt;
    private PcBuildViewModel pcBuildViewModel;
    Button build;
    double motherboard, processor, ram, storage, power, monitor, gpu, totalBudget;
    double motherboardBudget, processorBudget, ramBudget, storageBudget, powerBudget, monitorBudget, gpuBudget;
    TextView message, mb, pro, rm, rm2, ssd, hdd, ps, mon, Gpu;

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
        rm2 = findViewById(R.id.Ram2);
        ssd = findViewById(R.id.ssd);
        hdd= findViewById(R.id.hdd);
        Gpu = findViewById(R.id.graphicsCard);
        gpuLayout = findViewById(R.id.gpuLayout);

        ps = findViewById(R.id.powerSupply);
        mon = findViewById(R.id.monitor);

        motherboard = 0.16;
        processor = 0.30;
        ram = 0.10;
        storage = 0.17;
        power = 0.08;
        monitor = 0.22;
        gpu = 0.30;


        build.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bgt = budget.getEditText().getText().toString().trim();

                if (bgt.isEmpty()){
                    budget.getEditText().setError("Field cannot be empty");
                    return;
                }

                gpuLayout.setVisibility(View.GONE);

                totalBudget = Double.parseDouble(bgt);
                motherboardBudget = totalBudget * motherboard;
                processorBudget = totalBudget * processor;
                ramBudget = totalBudget * ram;
                storageBudget = totalBudget * storage;
                powerBudget = totalBudget * power;
                monitorBudget = totalBudget * monitor;
                gpuBudget = totalBudget * gpu;

                if (totalBudget>67000){

                    gpuLayout.setVisibility(View.VISIBLE);

                    getComponentWithGpu();

                }else {

                    getAllComponent();

                }

            }
        });


    }

    private void getComponentWithGpu() {

        pcBuildViewModel = new ViewModelProvider(this).get(PcBuildViewModel.class);
        pcBuildViewModel.buildPcWithGpu(motherboardBudget, processorBudget, ramBudget, storageBudget, powerBudget, monitorBudget, gpuBudget)
                .observe(this, new Observer<PcBuild>() {
                    @Override
                    public void onChanged(PcBuild pcBuild) {


                        if (pcBuild.getSuccess()){

                            mb.setText("Model :"+pcBuild.getMotherboard().getModel()+"\nPrice(tk) :"+pcBuild.getMotherboard().getPrice()+"\n"+motherboardBudget);
                            pro.setText("Model :"+pcBuild.getProcessor().getModel()+"\nPrice(tk) :"+pcBuild.getProcessor().getPrice()+"\n"+processorBudget);
                            rm.setText("Model :"+pcBuild.getRam1().getModel()+"\nPrice(tk) :"+pcBuild.getRam1().getPrice()+"\n"+ramBudget);
                            rm2.setText("Model :"+pcBuild.getRam2().getModel()+"\nPrice(tk) :"+pcBuild.getRam2().getPrice()+"\n"+ramBudget);
                            ssd.setText("Model :"+pcBuild.getSsd().getModel()+"\nPrice(tk) :"+pcBuild.getSsd().getPrice()+"\n"+storageBudget);
                            hdd.setText("Model :"+pcBuild.getHdd().getModel()+"\nPrice(tk) :"+pcBuild.getHdd().getPrice()+"\n"+storageBudget);
                            ps.setText("Model :"+pcBuild.getPowersupply().getModel()+"\nPrice(tk) :"+pcBuild.getPowersupply().getPrice()+"\n"+powerBudget);
                            mon.setText("Model :"+pcBuild.getMonitor().getModel()+"\nPrice(tk) :"+pcBuild.getMonitor().getPrice()+"\n"+monitorBudget);
                            Gpu.setText("Model :"+pcBuild.getGraphicscard().getModel()+"\nPrice(tk) :"+pcBuild.getGraphicscard().getPrice()+"\n"+monitorBudget);

                        }

                        message.setText(pcBuild.getMsg()+"\n total :"+pcBuild.getTotalBudget());

                    }
                });

    }

    private void getAllComponent() {

        pcBuildViewModel = new ViewModelProvider(this).get(PcBuildViewModel.class);
        pcBuildViewModel.buildPc(motherboardBudget, processorBudget, ramBudget, storageBudget, powerBudget, monitorBudget)
                .observe(this, new Observer<PcBuild>() {
                    @Override
                    public void onChanged(PcBuild pcBuild) {


                        if (pcBuild.getSuccess()){

                            if (ramBudget<3600){
                                mb.setText("Model :"+pcBuild.getMotherboard().getModel()+"\nPrice(tk) :"+pcBuild.getMotherboard().getPrice()+"\n"+motherboardBudget);
                                pro.setText("Model :"+pcBuild.getProcessor().getModel()+"\nPrice(tk) :"+pcBuild.getProcessor().getPrice()+"\n"+processorBudget);
                                rm.setText("Model :"+pcBuild.getRam1().getModel()+"\nPrice(tk) :"+pcBuild.getRam1().getPrice()+"\n"+ramBudget);
                                ssd.setText("Model :"+pcBuild.getSsd().getModel()+"\nPrice(tk) :"+pcBuild.getSsd().getPrice()+"\n"+storageBudget);
                                hdd.setText("Model :"+pcBuild.getHdd().getModel()+"\nPrice(tk) :"+pcBuild.getHdd().getPrice()+"\n"+storageBudget);
                                ps.setText("Model :"+pcBuild.getPowersupply().getModel()+"\nPrice(tk) :"+pcBuild.getPowersupply().getPrice()+"\n"+powerBudget);
                                mon.setText("Model :"+pcBuild.getMonitor().getModel()+"\nPrice(tk) :"+pcBuild.getMonitor().getPrice()+"\n"+monitorBudget);

                            }
                            else {

                                mb.setText("Model :"+pcBuild.getMotherboard().getModel()+"\nPrice(tk) :"+pcBuild.getMotherboard().getPrice()+"\n"+motherboardBudget);
                                pro.setText("Model :"+pcBuild.getProcessor().getModel()+"\nPrice(tk) :"+pcBuild.getProcessor().getPrice()+"\n"+processorBudget);
                                rm.setText("Model :"+pcBuild.getRam1().getModel()+"\nPrice(tk) :"+pcBuild.getRam1().getPrice()+"\n"+ramBudget);
                                rm2.setText("Model :"+pcBuild.getRam2().getModel()+"\nPrice(tk) :"+pcBuild.getRam2().getPrice()+"\n"+ramBudget);
                                ssd.setText("Model :"+pcBuild.getSsd().getModel()+"\nPrice(tk) :"+pcBuild.getSsd().getPrice()+"\n"+storageBudget);
                                hdd.setText("Model :"+pcBuild.getHdd().getModel()+"\nPrice(tk) :"+pcBuild.getHdd().getPrice()+"\n"+storageBudget);
                                ps.setText("Model :"+pcBuild.getPowersupply().getModel()+"\nPrice(tk) :"+pcBuild.getPowersupply().getPrice()+"\n"+powerBudget);
                                mon.setText("Model :"+pcBuild.getMonitor().getModel()+"\nPrice(tk) :"+pcBuild.getMonitor().getPrice()+"\n"+monitorBudget);

                            }

                        }



                        message.setText(pcBuild.getMsg()+"\n total :"+pcBuild.getTotalBudget());

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