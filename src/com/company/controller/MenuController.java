package com.company.controller;

import com.company.model.models.Menu;
import com.company.model.repositorys.MenuRepository;
import com.company.view.MenuView;

import java.util.List;

public class MenuController {

    public static List<Menu> showAllMenu() {
        MenuRepository menuRepository = new MenuRepository();
        return menuRepository.findAll();
    }

    public static void insertDish() {
        MenuRepository dishRepository = new MenuRepository();
    }
}
