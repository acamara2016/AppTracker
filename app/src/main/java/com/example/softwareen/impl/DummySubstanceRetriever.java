package com.example.softwareen.impl;

import com.example.softwareen.api.SubstanceRetriever;
import com.example.softwareen.objects.Substance;

import java.util.ArrayList;
import java.util.List;

public abstract class DummySubstanceRetriever implements SubstanceRetriever {
    @Override
    public List<Substance> getSubstance() {
        List<Substance> list= new ArrayList<>();
        list.add(new Substance("Substance_1","2"));
        list.add(new Substance("Substance_2","2"));
        list.add(new Substance("Substance_3","2"));
        list.add(new Substance("Substance_4","2"));
        list.add(new Substance("Substance_5","2"));
        list.add(new Substance("Substance_6","2"));
        return list;
    }
}
