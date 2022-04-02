package com.khai.repository.custom.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;

import com.khai.dto.BuildingDTO;

@Component
public class AbstractReposirory {

	static ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
	/*public static void main(String[] args) {
		 if(getConnection() == null) {
			 System.out.println("loi");
		 }
		 String s = "select * from building";
		 List<BuildingDTO> result = new ArrayList<>();
		 Connection connection = null;
			PreparedStatement statement = null;
			ResultSet rs = null;
			connection = getConnection();
			try {
				statement = connection.prepareStatement(s.toString());
				rs= statement.executeQuery();
				while(rs.next()) {
					BuildingDTO buildingDTO = new BuildingDTO();
					buildingDTO.setName(rs.getString("name"));
					System.out.println(buildingDTO.getName());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
	*/

}
