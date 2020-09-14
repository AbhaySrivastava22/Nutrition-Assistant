package com.example.nutritionassistant;

public class fooditemmodel {

private String name;
private String cooked_weight;
private String cooked_measure;
private int calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCooked_weight() {
        return cooked_weight;
    }

    public void setCooked_weight(String cooked_weight) {
        this.cooked_weight = cooked_weight;
    }

    public String getCooked_measure() {
        return cooked_measure;
    }

    public void setCooked_measure(String cooked_measure) {
        this.cooked_measure = cooked_measure;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public fooditemmodel(String name, String cooked_weight, String cooked_measure, int calories )
{
    this.name=name;
    this.cooked_measure=cooked_measure;
    this.cooked_weight=cooked_weight;
    this.calories=calories;
}
public fooditemmodel()
{

}
}
