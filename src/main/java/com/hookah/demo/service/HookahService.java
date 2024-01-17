package com.hookah.demo.service;

import com.hookah.demo.entity.Hookah;

import java.util.List;

public interface HookahService {
    List<Hookah> gethookahs();

    Hookah gethookahById( Long id);

    Hookah addhookah(Hookah hookah);

    void deleteHookahById(Long id);
}
