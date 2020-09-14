package com.example.nutritionassistant;
public class recipemodel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getStepsofrecipe() {
        return stepsofrecipe;
    }

    public void setStepsofrecipe(String stepsofrecipe) {
        this.stepsofrecipe = stepsofrecipe;
    }


    public String getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(String totaltime) {
        this.totaltime = totaltime;
    }

    private String ingredients;
    private String stepsofrecipe;
    private String totaltime;

    public recipemodel() {

    }

    public recipemodel(String name, String ingredients, String stepsofrecipe, String totaltime) {
        this.name = name;
        this.ingredients = ingredients;
        this.stepsofrecipe = stepsofrecipe;
        this.totaltime = totaltime;
    }
}