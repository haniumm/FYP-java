










package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class firstrecyler extends AppCompatActivity {

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<recylr view>>>>>>>>>>>>>>>>
    RecyclerView recyclerView;
    Adapter adapter;
    ArrayList<String> items;
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstrecyler);


//        <<<<<<<<<recyler>>>>>>>>>>>>>>>>>>>
        items=new ArrayList<>();
        items.add("first Cardview items");
        items.add("sec Cardview items");
        items.add("thrd Cardview items");
        items.add("fouth Cardview items");
        items.add("fivth Cardview items");
        items.add("six Cardview items");



        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new Adapter(this,items);
        recyclerView.setAdapter(adapter);

//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    }
}