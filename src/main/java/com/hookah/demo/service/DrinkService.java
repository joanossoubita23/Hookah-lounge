package com.hookah.demo.service;

import com.hookah.demo.entity.Drinks;

import java.util.List;

public interface DrinkService {
    List<Drinks> getdrinks();

    Drinks getDrinksById(Long id);

    Drinks addDrink(Drinks drinks);

    void deleteDrinkById(Long id);

    Drinks updateDrinkById(Long id, Drinks drinks);
}
