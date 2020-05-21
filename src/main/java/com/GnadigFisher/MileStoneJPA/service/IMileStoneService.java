package com.GnadigFisher.MileStoneJPA.service;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;

import java.util.List;

public interface IMileStoneService {
    void add(MileStoneEntity entityDto);
    Iterable<MileStoneEntity> listAll();
    List<MileStoneEntity> listAllActive();
}
