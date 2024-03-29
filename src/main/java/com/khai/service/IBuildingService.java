package com.khai.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.Validate;
import org.springframework.web.bind.annotation.RequestParam;

import com.khai.dto.BuildingDTO;

public interface IBuildingService {
	List<BuildingDTO> find(Map<String, Object> parameter, String[] types);
	void save(BuildingDTO buildingDTO);
}
