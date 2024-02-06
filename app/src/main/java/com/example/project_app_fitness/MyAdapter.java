package com.example.project_app_fitness;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_app_fitness.DataClassEx;
import com.example.project_app_fitness.DetailActivityEx;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private Context context;

    //composition DataClassEx
    private List<DataClassEx> dataList;

    //composition ExerciseClickListener
    private ExerciseClickListener exerciseClickListener;

    public void setSearchList(List<DataClassEx> dataSearchList){
        this.dataList = dataSearchList;
        notifyDataSetChanged();
    }
    public MyAdapter(Context context, List<DataClassEx> dataList, ExerciseClickListener exerciseClickListener){
        this.context = context;
        this.dataList = dataList;
        this.exerciseClickListener = exerciseClickListener;

    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.recImage.setImageResource(dataList.get(position).getDataImage());
        holder.recTitle.setText(dataList.get(position).getDataTitle());
        holder.recDesc.setText(dataList.get(position).getDataDesc());

        // Convert getDataLang() to String to avoid Resources$NotFoundException
        holder.recLang.setText(String.valueOf(dataList.get(position).getDataLang()));

        holder.recCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exerciseClickListener.showText(); // Call the showText() method from the interface
                Intent intent = new Intent(context, DetailActivityEx.class);
                intent.putExtra("Image", dataList.get(holder.getAdapterPosition()).getDataImage());
                intent.putExtra("Title", dataList.get(holder.getAdapterPosition()).getDataTitle());
                intent.putExtra("Desc", dataList.get(holder.getAdapterPosition()).getDataDesc());
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{
    ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        recImage = itemView.findViewById(R.id.recImage);
        recTitle = itemView.findViewById(R.id.recTitle);
        recDesc = itemView.findViewById(R.id.recDesc);
        recLang = itemView.findViewById(R.id.recLang);
        recCard = itemView.findViewById(R.id.recCard);
    }
}
