package com.hookah.demo.service;

import com.hookah.demo.entity.Drinks;
import com.hookah.demo.repository.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
