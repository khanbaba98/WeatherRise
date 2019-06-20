package com.khanbaba.weatherdemo;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MyListAdapter extends RecyclerView.Adapter <MyListAdapter.ViewHolder>{

    public ArrayList<WeatherDetails> weatherDetails;

    public MyListAdapter(ArrayList<WeatherDetails> weatherDetails)
    {
        this.weatherDetails=weatherDetails;
    }

    @NonNull
    @Override
    public MyListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item,viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position, @NonNull List<Object> payloads) {
        final ArrayList<WeatherDetails> dayDetail = new ArrayList<>(position);

        holder.dateTextView.setText(dayDetail.get(position).getDate());
        holder.tempTextView.setText(dayDetail.get(position).getDayTemp().toString());
        holder.minTempTextView.setText(dayDetail.get(position).getMinTemp().toString());
        holder.maxTempTextView.setText(dayDetail.get(position).getMaxTemp().toString());

        holder.constraintLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Day clicked"+ dayDetail.get(position).getDate(), Toast.LENGTH_LONG);
            }
        });

        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return weatherDetails.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView weatherIconImageView;
        public TextView tempTextView, minTempTextView, maxTempTextView, dateTextView;
        public ConstraintLayout constraintLayout;
        public ViewHolder(View itemView){
            super(itemView);
            this.weatherIconImageView = itemView.findViewById(R.id.weatherIconImageView);
            this.tempTextView = itemView.findViewById(R.id.tempTextView);
            this.minTempTextView = itemView.findViewById(R.id.minTempTextView);
            this.maxTempTextView = itemView.findViewById(R.id.maxTempTextView);
            this.dateTextView = itemView.findViewById(R.id.dateTextView);
            this.constraintLayout = itemView.findViewById(R.id.constraintLayout);
        }

    }
}


