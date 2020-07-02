package com.example.podgotovka4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    Context context ;
    ArrayList<Vegetables>vegetables = new ArrayList<>();

    public Adapter(ArrayList vegetables){
        this.vegetables=vegetables;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view,context);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Vegetables vegetables = Repository.vegetables.get(position);
        holder.setvName(vegetables.getVegetableName());
        holder.setvAvalable(String.valueOf(vegetables.getAvailable()));
        holder.setvSold(String.valueOf(vegetables.getSold()));



    }

    @Override
    public int getItemCount() {
       return vegetables.size();
    }
}
