package com.khai.repository.custom;

import java.util.List;
import java.util.Map;

import com.khai.entity.BuildingEntity;

public interface RentAreaRepositoryCustom {
	void save(List<Integer> rentArea,Long buildingid);
}
