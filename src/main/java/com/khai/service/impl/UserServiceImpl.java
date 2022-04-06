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
import com.khai.repository.BuildingRepository;
/*import com.khai.repository.DistrictRepository;
*/import com.khai.repository.RentAreaRepository;
import com.khai.repository.UserRepository;
import com.khai.repository.custom.BuildingRepositoryCustom;
import com.khai.service.BuildingService;
import com.khai.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
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
	
	

	@Override
	public Map<Long, String> getStaffMaps() {
		Map<Long, String> result = new HashMap<>();
		List<UserEntity> staffs = UserRepositoryimpl.findByStatusAndRoles_Code(1, "staff");
		for(UserEntity item: staffs) {
			result.put(item.getId(), item.getFullName());
		}
		return null;
	}

}
