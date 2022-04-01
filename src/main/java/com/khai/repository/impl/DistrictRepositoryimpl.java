package com.khai.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.khai.dto.BuildingDTO;
import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.DistrictEntity;
import com.khai.entity.UserEntity;
import com.khai.repository.BuildingRepository;
import com.khai.repository.DistrictRepository;

@Repository
public class DistrictRepositoryimpl implements DistrictRepository {
	
	@Autowired
	AbstractReposirory abstractRepository;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

	
	


	@Override
	public DistrictEntity findDistrict(String districtId) {
		DistrictEntity result = new DistrictEntity();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		StringBuilder query = new StringBuilder("select name from district d where d.id = ");
		query.append(districtId);
		try {
			
			connection = abstractRepository.getConnection();
			statement = connection.prepareStatement(query.toString());
			rs= statement.executeQuery();
			while(rs.next()) {
				result.setName(rs.getString("name"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
		
		return result;
	}
	
	
	
	
}
