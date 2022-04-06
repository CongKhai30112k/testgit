package com.khai.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.UserEntity;
import com.khai.enums.BuildingTypesEnum;
import com.khai.enums.DistrictsEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import com.khai.converter.BuildingConverter;
import com.khai.dto.BuildingDTO;
import com.khai.repository.AssignBuildingRepository;
import com.khai.repository.BuildingRepository;
/*import com.khai.repository.DistrictRepository;
*/import com.khai.repository.RentAreaRepository;
import com.khai.repository.UserRepository;
import com.khai.repository.custom.BuildingRepositoryCustom;
import com.khai.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService {
	
	@Autowired
	private BuildingConverter buildingConverter;
	
	@Autowired
	private BuildingRepository buildingRepositoryimpl;
	
	/*@Autowired 
	private DistrictRepository districtRepositoryimpl;*/
	
	@Autowired
	private RentAreaRepository rentAreaRepositoryimpl;
	
	@Autowired
	UserRepository UserRepositoryimpl;
	
	@Autowired
	AssignBuildingRepository assignBuildingRepositoryimpl;
	
	@Override
	public Map<String, String> getDistricts() {
		Map<String, String> districts = new HashMap<>();
		for (DistrictsEnum item: DistrictsEnum.values()) {
			districts.put(item.toString(), item.getDistrictValue());
		}
		return districts;
	}

	@Override
	public Map<String, String> getBuildingTypes() {
		Map<String, String> buildingTypes = new HashMap<>();
		for (BuildingTypesEnum item: BuildingTypesEnum.values()) {
			buildingTypes.put(item.toString(), item.getBuildingTypeValue());
		}
		return buildingTypes;
	}

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
	@Transactional
	public void save(BuildingDTO buildingDTO) {
		//Integer costRentFrom = parameter.containsKey("costRentFrom") ? Integer.class.cast(parameter.get("costRentFrom")) : null;

		String[] s = buildingDTO.getAreaRent().split(",");
		List<Integer> rentArea = new ArrayList<>();
		for(String item:s) {
			rentArea.add(Integer.class.cast(item));
		}
		BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
		long id = buildingRepositoryimpl.save(buildingEntity).getId();
		rentAreaRepositoryimpl.save(rentArea, id);
	}

	@Override
	public void assign(Long buildingId, Long[] staffId) {

		assignBuildingRepositoryimpl.assign(buildingId, staffId);
	}


}
