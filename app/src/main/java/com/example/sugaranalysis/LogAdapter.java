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
        public TextView date, moment, time, bloodsugar, height, weight;

        public MyViewHolder(View v)
        {
            super(v);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            moment = itemView.findViewById(R.id.moment);
            bloodsugar = itemView.findViewById(R.id.bloodsugar);
            height = itemView.findViewById(R.id.height);
            weight = itemView.findViewById(R.id.weight);
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
        holder.date.setText("Date: " + logObject.get(position).getLogDate());
        holder.time.setText("Time: " + logObject.get(position).getLogTime());
        holder.moment.setText(logObject.get(position).getLogMoment());
        holder.bloodsugar.setText("Blood Sugar: " + logObject.get(position).getLogAvg_bs());
        holder.height.setText("Height: " + logObject.get(position).getLogHeight());
        holder.weight.setText("Weight: " + logObject.get(position).getLogWeight());
    }

    @Override
    public int getItemCount() {
        return logObject.size();
    }
}
