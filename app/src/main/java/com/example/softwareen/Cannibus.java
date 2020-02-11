package com.example.softwareen;

public class Cannibus extends Substance{

        private String id;
        private String name;
        private double thc_content;
        private double cbd_content;
        private String strain;

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

        public String toString() {

            return "Name " + this.name + "\n" +
                    "Strain: " + this.strain + "\n" +
                    "CBD Content: " + this.thc_content + "%" + "\n" +
                    "THC Content: " + this.cbd_content + "%";

        }
    }


