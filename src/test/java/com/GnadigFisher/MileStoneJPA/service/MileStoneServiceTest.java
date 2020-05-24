package com.GnadigFisher.MileStoneJPA.service;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;
import com.GnadigFisher.MileStoneJPA.repository.MileStoneRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
class MileStoneServiceTest {

    //Configurations for further integration-testing
    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public IMileStoneService mileStoneService() {
            return new MileStoneService();
        }
    }

    @Autowired
    private IMileStoneService mileStoneService;

    @MockBean
    private MileStoneRepository mileStoneRepository;

    //BEFORE
    @Before
    public void setUp() {
        MileStoneEntity milestone = new MileStoneEntity(1, new Date(), "milestoneName", "nothing");

        Mockito.when(mileStoneRepository.findByName(milestone.getName()))
                .thenReturn(Optional.of(milestone));
    }

    //Test cases:
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String milestoneName = "milestoneName";
        Optional<MileStoneEntity> found = mileStoneService.findByName(milestoneName);

        assertThat(found.get().getName())
                .isEqualTo(milestoneName);
    }

    @Test
    void add() {
    }

    @Test
    void listAll() {
    }

    @Test
    void listAllActive() {
    }

    @Test
    void delete() {
    }
}