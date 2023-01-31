package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Ssd;

import java.util.List;

public class storageAdapter extends RecyclerView.Adapter<storageAdapter.ViewHolder>{

    private Context context;
    private List<Ssd> storages;

    public storageAdapter(Context context, List<Ssd> storages) {
        this.context = context;
        this.storages = storages;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new storageAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.component.setText("Model :"+storages.get(position).getModel()+"\nPrice(tk) :"+storages.get(position).getPrice()+"\n");
    }

    @Override
    public int getItemCount() {
        return storages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);
        }
    }
}
