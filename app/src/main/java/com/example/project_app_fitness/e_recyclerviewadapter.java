package com.example.project_app_fitness;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class e_recyclerviewadapter extends RecyclerView.Adapter<e_recyclerviewadapter.MyviewHolder> {

    private final recyclerviewinterface recyclerviewinterface;
    Context context;
    ArrayList<exercisemodel> exercisemodel;

    public e_recyclerviewadapter(Context context, ArrayList<exercisemodel> exercisemodels, recyclerviewinterface recyclerviewinterface) {
        this.context = context;
        this.exercisemodel = exercisemodels;
        this.recyclerviewinterface = recyclerviewinterface;
    }


    @NonNull
    @Override
    public e_recyclerviewadapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.reclyclerviewrow, parent, false);
        return new e_recyclerviewadapter.MyviewHolder(view, recyclerviewinterface);
    }

    @Override
    public void onBindViewHolder(@NonNull e_recyclerviewadapter.MyviewHolder holder, int position) {
        holder.exletter.setText(exercisemodel.get(position).getExercisename());
        holder.imageview.setImageResource(exercisemodel.get(position).getImage());
    }

    @Override
    public int getItemCount() {

        return exercisemodel.size();
    }

    public static class MyviewHolder extends RecyclerView.ViewHolder {

        ImageView imageview;
        TextView exletter;

        public MyviewHolder(@NonNull View itemView, recyclerviewinterface recyclerviewinterface) {
            super(itemView);

            imageview = itemView.findViewById(R.id.imageView);
            exletter = itemView.findViewById(R.id.textView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerviewinterface != null) {
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION) {
                            recyclerviewinterface.onitemclick(pos);
                        }
                    }
                }
            });
        }
    }
}
