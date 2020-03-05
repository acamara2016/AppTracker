package com.example.softwareen;

public class Substance {
    private String id;
    private String name;
    private double amount;


    public Substance(){

    }
    public Substance(String id, String name, double amount){
        this.id=id;
        if(name == null){
            name = "";
        }
        this.name=name;
        this.amount=amount;
    }

    public void setName(String name){ this.name=name;}
    public void setAmount(int amount){this.amount=amount;}

    public String getName(){return name;}
    public double getAmount(){return amount;}

    public boolean valid_substance(Substance substance){

        return false;
    }


}
