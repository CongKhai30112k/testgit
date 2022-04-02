package com.khai.repository.custom;

import java.util.List;
import java.util.Map;

import com.khai.entity.BuildingEntity;

public interface BuildingRepositoryCustom {
	List<BuildingEntity> find(Map<String, Object> parameter, String[] types);
}
