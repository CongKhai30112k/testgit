package com.khai.controller.admin;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khai.dto.BuildingDTO;
import com.khai.service.IBuildingService;

@Controller(value = "buildingControllerOfAdmin")
public class buildingController {

	@Autowired
	private IBuildingService buildingService;
	
    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList() {
		ModelAndView mav = new ModelAndView("admin/building/list");

		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingModel", new BuildingDTO());
		return mav;
	}
	
}
