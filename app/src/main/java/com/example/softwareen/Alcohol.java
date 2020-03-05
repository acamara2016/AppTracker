package com.example.softwareen;

public class Alcohol extends Substance {
    private String id;
    private String name;
    private double alcohol_per_volume;
    private String type;

    /**
     * The constructor for the Alcohol.
     *
     * @param id -- a distinct identification number for the strain
     * @param name -- the name of the product
     * @param amount -- the base volume for the product
     * @param type -- the type of alcohol (wine, beer, cider, spirit)
     * @param alcohol_per_volume -- The amount of alcohol per drink
     *
     */

    public Alcohol(String id, String name, double amount, String type, double alcohol_per_volume) {
        super(id, name, amount);
        this.type = type;
        this.alcohol_per_volume = alcohol_per_volume;
    }

    public void setType(String type) {this.type = type;}
    public void set_alcohol_per_volume(double alcohol_per_volume) { this.alcohol_per_volume = alcohol_per_volume;}

    public String getType() {return type; }
    public double get_Alcohol_per_volume() { return alcohol_per_volume;}

    /**
     * Method to print all the information regarding the product. This method takes no parameters, and
     * will always return a print statement, even if the enters parameters are invalid.
     *
     * @return Returns the name,  type of alcohol, and the alcohol per volume
     *
     */

     public String toString() {
        return "Name: " + this.name + "\n" +
                "Type: " + this.type + "\n" +
                "ABV: " + this.alcohol_per_volume + "%";
    }

    /**
     * When the method valid_substance is called it checks to see whether or not the inputted values are valid or not.
     *
     * @return Returns a Boolean, ture if the substance input is valid, false otherwise.
     *
     */


    public boolean valid_substance(Alcohol alcohol){

       // Boolean return_boolean = false;

        if( alcohol.getName().isEmpty() || alcohol.getType().isEmpty()|| alcohol.get_Alcohol_per_volume()<=0 ||alcohol.getAmount()<=0 ){
            return false;
        }
        else{
            return true;
        }
//return return_boolean;
    }
}