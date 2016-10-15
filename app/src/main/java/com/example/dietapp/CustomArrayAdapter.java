package com.example.dietapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

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
        holder.calories = (TextView) convertView.findViewById(R.id.calories);
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

        //define an onClickListener for the check_button.

        holder.check_button1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //when button clicked change the current state of the button : if not pressed insert to menu and change icon
                //else do the opposite
                ImageButton check_button= (ImageButton)v.findViewById(R.id.check_button1);
                RowData rd = list.get(position);
                if(!rd.getIn_menu()){
                    rd.setIn_menu(true);
                    check_button.setImageResource(R.mipmap.pressed_button);
                }
                else {
                    rd.setIn_menu(false);
                    check_button.setImageResource(R.mipmap.add_button);
                }
            }

        });



        //setting data into the the ViewHolder.
        holder.foods.setText(list.get(position).getFoodname());
        holder.foodPoints.setText(String.valueOf(list.get(position).getPoints()));
        holder.calories.setText(String.valueOf(list.get(position).getCalories()));
        holder.check_button1.setBackgroundResource(0);

        if(!list.get(position).getIn_menu())
            holder.check_button1.setImageResource(R.mipmap.add_button);
        else
            holder.check_button1.setImageResource(R.mipmap.pressed_button);
        //holder.checked.setChecked(rowDataList.get(position).isChecked());

        //return the row view.
        return convertView;
    }
}

