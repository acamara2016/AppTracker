package com.example.softwareen;

public class Substance {
    private int id;
    private String name;
    private int amount;


    public Substance(){

    }
    public Substance(int id, String name, int amount){
        this.id=id;
        this.name=name;
        this.amount=amount;
    }

    public void setName(String name){ this.name=name;}
    public void setAmount(int amount){this.amount=amount;}

    public String getName(){return name;}
    public int getAmount(){return amount;}

}
