package com.company.model.models;

public class Delivery {
    private String city;
    private int deliveryPrice;
    private int deliveryId;

    public Delivery(String city, int deliveryPrice, int deliveryId) {
        this.city = city;
        this.deliveryPrice = deliveryPrice;
        this.deliveryId = deliveryId;
    }

    public String getCity() {
        return city;
    }

    public int getDeliveryPrice() {
        return deliveryPrice;
    }
}
