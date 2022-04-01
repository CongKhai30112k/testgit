package com.khai.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.khai.Utils.MapUtils;
import com.khai.Utils.ValidateUtils;
import com.khai.constant.SystemConstant;
import com.khai.dto.BuildingDTO;
import com.khai.entity.RentAreaEntity;
import com.khai.entity.BuildingEntity;
import com.khai.entity.UserEntity;
import com.khai.repository.BuildingRepository;

@Repository
public class BuildingRepositoryimpl implements BuildingRepository {
	
	@Autowired
	AbstractReposirory abstractRepository;
	ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

	@Autowired
	ValidateUtils validateUtils;
	/*public static void main(String[] args) {
		BuildingRepositoryimpl b = new BuildingRepositoryimpl();
		if(b.getConnection() == null) {
			 System.out.println("loi");
		 }
	}*/

	@Override
	public List<BuildingEntity> find(Map<String, Object> parameter, String[] types) {
		StringBuilder query = new StringBuilder("select b.name, b.street, b.ward, b.districtid, b.createdDate, b.floorarea, b.rentprice, b.servicefee, b.rentpricedescription from building AS b join district d on d.id = b.districtid");
		query = buildJoinQuery(parameter, types, query);
		query.append(" where "+SystemConstant.ONE_ONE);
		query = buildSqlPart1(parameter, types, query);
		query = buildSqlPart2(parameter, types, query);
		query.append(" group by b.id");
		return null;
	}
	private StringBuilder buildSqlPart2(Map<String, Object> parameter, String[] types, StringBuilder query) {
		//Integer staffid = parameter.containsKey("staffid") ? Integer.parseInt((String) parameter.get("staffid")) : null;
		Integer staffid = MapUtils.getObject(parameter, "staffid", Integer.class);
		if(staffid != null) {
			query.append(" inner join assignmentbuilding as ab on ab.buildingid = b.id");
		}
		return null;
	}
	
	//part 1:sql normal
	private StringBuilder buildSqlPart1(Map<String, Object> parameter, String[] types, StringBuilder query) {
		for(Map.Entry<String, Object> entry: parameter.entrySet()) {
			if(!entry.getKey().equals("types") && !entry.getKey().startsWith("costrent")
					&& !entry.getKey().startsWith("arearent") && !entry.getKey().equals("staffid")
					&& !entry.getKey().equals("district")) {
			
				if(entry.getValue() instanceof String) {
					query.append(" and b."+entry.getKey().toLowerCase()+" like '%"+entry.getValue()+"%'");
				}else if(entry.getValue() instanceof Integer) {
					query.append(" and b."+entry.getKey().toLowerCase()+" = "+entry.getValue());
				}
			}
		}
		return query;
	}
	//part 2 sql special
	private StringBuilder buildJoinQuery(Map<String, Object> parameter, String[] types, StringBuilder query) {

		/*Integer costRentFrom = parameter.containsKey("costRentFrom") ? Integer.class.cast(parameter.get("costRentFrom")) : null;
		
		Integer costRentTo = parameter.containsKey("costRentTo") ? Integer.parseInt((String) parameter.get("costRentTo")) : null;
		Integer areaRentFrom = parameter.containsKey("areaRentFrom") ? Integer.parseInt((String) parameter.get("areaRentFrom")) : null;
		Integer areaRentTo = parameter.containsKey("areaRentTo") ? Integer.parseInt((String) parameter.get("areaRentTo")) : null;*/
		Integer costRentFrom = MapUtils.getObject(parameter, "costRentFrom", Integer.class);
		Integer costRentTo = MapUtils.getObject(parameter, "costRentTo", Integer.class);
	    Integer areaRentFrom = MapUtils.getObject(parameter, "areaRentFrom", Integer.class);
	    Integer areaRentTo = MapUtils.getObject(parameter, "areaRentTo", Integer.class);
		if(costRentFrom!=null) {
			query.append(" and b.rentprice >= "+ costRentFrom);
		}
		if(costRentTo!=null) {
			query.append(" and b.rentprice <= "+ costRentTo);
		}
		if(areaRentFrom != null || areaRentTo != null) {
			query.append(" and EXISTS (select * from rentarea as ra where b.id = ra.buildingid");
			if(areaRentFrom!=null) {
				query.append(" and ra.value >= "+areaRentFrom);
			}
			if(areaRentTo!=null) {
				query.append(" and ra.value <= "+areaRentTo);
			}
			query.append(")");
		}
		
		/*//java 7
		if(types != null && types.length > 0) {
			query.append(" and (");
			int i=0;
			for(String item:types) {
				types[i] = "rt.code = '"+item+"'";
				i++;
			}
			String sqlType = String.join(" or ", types);
			query.append(sqlType);
			query.append(")");
		}*/
		//java 8
		if(types != null && types.length > 0) {
			query.append(" and (");
			String sqlType = Arrays.stream(types).map(item -> "rt.code = '"+item+"'").collect(Collectors.joining(" or "));
			query.append(")");
		}
		return query;
	}

	/*@Override
	public List<BuildingEntity> find(Map<String, String> parameter, List<String> types) {
		List<BuildingEntity> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		
		StringBuilder query = new StringBuilder("select b.name, b.street, b.ward, b.districtid, b.createdDate, b.floorarea, b.rentprice, b.servicefee, b.rentpricedescription from building AS b join district d on d.id = b.districtid ");
				
		StringBuilder joinQuery = new StringBuilder();
		StringBuilder whereQuery = new StringBuilder();
		
		buildQueryWithJoin(parameter, types, whereQuery, joinQuery);
		buildQueryWithoutJoin(parameter, whereQuery);
		
		query.append(joinQuery)
			.append("where 1 = 1 ")
			.append(whereQuery)
			.append("group by b.id");
		try {
			
			connection = abstractRepository.getConnection();
			statement = connection.prepareStatement(query.toString());
			rs= statement.executeQuery();
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				buildingEntity.setDistrictid(rs.getString("districtid"));
				buildingEntity.setCreatedDate(rs.getTimestamp("createdDate"));
				buildingEntity.setBuildingArea(rs.getString("floorarea"));
				buildingEntity.setCostRent(rs.getInt("rentprice"));
				buildingEntity.setServiceCost(rs.getString("servicefee"));
				buildingEntity.setCostDescription(rs.getString("rentpricedescription"));
				result.add(buildingEntity);
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
	private void buildQueryWithoutJoin(Map<String, String> parameter, StringBuilder whereQuery) {
		if(parameter.get("name") != null && !((String) parameter.get("name")).trim().isEmpty()) {
			whereQuery.append("and b.name = " +"\'"+parameter.get("name")+"\' ");
			
		}
		if(parameter.get("buildingArea") != null && !((String) parameter.get("buildingArea")).trim().isEmpty()) {
			whereQuery.append("and b.floorarea = "+"\'"+parameter.get("buildingArea")+"\' ");
		}
		if(parameter.get("ward") != null && !((String) parameter.get("ward")).trim().isEmpty()) {
			whereQuery.append("and b.ward = " +"\'"+ parameter.get("ward")+"\' ");		
		}
		if(parameter.get("street") != null && !((String) parameter.get("street")).trim().isEmpty()) {
			whereQuery.append("and b.street = " +"\'"+ parameter.get("street")+"\' ");
		}
		if(parameter.get("numberOfBasement") != null && !((String) parameter.get("numberOfBasement")).trim().isEmpty()) {
			whereQuery.append("and b.numberOfBasement = " +"\'"+ parameter.get("numberOfBasement")+"\' ");
		}
		if(parameter.get("direction") != null && !((String) parameter.get("direction")).trim().isEmpty()) {
			whereQuery.append("and b.direction = " +"\'"+ parameter.get("direction")+"\' ");
		}
		if(parameter.get("level") != null && !((String) parameter.get("level")).trim().isEmpty()) {
			whereQuery.append("and b.level = " +"\'"+ parameter.get("level")+"\' ");
		}
		
		if(parameter.get("costRentFrom") != null && !((String) parameter.get("costRentFrom")).trim().isEmpty()) {
			whereQuery.append("and b.rentprice >= " +"\'"+ parameter.get("costRentFrom")+"\' ");
		}
		if(parameter.get("costRentTo") != null && !((String) parameter.get("costRentTo")).trim().isEmpty()) {
			whereQuery.append("and b.rentprice <=" +"\'"+ parameter.get("costRentTo")+"\' ");
		}
		String name = parameter.getOrDefault("name", null);
		if(validateUtils.isNotBlank(name)) {
			whereQuery.append("and b.name = " +"\'"+name+"\' ");
		}
		
		String buildingArea = parameter.getOrDefault("buildingArea", null);
		if(validateUtils.isNotBlank(buildingArea)) {
			whereQuery.append("and b.floorarea = "+"\'"+buildingArea+"\' ");
		}
		String ward = parameter.getOrDefault("ward", null);
		if(validateUtils.isNotBlank(ward)) {
			whereQuery.append("and b.ward = " +"\'"+ward+"\' ");
		}
		String street = parameter.getOrDefault("street", null);
		if(validateUtils.isNotBlank(street)) {
			whereQuery.append("and b.street = " +"\'"+street+"\' ");
		}
		String numberOfBasement = parameter.getOrDefault("numberOfBasement", null);
		if(validateUtils.isNotBlank(numberOfBasement)) {
			whereQuery.append("and b.numberOfBasement = " +"\'"+numberOfBasement+"\' ");
		}
		String direction = parameter.getOrDefault("direction", null);
		if(validateUtils.isNotBlank(direction)) {
			whereQuery.append("and b.direction = " +"\'"+direction+"\' ");
		}
		String level = parameter.getOrDefault("level", null);
		if(validateUtils.isNotBlank(level)) {
			whereQuery.append("and b.level = " +"\'"+level+"\' ");
		}
		String costRentFrom = parameter.getOrDefault("costRentFrom", null);
		if(validateUtils.isNotBlank(costRentFrom)) {
			whereQuery.append("and b.rentprice = " +"\'"+costRentFrom+"\' ");
		}
		String costRentTo = parameter.getOrDefault("costRentTo", null);
		if(validateUtils.isNotBlank(costRentTo)) {
			whereQuery.append("and b.rentprice = " +"\'"+costRentTo+"\' ");
		}
		
	}

	private void buildQueryWithJoin(Map<String, String> parameter, List<String> types, StringBuilder whereQuery,
			StringBuilder joinQuery) {
		String districtCode = parameter.getOrDefault("district", null);
		if(validateUtils.isNotBlank(districtCode)) {
			whereQuery.append("and d.code = '")
					.append(districtCode)
					.append("' ");
			
		}
		String areaRentFrom = parameter.getOrDefault("areaRentFrom", null);
		String areaRentTo = parameter.getOrDefault("areaRentTo", null);
		if(validateUtils.isNotBlank(areaRentFrom)||validateUtils.isNotBlank(areaRentTo)) {
			joinQuery.append("JOIN rentarea AS re ON re.buildingid = b.id ");
			if(validateUtils.isNotBlank(areaRentFrom)) {
				whereQuery.append("and re.value >= " +"\'"+areaRentFrom+"\' ");
			}
			if(validateUtils.isNotBlank(areaRentTo)) {
				whereQuery.append("and re.value <=" +"\'"+areaRentTo+"\' ");
			}
		}
		String managerName = parameter.getOrDefault("managerName", null);
		String managerPhone = parameter.getOrDefault("managerPhone", null);
		if(validateUtils.isNotBlank(managerName)||validateUtils.isNotBlank(managerPhone)) {
			joinQuery.append("JOIN assignmentbuilding AS a ON a.buildingid = b.id ");
			whereQuery.append("and a.staffid = " +"\'"+ parameter.get("staffid")+"\' ");
		}
		if(validateUtils.isNotBlank(types)) {
			joinQuery.append("JOIN buildingrenttype AS r ON r.buildingid = b.id ")
					 .append("JOIN renttype rt on rt.id = r.id ");
			whereQuery.append("and rt.code in ('")
					  .append(String.join("','", types))
					  .append("') ");
		}*/
		/*if(parameter.get("areaRentFrom") != null && !((String) parameter.get("areaRentFrom")).trim().isEmpty()||
		   (parameter.get("areaRentTo") != null && !((String) parameter.get("areaRentTo")).trim().isEmpty())) {
			joinQuery.append("JOIN rentarea AS re ON re.buildingid = b.id ");
			
			if(parameter.get("areaRentFrom") != null && !((String) parameter.get("areaRentFrom")).trim().isEmpty()) {
				whereQuery.append("and re.value >= " +"\'"+ parameter.get("areaRentFrom")+"\' ");
			}
			else if(parameter.get("areaRentTo") != null && !((String) parameter.get("areaRentTo")).trim().isEmpty()) {
				whereQuery.append("and re.value <=" +"\'"+ parameter.get("areaRentTo")+"\' ");
			}
		}
		if(parameter.get("managerName") != null && !((String) parameter.get("managerName")).trim().isEmpty()||
		   (parameter.get("managerPhone") != null && !((String) parameter.get("managerPhone")).trim().isEmpty())
		){
			joinQuery.append("JOIN assignmentbuilding AS a ON a.buildingid = b.id ");
			whereQuery.append("and a.staffid = " +"\'"+ parameter.get("staffid")+"\' ");

		}
		if(types != null && !types.isEmpty()) {
			joinQuery.append("JOIN buildingrenttype AS r ON r.buildingid = b.id ")
					.append("JOIN renttype rt on rt.id = r.id ");
			//cach 1
			
				whereQuery.append("and (");
				for (String type : types) {
					whereQuery.append("r.renttypeid = " +"\'"+ type+"\'" +" or ");
				}
				whereQuery = whereQuery.delete(whereQuery.length()-4,whereQuery.length());

				whereQuery.append(") ");
			
			//cach 2
			whereQuery.append("and rt.code in ('")
					.append(String.join("','", types))
					.append("'");
		}
	}*/
	
	
	
	/*@Override
	public List<BuildingEntity> find(Map<String, String> parameter, List<String> types) {
		
		List<BuildingEntity> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		StringBuilder query = new StringBuilder("select * from building AS b");
		if(parameter.get("managerName") != null && !((String) parameter.get("managerName")).trim().isEmpty()||
		   (parameter.get("managerPhone") != null && !((String) parameter.get("managerPhone")).trim().isEmpty())
		  ){
			query.append(" LEFT JOIN assignmentbuilding AS a ON a.buildingid = b.id");
			query.append(" LEFT JOIN user AS u ON a.staffid = u.id");
		}
		else if(parameter.get("areaRentFrom") != null && !((String) parameter.get("areaRentFrom")).trim().isEmpty()||
		   (parameter.get("areaRentTo") != null && !((String) parameter.get("areaRentTo")).trim().isEmpty())) {
			query.append(" LEFT JOIN rentarea AS re ON re.buildingid = b.id");
		}
		else if(types != null && !types.isEmpty()) {
			query.append(" LEFT JOIN buildingrenttype AS r ON r.buildingid = b.id");
		}
		query.append(" where ");
		if(parameter.get("name") != null && !((String) parameter.get("name")).trim().isEmpty()) {
			query.append("name = " +"\'"+parameter.get("name")+"\'"+" and ");
			
		}
		if(parameter.get("buildingArea") != null && !((String) parameter.get("buildingArea")).trim().isEmpty()) {
			query.append("floorarea = "+"\'"+parameter.get("buildingArea")+"\'"+" and ");
		}
		if(parameter.get("ward") != null && !((String) parameter.get("ward")).trim().isEmpty()) {
			query.append("ward = " +"\'"+ parameter.get("ward")+"\'" +" and ");		
		}
		if(parameter.get("street") != null && !((String) parameter.get("street")).trim().isEmpty()) {
			query.append("street = " +"\'"+ parameter.get("street")+"\'" +" and ");
		}
		if(parameter.get("district") != null && !((String) parameter.get("district")).trim().isEmpty()) {
			query.append("district = " +"\'"+ parameter.get("district")+"\'" +" and ");
		}
		if(parameter.get("numberOfBasement") != null && !((String) parameter.get("numberOfBasement")).trim().isEmpty()) {
			query.append("numberOfBasement = " +"\'"+ parameter.get("numberOfBasement")+"\'" +" and ");
		}
		if(parameter.get("direction") != null && !((String) parameter.get("direction")).trim().isEmpty()) {
			query.append("direction = " +"\'"+ parameter.get("direction")+"\'" +" and ");
		}
		if(parameter.get("level") != null && !((String) parameter.get("level")).trim().isEmpty()) {
			query.append("level = " +"\'"+ parameter.get("level")+"\'" +" and ");
		}
		if(parameter.get("costRentFrom") != null && !((String) parameter.get("costRentFrom")).trim().isEmpty()&&parameter.get("costRentTo") != null && !((String) parameter.get("costRentTo")).trim().isEmpty()) {
			query.append("rentprice >= " +"\'"+ parameter.get("costRentFrom")+"\'" +" and " +"rentprice <=" +"\'"+ parameter.get("costRentTo")+"\'" +" and ");
		}
		else if(parameter.get("costRentFrom") != null && !((String) parameter.get("costRentFrom")).trim().isEmpty()&&parameter.get("costRentTo") == null && ((String) parameter.get("costRentTo")).trim().isEmpty()) {
			query.append("rentprice >= " +"\'"+ parameter.get("costRentFrom")+"\'" +" and ");
		}
		else if(parameter.get("costRentFrom") == null&&parameter.get("costRentTo") != null && !((String) parameter.get("costRentTo")).trim().isEmpty()) {
			query.append("rentprice <=" +"\'"+ parameter.get("costRentTo")+"\'" +" and ");
		}
		if(parameter.get("areaRentFrom") != null && !((String) parameter.get("areaRentFrom")).trim().isEmpty()&&parameter.get("areaRentTo") != null && !((String) parameter.get("areaRentTo")).trim().isEmpty()) {
			query.append("value >= " +"\'"+ parameter.get("areaRentFrom")+"\'" +" and " +"value <=" +"\'"+ parameter.get("areaRentTo")+"\'" +" and ");
		}
		else if(parameter.get("areaRentFrom") != null && !((String) parameter.get("areaRentFrom")).trim().isEmpty()&&parameter.get("areaRentTo") == null && ((String) parameter.get("areaRentTo")).trim().isEmpty()) {
			query.append("value >= " +"\'"+ parameter.get("areaRentFrom")+"\'" +" and ");
		}
		else if(parameter.get("areaRentFrom") == null&&parameter.get("areaRentTo") != null && !((String) parameter.get("areaRentTo")).trim().isEmpty()) {
			query.append("value <=" +"\'"+ parameter.get("areaRentTo")+"\'" +" and ");
		}
		
		if(parameter.get("managerName") != null && !((String) parameter.get("managerName")).trim().isEmpty()) {
			query.append("managerName = " +"\'"+ parameter.get("managerName")+"\'" +" and ");
		}
		if(parameter.get("managerPhone") != null && !((String) parameter.get("managerPhone")).trim().isEmpty()) {
			query.append("managerPhone = " +"\'"+ parameter.get("managerPhone")+"\'" +" and ");
		}
		if(types != null && !types.isEmpty()) {
			query.append("(");
			for (String type : types) {
				query.append("renttypeid = " +"\'"+ type+"\'" +" or ");
			}
			query.append(")");
		}
		else {
			query = query.delete(query.length()-5,query.length());
		}
				
		try {
			
			connection = getConnection();
			statement = connection.prepareStatement(query.toString());
			rs= statement.executeQuery();
			while(rs.next()) {
				BuildingEntity buildingEntity = new BuildingEntity();
				buildingEntity.setName(rs.getString("name"));
				buildingEntity.setStreet(rs.getString("street"));
				buildingEntity.setWard(rs.getString("ward"));
				//buildingEntity.setDistrict(rs.getString("district"));
				buildingEntity.setCreatedDate(rs.getTimestamp("createdDate"));
				buildingEntity.setManagerName(rs.getString("fullname"));
				buildingEntity.setManagerPhone(rs.getString("phone"));
				buildingEntity.setBuildingArea(rs.getString("floorarea"));
				buildingEntity.setAreaRent(rs.getInt("value"));
				buildingEntity.setCostRent(rs.getInt("rentprice"));
				buildingEntity.setServiceCost(rs.getString("servicefee"));
				buildingEntity.setCostDescription(rs.getString("rentpricedescription"));
				result.add(buildingEntity);
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
	*/
	
}
