package com.GnadigFisher.MileStoneJPA.controller;

import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;
import com.GnadigFisher.MileStoneJPA.service.MileStoneService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MileStoneController.class)
class MileStoneControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private MileStoneService service;

    //Test cases:
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        MileStoneEntity alex = new MileStoneEntity(1, new Date(), "milestoneName", "nothing");

        List<MileStoneEntity> allEmployees = Arrays.asList(alex);

        given(service.listAll()).willReturn(allEmployees);

        /*mvc.perform(getMilestoneList()
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));*/
    }

    @Test
    void setMileStoneService() {
    }

    @Test
    void getRoot() {
    }

    @Test
    void getMilestoneList() {
    }

    @Test
    void deleteMilestone() {
    }

    @Test
    void getNewMilestone() {
    }

    @Test
    void postNewMilestone() {
    }
}