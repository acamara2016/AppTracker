package com.example.softwareen.objects;

public class Substance {
    private String name;
    private String amount;


    public Substance(String name, String amount){

    }
    public Substance(String id, String name, String amount){
        this.name=name;
        this.amount=amount;
    }

    public void setName(String name){ this.name=name;}
    public void setAmount(String amount){this.amount=amount;}

    public String getName(){return name;}
    public String getAmount(){return amount;}

}
