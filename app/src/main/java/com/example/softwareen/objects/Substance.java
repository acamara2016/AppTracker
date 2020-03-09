package com.example.softwareen.objects;

public class Substance {
    private String name;
    private double amount;

    public Substance(){

    }
    public Substance(String id, String name, double amount){
        if(name == null){
            name = "";
        }
        this.name=name;
        this.amount=amount;
    }

    public void setName(String name){ this.name=name;}
    public void setAmount(double amount){this.amount=amount;}

    public String getName(){return name;}
    public double getAmount(){return amount;}

    public String toString(){
        return ("Name: "+this.name+" Amount: "+this.amount);
    }

}
