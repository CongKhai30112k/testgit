package com.khai.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.DistrictEntity;
import com.khai.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.khai.converter.BuildingConverter;
import com.khai.dto.BuildingDTO;
import com.khai.repository.BuildingRepository;
import com.khai.repository.DistrictRepository;
import com.khai.service.IBuildingService;

@Service
public class BuildingService implements IBuildingService {
	
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Autowired
	private BuildingRepository buildingRepositoryimpl;
	
	@Autowired 
	private DistrictRepository districtRepositoryimpl;

	@Override
	public List<BuildingDTO> find(Map<String, Object> parameter,String[] types) {
		
		//java 7
		/*List<BuildingDTO> result = new ArrayList<BuildingDTO>();
		List<BuildingEntity> buildings = buildingRepositoryimpl.find(parameter, types);
		for (BuildingEntity building: buildings) {
			result.add(buildingConverter.convertToDTO(building));
		}
		
		return result;*/
		
		//java 8 
		List<BuildingEntity> buildings = buildingRepositoryimpl.find(parameter, types);
		List<BuildingDTO> result = buildings.stream()
									.map(building -> buildingConverter.convertToDTO(building))
									.collect(Collectors.toList());
		return result;
	}

	@Override
	public void save(BuildingDTO buildingDTO) {

		
	}

}
