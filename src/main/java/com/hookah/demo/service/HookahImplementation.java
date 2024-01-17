package com.hookah.demo.service;

import com.hookah.demo.entity.Hookah;
import com.hookah.demo.repository.HookahRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HookahImplementation implements  HookahService{
    private final HookahRepository hookahRepository;

    public HookahImplementation(HookahRepository hookahRepository) {
        this.hookahRepository = hookahRepository;
    }

    @Override
    public List<Hookah> gethookahs() {

        return (List<Hookah>) hookahRepository.findAll();
    }

    @Override
    public Hookah gethookahById(Long id) {
        Optional<Hookah> optionalHookah= hookahRepository.findById(id);
        if (optionalHookah.isPresent()){
            return optionalHookah.get();
        }else {
            throw new EntityNotFoundException("Hookah with id"+id+ "id not found");
        }
    }
}
