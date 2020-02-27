package com.example.softwareen;

import java.util.ArrayList;

public class User_Substance_Library {

        private ArrayList<Substance> substance_list;

    public User_Substance_Library() {

    }

    public String search_library(String name) {

        if (substance_list.isEmpty() == true) {
                return "Substance not contained in list";
        }
        else {

            for(int i = 0; i< substance_list.size(); i++  ){

                if(substance_list.get(i).getName().equals(name)){
                        return substance_list.get(i).toString();
                }
            }
        }
        return "Substance not contained in list";

    }
    public void add_substance(Substance name) {
        substance_list.add(name);
    }
    public void remove_substance(Substance name) {
        substance_list.remove(name);
    }
    public void see_library(){
        for(int i = 0; i< substance_list.size(); i++  ){

            System.out.println(i + "." + " " + substance_list.get(i).getName());
        }
    }
}

