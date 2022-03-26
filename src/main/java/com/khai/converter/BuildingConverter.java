package com.khai.converter;

import com.khai.entity.BuildingEntity;
import com.khai.entity.DistrictEntity;
import com.khai.repository.DistrictRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.khai.dto.BuildingDTO;

@Component
public class BuildingConverter {
	
	@Autowired 
	private DistrictRepository districtRepositoryimpl;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	public BuildingDTO convertToDTO(BuildingEntity entity) {
		BuildingDTO dto = modelMapper.map(entity, BuildingDTO.class);
		/*dto.setName(dto.getName());
		dto.setCreatedDate(dto.getCreatedDate());
		dto.setManagerName(dto.getManagerName());
		dto.setManagerPhone(dto.getManagerPhone());
		dto.setBuildingArea(dto.getBuildingArea());
		dto.setCostRent(dto.getCostRent());
		dto.setServiceCost(dto.getServiceCost());
		dto.setCostDescription(dto.getCostDescription());*/
		DistrictEntity district = districtRepositoryimpl.findDistrict(entity.getDistrictid());
		dto.setAddress(entity.getStreet() +", "+ entity.getWard() +", "+district.getName());
		return dto;
	}
	
	public BuildingEntity convertToEntity(BuildingDTO dto) {
		BuildingEntity entity = modelMapper.map(dto, BuildingEntity.class);
		return entity;
	}

}
