package com.GnadigFisher.MileStoneJPA.service;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;
import com.GnadigFisher.MileStoneJPA.repository.MileStoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MileStoneService implements IMileStoneService{
    private MileStoneRepository mileStoneRepository;

    @Autowired
    public void setMileStoneRepository(MileStoneRepository mileStoneRepository) {
        this.mileStoneRepository = mileStoneRepository;
    }

    @Override
    public void add(MileStoneEntity mileStoneEntity) {
        mileStoneRepository.save(mileStoneEntity);
    }

    @Override
    public Iterable<MileStoneEntity> listAll() {

        return mileStoneRepository.findAll();
    }

    @Override
    public List<MileStoneEntity> listAllActive() {
        return mileStoneRepository.findByActiveTrue();
    }

    @Override
    public void delete(long mileStoneId) {
        Optional<MileStoneEntity> mileStoneEntity = mileStoneRepository.findById(mileStoneId);
        System.out.println("it vagyok Fönök!");
        if(mileStoneEntity.isPresent()){
            System.out.println("benvagyok Fönök!");
            mileStoneEntity.get().setActive(false);
            mileStoneRepository.save(mileStoneEntity.get());
        }
    }

    @Override
    public Optional<MileStoneEntity> findByName(String name){
        Optional<MileStoneEntity> entity = mileStoneRepository.findByName(name);

        return entity;
    }
}
