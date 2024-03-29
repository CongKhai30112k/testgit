package com.khai.api;

import com.khai.dto.BuildingDTO;
import com.khai.service.BuildingService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping
	public List<BuildingDTO> find(@RequestParam Map<String, Object> parameter,
								@RequestParam(value = "types", required = false) String[] types) {
		return buildingService.find(parameter, types);
	}
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
		buildingService.save(buildingDTO);
		return buildingDTO;
	}
	 @RequestMapping(value = "/admin/api-user-assignment", method = RequestMethod.GET)
	 public void assignBuilding(@RequestBody Long buildingId, Long[] staffId) {
			buildingService.assign(buildingId, staffId);
		}
}
