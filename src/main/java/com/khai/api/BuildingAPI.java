package com.khai.api;

import com.khai.dto.BuildingDTO;
import com.khai.service.IBuildingService;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
	private IBuildingService buildingService;
	
	@GetMapping
	public List<BuildingDTO> find(@RequestBody Map<String, Object> parameter,
								@RequestParam(value = "types", required = false) String[] types) {
		return buildingService.find(parameter, types);
	}
	
	@PostMapping
	public BuildingDTO createBuilding(@RequestBody BuildingDTO buildingDTO) {
		buildingService.save(buildingDTO);
		return buildingDTO;
	}
}