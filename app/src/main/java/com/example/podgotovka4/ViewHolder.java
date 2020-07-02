package com.example.podgotovka4;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewHolder extends RecyclerView.ViewHolder implements Lisener {


    private TextView vName;
    private TextView vAvalable;
    private TextView vSold;
    private Button BTNSell;

    Vegetables vegetable = new Vegetables();




    public ViewHolder(@NonNull View itemView , final Context context) {
        super(itemView);
        vName=itemView.findViewById(R.id.vName);
        vAvalable=itemView.findViewById(R.id.aAvalable);
        vSold = itemView.findViewById(R.id.vSold);
        BTNSell = itemView.findViewById(R.id.BTNSell);


        BTNSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vegetable=Repository.getVegetableByName(vName.getText().toString());
                vegetable.sellVegetable();
                vSold.setText(String.valueOf(vegetable.getSold()));

                if(Integer.parseInt(vAvalable.getText().toString())<vegetable.getAvailable()){
                    Acync acync = new Acync(((FragmentActivity)context).getSupportFragmentManager(),ViewHolder.this);
                    acync.execute(5);

                }
                else{
                    vAvalable.setText(String.valueOf(vegetable.getAvailable()));
                }








            }
        });
    }

    public TextView getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName.setText(vName);
    }

    public TextView getvAvalable() {
        return vAvalable;
    }

    public void setvAvalable(String vAvalable) {
        this.vAvalable.setText(vAvalable);
    }

    public Button getBTNSell() {
        return BTNSell;
    }

    public void setBTNSell(Button BTNSell) {
        this.BTNSell = BTNSell;
    }

    public TextView getvSold() {
        return vSold;
    }

    public void setvSold(String vSold) {
        this.vSold.setText(vSold);
    }

    @Override
    public void Res(String res) {
        vAvalable.setText(String.valueOf(vegetable.getAvailable()));
    }
}
