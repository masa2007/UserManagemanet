package com.example.usermanagemanet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.MyViewHolder> {
    Context context;
    ArrayList<Animal> amlList;
    private FireBaseServices fbs;


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvType, tvPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvType=itemView.findViewById(R.id.tvAnimaltype);
            tvPrice=itemView.findViewById(R.id.tvAnimalPrice);

        }
    }

    public AnimalAdapter(Context context, ArrayList<Animal> restList) {
        this.context = context;
        this.amlList = amlList;
        this.fbs = FireBaseServices.getInstance();
    }

    @NonNull
    @Override
    public AnimalAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v= LayoutInflater.from(context).inflate(R.layout.animal_item,parent,false);
        return  new AnimalAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.MyViewHolder holder, int position) {
        Animal aml = amlList.get(position);
        holder.tvType.setText(aml.getType());
        holder.tvPrice.setText(aml.getprice());
    }

    @Override
    public int getItemCount(){
        return amlList.size();
    }


}
