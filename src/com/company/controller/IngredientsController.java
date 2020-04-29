package com.company.controller;

import com.company.model.repositorys.IngredientRepository;

import java.util.List;

public class IngredientsController {

    public static List showAllIngredients() {
        IngredientRepository ingredientRepository = new IngredientRepository();
        return ingredientRepository.findAll();
    }

        public static void insertIngredient() {
        IngredientRepository ingredientRepository = new IngredientRepository();
        ingredientRepository.create();
        }
    }


