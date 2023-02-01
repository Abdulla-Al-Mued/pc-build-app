package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Powersupply;
import com.example.easybuild.Service.Model.Processor;
import com.example.easybuild.View.Ui.PowerSupplyDetails;

import java.util.List;

public class processorAdapter extends RecyclerView.Adapter<processorAdapter.ViewHolder>{

    private Context context;
    private List<Processor> processors;

    public processorAdapter(Context context, List<Processor> processors) {
        this.context = context;
        this.processors = processors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new processorAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.component.setText("Model :"+processors.get(position).getModel()+"\nPrice(tk) :"+processors.get(position).getPrice()+"\n");

    }

    @Override
    public int getItemCount() {
        return processors.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            Processor product = processors.get(getAdapterPosition());
            Intent intent = new Intent(context, com.example.easybuild.View.Ui.ProcessorDetails.class);
            intent.putExtra("product", product);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        }
    }

}
