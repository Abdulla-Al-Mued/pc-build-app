package com.example.easybuild.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.easybuild.R;
import com.example.easybuild.Service.Model.Graphicscard;

import java.util.List;

public class graphicsCardAdapter extends RecyclerView.Adapter<graphicsCardAdapter.ViewHolder> {

    private Context context;
    private List<Graphicscard> graphicscards;

    public graphicsCardAdapter(Context context, List<Graphicscard> graphicscards) {
        this.context = context;
        this.graphicscards = graphicscards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.motherboard_single_row, null, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.component.setText("Model :"+graphicscards.get(position).getModel()+"\nPrice(tk) :"+graphicscards.get(position).getPrice()+"\n");
    }

    @Override
    public int getItemCount() {
        return graphicscards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView component;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            component = itemView.findViewById(R.id.motherboard);
        }
    }

}
