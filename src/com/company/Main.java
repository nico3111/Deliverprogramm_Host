package com.company;

import com.company.view.MenuView;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n\n***  Willkommen in Ihrem Gastro Manager Programm!  ***\n\n");
        MenuView menuView = new MenuView();

        menuView.mainMenu();
    }
}
