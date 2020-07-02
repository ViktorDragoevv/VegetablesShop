package com.example.podgotovka4;

public class Vegetables {
    private String vegetableName;
    private int available;
    private int sold;
    private int nachalen;

    public Vegetables(){}

    public Vegetables(String vegatableName, int available, int sold) {
        this.vegetableName = vegatableName;
        this.available = available;
        this.sold = sold;
        this.nachalen=available;
    }

    public String getVegetableName() {
        return vegetableName;
    }

    public void setVegetableName(String vegetableName) {
        this.vegetableName = vegetableName;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public int getNachalen() {
        return nachalen;
    }

    public void setNachalen(int nachalen) {
        this.nachalen = nachalen;
    }

    public Vegetables sellVegetable(){
        sold+=available*0.1;
        available-=available*0.1;

        if(available<nachalen*0.2){
            available+=available*0.3;
        }
        return this;
    }
}
