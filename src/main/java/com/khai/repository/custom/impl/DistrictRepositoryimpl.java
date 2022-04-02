package com.khai.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.khai.entity.BuildingEntity;

import com.khai.repository.custom.DistrictRepositoryCustom;

@Repository
public class DistrictRepositoryImpl implements DistrictRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	/*@Override
	public DistrictEntity findById(Long id) {

		String sql = "select * from district where id = " + id;
		Query query = entityManager.createQuery(sql.toString(), DistrictEntity.class);
		return (DistrictEntity) query.getSingleResult();
	}
	*/
	
}
