package com.company.model.repositorys;

import com.company.model.DatabaseConnector;
import com.company.model.Repository;
import com.company.model.models.Delivery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryRepository implements Repository<Delivery> {
    private DatabaseConnector connector;
    List<Delivery> deliveries = new ArrayList<>();

    public DeliveryRepository() {
        this.connector = DatabaseConnector.getInstance();
    }

    @Override
    public List<Delivery> findAll() {
        ResultSet result = connector.fetchData("SELECT * FROM `delivery`");
        if (result == null) {
            System.out.println("Keine Zustellorte gefunden");
            return null;
        }
        try {
            while (result.next()) {
                String city = result.getString("city");
                int deliveryPrice = result.getInt("deliveryPrice");
                int deliveryId = result.getInt("deliveryId");

                this.deliveries.add(new Delivery(city, deliveryPrice, deliveryId));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connector.closeConnection();
            return deliveries;
        }
    }

    @Override
    public Delivery findOne(int id) {
        return null;
    }

    @Override
    public Delivery create() {        Scanner scanner = new Scanner(System.in);
        System.out.println("neuen Lieferort eingeben");
        String placeOfDelivery = scanner.nextLine();
        System.out.println("Preis für die Lieferung");
        int priceOfDelivery = scanner.nextInt();
        connector.insert("INSERT INTO `delivery`(`city`, `deliveryPrice`) VALUES ('" + placeOfDelivery + "', '" + priceOfDelivery + "')");
        return null;
    }
}
