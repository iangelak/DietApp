package com.example.dietapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by john on 10/8/16.
 */

class CustomArrayAdapter extends ArrayAdapter {
    private ArrayList<RowData> list;


    //this custom adapter receives an ArrayList of RowData objects.
    //RowData is my class that represents the data for a single row and could be anything.
    public CustomArrayAdapter(Context context, int textViewResourceId, ArrayList<RowData> rowDataList)
    {
        //populate the local list with data.
        super(context, textViewResourceId, rowDataList);
        this.list = new ArrayList<RowData>();
        this.list.addAll(rowDataList);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent)
    {
        //creating the ViewHolder we defined earlier.
        ViewHolder holder = new ViewHolder();

        //creating LayoutInflator for inflating the row layout.
        LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflating the row layout we defined earlier.
        if(convertView==null)
             convertView = inflator.inflate(R.layout.test_layout, parent,false);
        else
            convertView = inflator.inflate(R.layout.test_layout, null);


        //setting the views into the ViewHolder.

        holder.foods = (TextView) convertView.findViewById(R.id.foods);
        holder.foodPoints = (TextView) convertView.findViewById(R.id.foodPoints);
        holder.check_button1 = (ImageButton) convertView.findViewById(R.id.check_button1);

        //define an onClickListener for the ImageView.

        /*holder.changeRowStatus.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(activity, "Image from row " + position + " was pressed", Toast.LENGTH_LONG).show();
            }
        });
        */

        //holder.checked = (CheckBox) convertView.findViewById(R.id.cbCheckListItem);
        //holder.checked.setTag(position);

        //define an onClickListener for the CheckBox.

        /*holder.checked.setOnClickListener(new OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //assign check-box state to the corresponding object in list.
                CheckBox checkbox = (CheckBox) v;
                rowDataList.get(position).setChecked(checkbox.isChecked());
                Toast.makeText(activity, "CheckBox from row " + position + " was checked", Toast.LENGTH_LONG).show();
            }
        });
        */

        //setting data into the the ViewHolder.
        holder.foods.setText(list.get(position).foodname);
        holder.foodPoints.setText(String.valueOf(list.get(position).points));
        holder.check_button1.setBackgroundResource(0);
        holder.check_button1.setImageResource(R.mipmap.add_button);
        //holder.checked.setChecked(rowDataList.get(position).isChecked());

        //return the row view.
        return convertView;
    }
}

