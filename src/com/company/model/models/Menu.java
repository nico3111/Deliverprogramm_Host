package com.company.model.models;

public class Menu {
    private String dish;
    private int dishId;
    private int price;

    public Menu(String dish, int dishId, int price) {
        this.dish = dish;
        this.dishId = dishId;
        this.price = price;
    }

    public String getDish() {
        return dish;
    }

    public int getPrice() {
        return price;
    }
}
