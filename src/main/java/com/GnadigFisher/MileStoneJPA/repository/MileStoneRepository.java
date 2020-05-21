package com.GnadigFisher.MileStoneJPA.repository;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MileStoneRepository extends CrudRepository<MileStoneEntity, Long> {

    Optional<MileStoneEntity> findByName(String name);

    List<MileStoneEntity> findByActiveTrue();

}