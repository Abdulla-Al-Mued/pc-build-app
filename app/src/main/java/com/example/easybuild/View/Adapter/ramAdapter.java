package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Ram1;

import java.util.List;

public class ramAdapter extends RecyclerView.Adapter<ramAdapter.ViewHolder>{

    private Context context;
    private List<Ram1> rams;

    public ramAdapter(Context context, List<Ram1> rams) {
        this.context = context;
        this.rams = rams;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ramAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.component.setText("Model :"+rams.get(position).getModel()+"\nPrice(tk) :"+rams.get(position).getPrice()+"\n");
    }

    @Override
    public int getItemCount() {
        return rams.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);
        }
    }
}
