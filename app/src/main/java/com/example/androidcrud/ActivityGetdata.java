package com.example.androidcrud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import Adapter.MyRecycleAdapter;

public class ActivityGetdata extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdata);

        //config layout
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //config Adapter
        String[] strings = {"A","B","C"};
        MyRecycleAdapter adapter = new MyRecycleAdapter(strings);
        recyclerView.setAdapter(adapter);

    }
}