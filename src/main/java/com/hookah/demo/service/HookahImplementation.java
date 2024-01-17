package com.hookah.demo.service;

import com.hookah.demo.entity.Hookah;
import com.hookah.demo.repository.HookahRepository;

import java.util.List;

public class HookahImplementation implements  HookahService{
    private final HookahRepository hookahRepository;

    public HookahImplementation(HookahRepository hookahRepository) {
        this.hookahRepository = hookahRepository;
    }

    @Override
    public List<Hookah> gethookahs() {
        return (List<Hookah>) hookahRepository.findAll();
    }
}
