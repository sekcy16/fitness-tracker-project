package com.example.project_app_fitness;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>  {
    private Context context;
    Activity activity;
    private ArrayList ex_id, ex_date, ex_title, ex_duration, ex_comment;

    int position;
    CustomAdapter(Activity activity, Context context, ArrayList ex_id, ArrayList ex_date, ArrayList ex_title, ArrayList ex_duration,
                  ArrayList ex_comment){
        this.activity = activity;
        this.context = context;
        this.ex_id = ex_id;
        this.ex_date = ex_date;
        this.ex_title = ex_title;
        this.ex_duration = ex_duration;
        this.ex_comment = ex_comment;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {

        this.position = position;

        holder.ex_id_text.setText(String.valueOf(ex_id.get(position)));
        holder.ex_date_text.setText(String.valueOf(ex_date.get(position)));
        holder.ex_title_text.setText(String.valueOf(ex_title.get(position)));
        holder.ex_comment_text.setText(String.valueOf(ex_comment.get(position)));
        holder.ex_duration_text.setText(String.valueOf(ex_duration.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id",String.valueOf(ex_id.get(position)));
                intent.putExtra("date",String.valueOf(ex_date.get(position)));
                intent.putExtra("title",String.valueOf(ex_title.get(position)));
                intent.putExtra("duration",String.valueOf(ex_duration.get(position)));
                intent.putExtra("comment",String.valueOf(ex_comment.get(position)));

                activity.startActivityForResult(intent,1);

            }
        });

    }

    @Override
    public int getItemCount() {
        return ex_id.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ex_id_text, ex_date_text, ex_title_text, ex_comment_text, ex_duration_text;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ex_id_text = itemView.findViewById(R.id.ex_id_text);
            ex_date_text = itemView.findViewById(R.id.ex_date_text);
            ex_title_text = itemView.findViewById(R.id.ex_title_text);
            ex_comment_text = itemView.findViewById(R.id.ex_comment_text);
            ex_duration_text = itemView.findViewById(R.id.ex_duration_text);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
