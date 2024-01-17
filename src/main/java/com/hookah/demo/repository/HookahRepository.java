package com.hookah.demo.repository;

import com.hookah.demo.entity.Hookah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HookahRepository extends JpaRepository<Hookah,Long> {
}
