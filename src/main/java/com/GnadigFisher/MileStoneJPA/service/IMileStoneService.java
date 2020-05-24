package com.GnadigFisher.MileStoneJPA.service;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;

import java.util.List;
import java.util.Optional;

public interface IMileStoneService {
    void add(MileStoneEntity entityDto);
    Iterable<MileStoneEntity> listAll();
    List<MileStoneEntity> listAllActive();
    void delete(long id);

    Optional<MileStoneEntity> findByName(String name);
}
