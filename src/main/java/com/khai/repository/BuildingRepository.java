package com.khai.repository;

import com.khai.dto.BuildingDTO;
import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.UserEntity;
import com.khai.repository.custom.BuildingRepositoryCustom;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long> , BuildingRepositoryCustom{
//	List<BuildingEntity> find(Map<String, String> parameter, List<String> types);
	List<BuildingEntity> findByNameAndNumberOfBasement(String name, Integer numberOfBasement);

}
