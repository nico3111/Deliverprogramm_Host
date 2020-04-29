package com.company.model.repositorys;

import com.company.model.DatabaseConnector;
import com.company.model.Repository;
import com.company.model.models.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuRepository implements Repository<Menu> {
    private DatabaseConnector connector;

    public MenuRepository() {
        this.connector = DatabaseConnector.getInstance();
    }

    @Override
    public List<Menu> findAll() {
        ArrayList<Menu> menus = new ArrayList<>();
        ResultSet result = connector.fetchData("SELECT * FROM `menu`");
        if (result == null) {
            System.out.println("keine Gerichte gefunden!");
            return null;
        }
        try {
            while (result.next()) {
                String dish = result.getString("dish");
                int dishId = result.getInt("dishId");
                int price = result.getInt("price");

                menus.add(new Menu(dish, dishId, price));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            connector.closeConnection();
            return menus;
        }
    }

    @Override
    public Menu findOne(int id) {
        return null;
    }


    @Override
    public Menu create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name des Gerichtes");
        String scannerDishName = scanner.nextLine();
        System.out.println("Preis für das Gericht");
        int scannerDishPrice = scanner.nextInt();
        System.out.println("Das Gericht -> " + scannerDishName + " <- mit einem Preis von -> " + scannerDishPrice + "€ <- wurde hinzugefügt");
        connector.insert("INSERT INTO `menu`(`dish`, `price`) " +
                "VALUES ('" + scannerDishName + "', '" + scannerDishPrice + "')");

        return findOne(1);
    }
}
