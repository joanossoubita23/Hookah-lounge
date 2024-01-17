package com.hookah.demo.repository;

import com.hookah.demo.entity.Drinks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DrinkRepository extends JpaRepository<Drinks,Long> {
}
