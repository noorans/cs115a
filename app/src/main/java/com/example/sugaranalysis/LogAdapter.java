package com.example.sugaranalysis;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sugaranalysis.Objects.LogObject;

import java.util.List;

class LogAdapter extends RecyclerView.Adapter<LogAdapter.MyViewHolder> {
    public List<LogObject> logObject;
    class MyViewHolder extends  RecyclerView.ViewHolder{
        public TextView date, moment, time, bs, height, weight, nameText, itemDescription;
        public Button button;
        public MyViewHolder(View v)
        {
            super(v);
            nameText = itemView.findViewById(R.id.textFoodTItle);
            itemDescription = itemView.findViewById(R.id.textFoodDesc);
            button = itemView.findViewById(R.id.ServingButton);
        }
    }
    private Context context;
    public LogAdapter(List<LogObject> p0){logObject = p0;}
    @Override
    public LogAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View contactView = inflater.inflate(R.layout.log_dropdown,parent,false);
        MyViewHolder viewHolder = new MyViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return logObject.size();
    }
}
