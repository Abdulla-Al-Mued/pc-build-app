package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Motherboard;
import com.example.easybuild.View.Ui.MotherboardDetails;

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            component = itemView.findViewById(R.id.motherboard);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {

            Motherboard product = motherboards.get(getAdapterPosition());
            Intent intent = new Intent(ctx, MotherboardDetails.class);
            intent.putExtra("product", product);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            ctx.startActivity(intent);




        }
    }

}
