package com.example.nutritionassistant;

public class nutritionmodel  {
    public nutritionmodel()
    {

    }
    private String amount,name;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    private int calories;

    public nutritionmodel(String amount, String name, int calories) {
        this.amount = amount;
        this.name = name;
        this.calories = calories;
    }
}
