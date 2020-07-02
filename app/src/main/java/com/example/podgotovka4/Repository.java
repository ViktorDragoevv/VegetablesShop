package com.example.podgotovka4;

import java.util.ArrayList;
import java.util.Random;

public class Repository {

    public static ArrayList<Vegetables>vegetables=new ArrayList<>();

    public static ArrayList<Vegetables> generateVegetables(int count){
        Random random= new Random();
        for (int i = 1 ; i<=count ; i++){
            vegetables.add(new Vegetables("vegetable"+i,random.nextInt(9000)+1000,random.nextInt(1000)+100));

        }
        return vegetables;
    }
    public static Vegetables getVegetableByName(String name){
        for(Vegetables vegetable : vegetables){
            if(vegetable.getVegetableName().equals(name)){
                return vegetable;
            }
        }
        return null;
    }
}
