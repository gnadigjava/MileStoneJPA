package com.GnadigFisher.MileStoneJPA.controller;


import com.GnadigFisher.MileStoneJPA.dto.MileStoneDTO;
import com.GnadigFisher.MileStoneJPA.model.MileStoneEntity;
import com.GnadigFisher.MileStoneJPA.service.MileStoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Date;

@Controller
public class MileStoneController {

    private  MileStoneEntity milestone;

    private MileStoneService mileStoneService;

    @Autowired
    public void setMileStoneService(MileStoneService mileStoneService) {
        this.mileStoneService = mileStoneService;
    }

    @GetMapping(value = "/main")
    public String getRoot() {
        return "/main";
    }

    @GetMapping(value = "/milestone_list")
    public ModelAndView getMilestoneList(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("milestone_list");
        mav.addObject("milestoneList", mileStoneService.listAllActive());
        return mav;
    }

    @RequestMapping(value = "/delete_milestone", method = RequestMethod.GET)
    public ModelAndView deleteMilestone(@RequestParam(name="mileStoneId")String mileStoneId) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("milestone_list");

        mileStoneService.delete(Long.parseLong(mileStoneId));
        /*for (MileStoneEntity milestoneentity : mileStoneService.listAllActive()) {
            if (milestoneentity.equals(gottenMilestone)){
                milestoneentity.setActive(false);

            }
        }*/
        mav.setViewName("redirect:/milestone_list");
        return mav;
    }


    @GetMapping(value = "/add_milestone")
    public ModelAndView getNewMilestone(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("add_milestone");
        mav.addObject("mileStoneDTO", new MileStoneDTO(new Date(),"",""));
        return mav;
    }

    @PostMapping(value = "/add_milestone")
    public ModelAndView postNewMilestone(@Valid MileStoneDTO mileStoneDTO, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();

        if (bindingResult.hasErrors()){
            mav.setViewName("add_milestone");
        }
        else {
            MileStoneEntity mileStone = new MileStoneEntity(1, mileStoneDTO.getDate(), mileStoneDTO.getName(), mileStoneDTO.getComment());
            mileStoneService.add(mileStone);
            mav.setViewName("redirect:/milestone_list");
        }
        return mav;
    }
}
