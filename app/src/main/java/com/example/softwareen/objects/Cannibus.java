package com.example.softwareen.objects;

public class Cannibus extends Substance{

        private String id;
        private String name;
        private double thc_content;
        private double cbd_content;
        private String strain;

    /**
     * The constructor for the Cannibus .
     *
     * @param id -- a distinct identification number for the strain
     * @param name -- the name of the product
     * @param thc_content -- the amount of thc in the product
     * @param cbd_content -- the amount of cbd in the product
     * @param strain -- the strain type
     *
     *
     */
        public Cannibus(String id, String name, double amount, String strain, double thc_content, double cbd_content) {
            super(id, name, amount);
            this.strain = strain;
            this.thc_content = thc_content;
            this.cbd_content = cbd_content;

        }

        public void setType(String type) {this.strain = type;}
        public void set_thc_content(double thc_content) { this.thc_content = thc_content;}
        public void set_cbd_content(double cbd_content) { this.cbd_content = cbd_content;}

        public String getType() {return strain;}
        public double get_thc_content() { return thc_content;}
        public double get_cbd_content() { return cbd_content;}
        public double getAmount(){return super.getAmount();}

    /**
     * Method to print all the information regarding the product. This method takes no parameters, and
     * will always return a print statement, even if the enters parameters are invalid.
     *
     * @return Returns the name, strain type, CBD and THC content for the product
     *
     *

     */
        public String toString() {

            return "Name " + this.name + "\n" +
                    "Strain: " + this.strain + "\n" +
                    "CBD Content: " + this.thc_content + "%" + "\n" +
                    "THC Content: " + this.cbd_content + "%";

        }
    /**
     * When the method is called it checks to see whether or not the inputted values are valid or not.
     *
     * @return Returns a Boolean, ture if the substance input is valid, false otherwise.
     *
     *
     */
    public boolean valid_substance(Cannibus cannibus){

        // Boolean return_boolean = false;

        if( cannibus.getName().isEmpty() || cannibus.getType().isEmpty()|| cannibus.getAmount()<=0|| cannibus.get_cbd_content()<=0 ||cannibus.get_thc_content()<=0  ){
            return false;
        }
        else{
            return true;
        }
    }
}


