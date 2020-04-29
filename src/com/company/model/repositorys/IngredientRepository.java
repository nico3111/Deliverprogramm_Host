package com.company.model.repositorys;

import com.company.model.DatabaseConnector;
import com.company.model.Repository;
import com.company.model.models.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IngredientRepository implements Repository<Ingredient> {
    private DatabaseConnector connector;

    public IngredientRepository() {
        this.connector = DatabaseConnector.getInstance();
    }

    List<Ingredient> ingredients = new ArrayList<>();

    @Override
    public List<Ingredient> findAll() {
        ResultSet result = connector.fetchData("SELECT * FROM `ingredients`");
        if (result == null) {
            System.out.println("keine Zutaten gefunden!");
            return null;
        }
        try {
            while (result.next()) {
                String ingredients = result.getString("ingredients");
                int ingredientsId = result.getInt("ingredientsId");

                this.ingredients.add(new Ingredient(ingredients, ingredientsId));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }finally {
            connector.closeConnection();
            return ingredients;
        }
    }

    @Override
    public Ingredient findOne(int id) {
        return null;
    }

    @Override
    public Ingredient create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name der Zutat");
        String scannerIngredientName = scanner.nextLine();
        connector.insert("INSERT INTO `ingredients`(`ingredients`) VALUES ('" + scannerIngredientName + "')");
        return null;
    }
}
