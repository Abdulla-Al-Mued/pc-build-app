package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Powersupply;

import java.util.List;

public class powerSupplyAdapter extends RecyclerView.Adapter<powerSupplyAdapter.ViewHolder> {


    private Context context;
    private List<Powersupply> powersupplies;

    public powerSupplyAdapter(Context context, List<Powersupply> powersupplies) {
        this.context = context;
        this.powersupplies = powersupplies;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new powerSupplyAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.component.setText("Model :"+powersupplies.get(position).getModel()+"\nPrice(tk) :"+powersupplies.get(position).getPrice()+"\n");
    }

    @Override
    public int getItemCount() {
        return powersupplies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);
        }
    }
}
