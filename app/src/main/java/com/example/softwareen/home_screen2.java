package com.example.softwareen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class home_screen2 extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[];
    int images[]={R.drawable.beer,R.drawable.vodka,R.drawable.gin,R.drawable.cider,R.drawable.whiskey,R.drawable.wine,R.drawable.weed};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen2);

        recyclerView= findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.substances);
        s2=getResources().getStringArray(R.array.description);

        MyAdapter myAd=new MyAdapter(this,s1,s2,images);
        recyclerView.setAdapter(myAd);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}