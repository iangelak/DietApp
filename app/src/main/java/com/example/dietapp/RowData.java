package com.example.dietapp;

/**
 * Created by john on 10/8/16.
 */

public class RowData {

    private boolean in_menu;
    private String foodname;
    private float points;
    private float calories;

    public RowData()
    {
        setIn_menu(false);
        setFoodname("A food");
        setPoints(10.0f);
        setCalories(100.0f);
    }

    /*Setters*/
    public void setIn_menu(boolean b) { this.in_menu = b; return; }
    public void setFoodname(String s) { this.foodname = s; return; }
    public void setPoints(float points) { this.points = points; return; }
    public void setCalories(float calories) { this.calories = calories; return; }

    /*Getters*/
    public boolean getIn_menu() { return this.in_menu; }
    public String getFoodname() { return this.foodname; }
    public float getPoints() { return this.points; }
    public float getCalories() { return this.calories; }

}
