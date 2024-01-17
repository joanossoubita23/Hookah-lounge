package com.hookah.demo.service;

import com.hookah.demo.entity.Drinks;
import com.hookah.demo.repository.HookahRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class DrinkImplementation implements DrinkService {
    private  final HookahRepository hookahRepository;

    public DrinkImplementation(HookahRepository hookahRepository) {
        this.hookahRepository = hookahRepository;
    }

    @Override
    public List<Drinks> getdrinks() {
        return null;
    }
}
