package com.khai.repository.custom.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.khai.Utils.MapUtils;
import com.khai.constant.SystemConstant;
import com.khai.entity.BuildingEntity;
import com.khai.repository.custom.BuildingRepositoryCustom;
import com.khai.repository.custom.RentAreaRepositoryCustom;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void save(List<Integer> rentArea, Long buildingid) {
		StringBuilder sql = new StringBuilder("insert into rentarea(value, buildingid) values(");
		for(Integer item:rentArea) {
			sql.append(item+","+buildingid);
		}
		sql.append(")");
	}
	
}
