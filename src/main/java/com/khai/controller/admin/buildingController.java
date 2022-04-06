package com.khai.controller.admin;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.khai.dto.BuildingDTO;
import com.khai.service.BuildingService;
import com.khai.service.UserService;

@Controller(value = "buildingControllerOfAdmin")
public class buildingController {

	@Autowired
	private BuildingService buildingService;
	
	@Autowired
	private UserService userService;
	
    @RequestMapping(value = "/admin/building-list", method = RequestMethod.GET)
	public ModelAndView buildingList(@ModelAttribute("modelSearch") BuildingDTO buildingDTO) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		mav.addObject("modelSearch", buildingDTO);
		mav.addObject("staffmaps",userService.getStaffMaps());
		return mav;
	}
    
    @RequestMapping(value = "/admin/building-list-find", method = RequestMethod.GET)
	public ModelAndView buildingFind(@ModelAttribute("modelSearch") BuildingDTO buildingDTO,
								@RequestParam Map<String, Object> parameter,
								@RequestParam(value = "types", required = false) String[] types) {
		ModelAndView mav = new ModelAndView("admin/building/list");
		mav.addObject("modelSearch", buildingDTO);
		mav.addObject("buildings", buildingService.find(parameter, types));		
		mav.addObject("staffmaps",userService.getStaffMaps());
		return mav;
	}

	@RequestMapping(value = "/admin/building-edit", method = RequestMethod.GET)
	public ModelAndView buildingEdit() {
		ModelAndView mav = new ModelAndView("admin/building/edit");
		mav.addObject("buildingModel", new BuildingDTO());
		return mav;
	}
	
}
