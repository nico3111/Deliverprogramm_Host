package com.company.view;

import com.company.controller.DeliveryController;
import com.company.controller.IngredientsController;
import com.company.controller.MenuController;
import com.company.model.models.Delivery;
import com.company.model.models.Ingredient;
import com.company.model.models.Menu;

import java.util.List;
import java.util.Scanner;

public class MenuView {
    private MenuController menuContoller;
    private DeliveryController deliveryController;

    public MenuView(){
        menuContoller = new MenuController();
        deliveryController = new DeliveryController();
    }

    public void printTable(List<Menu> menus) {

        System.out.println("Gericht\t\t\t\tPreis");
        for (Menu menu : menus) {
            System.out.println(menu.getDish() + "\t\t" + menu.getPrice());
        }
    }

    public void printIngredients(List<Ingredient> ingredients) {

        System.out.println("Zutaten");
        if (ingredients != null)
        for (Ingredient ingredient : ingredients) {
            System.out.println(ingredient.getIngredientsId() + "\t" + ingredient.getIngredients());
        }
    }

    public void printDelivery(List<Delivery> deliveries) {
        System.out.println("Zustellort\t\t\t\tPreis");
        if (deliveries != null)
        for (Delivery delivery : deliveries) {
            System.out.println(delivery.getCity() + "\t\t" + delivery.getDeliveryPrice());
        }
    }

    public void insertTable(List<Menu> menus) {
        for (Menu menu : menus) {
//lalalaalala
        }
    }

    public void mainMenu() {
        System.out.println("\nWas möchten Sie tun?\n\nWählen Sie:\n1\tMenü für Speisen und Zutaten\n2\t" +
                "Menü für Zustellung\n3\tBeenden");
        Scanner scanner1 = new Scanner(System.in);
        int mainMenuScanner = scanner1.nextInt();

        switch (mainMenuScanner) {
            case 1:
                dishMenu();
                break;
            case 2:
                deliveryMenu();
                break;
            case 3:
                System.out.println("Wir wünschen einen angenehmen Tag!");
                break;
            default: System.out.println("Eingabe ungültig");
            mainMenu();
        }
    }

    public void dishMenu() {
        System.out.println("\nWas möchten Sie tun?\n\nWählen Sie:\n1\talle Gerichte\n2\talle Zutaten" +
                "\n3\tneues Gericht anlegen\n4\tNeue Zutat\n5\tZurück\n\n");
        Scanner scanner = new Scanner(System.in);
        int menuSelection = scanner.nextInt();

            switch (menuSelection) {
                case 1:
                    List<Menu> resultList = MenuController.showAllMenu();
                    printTable(resultList);
                    dishMenu();
                    break;
                case 2:
                    List<Ingredient> resultListIngredients =  IngredientsController.showAllIngredients();
                    printIngredients(resultListIngredients);
                    dishMenu();
                    break;
                case 3:
                    MenuController.insertDish();
                    dishMenu();
                    break;
                case 4:
                    IngredientsController.insertIngredient();
                    dishMenu();
                    break;
                case 5:
                    mainMenu();
                    break;
                default:
                    System.out.println("Eingabe ungültig");
                    dishMenu();
            }
    }

    public void deliveryMenu() {
        System.out.println("\nWas möchten Sie tun?\n\nWählen Sie:\n1\talle Lieferorte anzeigen\n2\tneuen Lieferort hinzufügen" +
                "\n3\tZurück\n\n");
        Scanner deliveryScanner = new Scanner(System.in);
        int del = deliveryScanner.nextInt();

        switch (del) {
            case 1:
                List<Delivery> resultListDelivery = deliveryController.showDeliveryPlaces();
                printDelivery(resultListDelivery);
                deliveryMenu();
                break;
            case 2:
                deliveryController.insertDeliveryPlace();
                deliveryMenu();
            case 3:
                mainMenu();
                break;
            default:
                System.out.println("Eingabe ungültig");
                deliveryMenu();
        }
    }
}
