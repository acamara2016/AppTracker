package com.example.softwareen.objects;

public class Alcohol extends Substance {
    private String id;
    private String name;
    private double alcohol_per_volume;
    private String type;

    public Alcohol(String id, String name, String amount, String type, double alcohol_per_volume) {
        super(id, name, amount);
        this.type = type;
        this.alcohol_per_volume = alcohol_per_volume;
    }

    public void setType(String type) {this.type = type;}
    public void set_alcohol_per_volume(double alcohol_per_volume) { this.alcohol_per_volume = alcohol_per_volume;}

    public String getType() {return type; }
    public double get_Alcohol_per_volume() { return alcohol_per_volume;}

    public String toString() {
        return "Name: " + this.name + "\n" +
                "Type: " + this.type + "\n" +
                "ABV: " + this.alcohol_per_volume + "%";
    }
}