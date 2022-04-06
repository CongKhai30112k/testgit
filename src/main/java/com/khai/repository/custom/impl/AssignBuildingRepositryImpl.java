package com.khai.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.khai.repository.custom.AssignBuildingRepositoryCustom;

@Repository
public class AssignBuildingRepositryImpl implements AssignBuildingRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void assign(Long buildingId, Long[] staffId) {
		StringBuilder sql = new StringBuilder("insert into assignmentbuilding(buildingid, staffid) values(");
		for(Long item:staffId) {
			sql.append(buildingId+","+item);
		}
		sql.append(")");
		
	}
	
	
}
