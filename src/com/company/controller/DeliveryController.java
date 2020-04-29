package com.company.controller;

import com.company.model.repositorys.DeliveryRepository;

import java.util.List;

public class DeliveryController {

    private DeliveryRepository deliveryRepository = new DeliveryRepository();
    public void insertDeliveryPlace() {
        deliveryRepository.create();
    }

    public List showDeliveryPlaces() {
        return deliveryRepository.findAll();
    }
}
