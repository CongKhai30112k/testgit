package com.khai.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khai.entity.UserEntity;

public interface UserRepository extends JpaRepository<Long, UserEntity>{

	List<UserEntity> findByStatusAndRoles_Code(Integer status, String roleCode);
}
