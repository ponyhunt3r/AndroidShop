package com.example.annac.firstone;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    this.initRecyclerView();
    }
    private void initRecyclerView(){

        ArrayList<String> listData1;
        ArrayList<String> listData2;
        ArrayList<String> listData3;

        SqlDBHelper sqlHelper = new SqlDBHelper(this);

        sqlHelper.addData("DELL", 999, "Inspiron");
        sqlHelper.addData("HP", 1099, "Ultra Book");
        sqlHelper.addData("ASUS", 769, "LB556");
        sqlHelper.addData("Acer", 599, "Thinker");
        sqlHelper.addData("MacBook", 4999, "AirMac");
        sqlHelper.addData("Surface", 1999, "SurfacePro");
        Cursor data = sqlHelper.getData();
        listData1 = new ArrayList<>();
        listData2 = new ArrayList<>();
        listData3 = new ArrayList<>();

        while (data.moveToNext()) {
            listData1.add(data.getString(1));
            listData2.add(data.getString(2));
            listData3.add(data.getString(3));
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(listData1, listData2, listData3);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }


}

