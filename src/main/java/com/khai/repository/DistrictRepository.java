package com.khai.repository;

import com.khai.dto.BuildingDTO;
import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.DistrictEntity;
import com.khai.entity.UserEntity;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

public interface DistrictRepository {
	DistrictEntity findById(Long id);

}
