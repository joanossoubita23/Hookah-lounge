package com.hookah.demo.service;

import com.hookah.demo.entity.Drinks;
import com.hookah.demo.repository.DrinkRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class DrinkImplementation implements DrinkService {
   private  final DrinkRepository drinkRepository;

    public DrinkImplementation(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }


    @Override
    public List<Drinks> getdrinks() {
        return  drinkRepository.findAll();
    }

    @Override
    public Drinks getDrinksById(Long id) {
        Optional<Drinks> optionalDrinks = drinkRepository.findById(id);
        if (optionalDrinks.isPresent()) {
           return optionalDrinks.get();
        } else {
            throw new EntityNotFoundException("Drinks with id" + id + "Cannot be found try again");
        }
    }

    @Override
    public Drinks addDrink(Drinks drinks) {
        return drinkRepository.save(drinks);
    }

    @Override
    public void deleteDrinkById(Long id) {
        drinkRepository.deleteById(id);
    }

    @Override
    public Drinks updateDrinkById(Long id, Drinks drinks) {
        Drinks existingDrinks=getDrinksById(id);
        existingDrinks.setName(existingDrinks.getName());
        existingDrinks.setPrice(existingDrinks.getPrice());
        drinkRepository.save(existingDrinks);
        return existingDrinks;
    }
}
