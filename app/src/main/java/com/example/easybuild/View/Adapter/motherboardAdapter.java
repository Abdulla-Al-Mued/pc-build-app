package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.Service.Model.PcBuild;
import com.example.easybuild.Service.Model.Root;

import java.util.List;

public class motherboardAdapter extends RecyclerView.Adapter<motherboardAdapter.ViewHolder> {

    private Context ctx;
    private List<Motherboard> motherboards;

    public motherboardAdapter(Context ctx, List<Motherboard> motherboard) {
        this.ctx = ctx;
        this.motherboards = motherboard;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(ctx).inflate(R.layout.motherboard_single_row, null, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.component.setText("Model :"+motherboards.get(position).getModel()+"\nPrice(tk) :"+motherboards.get(position).getPrice()+"\n");

    }

    @Override
    public int getItemCount() {
        return motherboards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            component = itemView.findViewById(R.id.motherboard);

        }
    }

}
