package com.company.model.models;

public class Ingredient {
    private String ingredients;
    private int ingredientsId;

    public Ingredient(String ingredients, int ingredientsId) {
        this.ingredients = ingredients;
        this.ingredientsId = ingredientsId;
    }

    public String getIngredients() {
        return ingredients;
    }

    public int getIngredientsId() {
        return ingredientsId;
    }
}
