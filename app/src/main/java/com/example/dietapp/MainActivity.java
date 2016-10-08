package com.example.dietapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*

        String[] food = {"Bananes", "Spagetti", "Mila"};
        ListAdapter foodlistAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, food);
        ListView dietlistview = (ListView) findViewById(R.id.dietlistview);
        dietlistview.setAdapter(foodlistAdapter);
*/

        ArrayList<RowData> rowDataList = new ArrayList<RowData>();
        rowDataList.add(new RowData());
        rowDataList.add(new RowData());
        rowDataList.add(new RowData());
        rowDataList.add(new RowData());
        CustomArrayAdapter customArrayAdapter = new CustomArrayAdapter(this, R.id.foods, rowDataList);
        ListView dietlistview = (ListView) findViewById(R.id.dietlistview);
        dietlistview.setAdapter(customArrayAdapter);


    }
}

