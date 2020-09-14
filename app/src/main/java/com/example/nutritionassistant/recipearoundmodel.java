package com.example.nutritionassistant;

public class recipearoundmodel {
    private String name;
    private String difficulty;
    private String ingredients;
    private String stepsforrecipe;
    private String calories;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getStepsforrecipe() {
        return stepsforrecipe;
    }

    public void setStepsforrecipe(String stepsofrecipe) {
        this.stepsforrecipe = stepsofrecipe;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getTotaltime() {
        return totaltime;
    }

    public void setTotaltime(String totaltime) {
        this.totaltime = totaltime;
    }

    private String totaltime;

    public recipearoundmodel() {

    }

    public recipearoundmodel(String name, String ingredients, String stepsforrecipe, String calories, String totaltime,String difficulty) {
        this.name = name;
        this.ingredients = ingredients;
        this.stepsforrecipe = stepsforrecipe;
        this.calories = calories;
        this.totaltime = totaltime;
        this.difficulty=difficulty;
    }
}
