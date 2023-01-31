package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Monitor;

import java.util.List;

public class monitorAdapter extends RecyclerView.Adapter<monitorAdapter.ViewHolder>{

    private Context context;
    private List<Monitor> monitors;

    public monitorAdapter(Context context, List<Monitor> monitors) {
        this.context = context;
        this.monitors = monitors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new monitorAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.component.setText("Model :"+monitors.get(position).getModel()+"\nPrice(tk) :"+monitors.get(position).getPrice()+"\n");

    }

    @Override
    public int getItemCount() {
        return monitors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);
        }
    }

}
