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

@Repository
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<BuildingEntity> find(Map<String, Object> parameter, String[] types) {
		StringBuilder sql = new StringBuilder("select b.name, b.street, b.ward, b.districtid, b.createdDate, b.rentprice, b.servicefee, b.rentpricedescription from building AS b");
		sql = buildJoinQuery(parameter, types, sql);
		sql.append(" where "+SystemConstant.ONE_ONE);
		sql = buildSqlPart1(parameter, types, sql);
		sql = buildSqlPart2(parameter, types, sql);
		sql.append(" group by b.id");
		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}
	private StringBuilder buildJoinQuery(Map<String, Object> parameter, String[] types, StringBuilder query) {
		//Integer staffid = parameter.containsKey("staffid") ? Integer.parseInt((String) parameter.get("staffid")) : null;
		Integer staffid = MapUtils.getObject(parameter, "staffid", Integer.class);
		if(staffid != null) {
			query.append(" inner join assignmentbuilding as ab on ab.buildingid = b.id");
		}
		Integer rentArea = MapUtils.getObject(parameter, "rentArea", Integer.class);
		if(staffid != null) {
			query.append(" inner join rentarea as ra on ra.buildingid = b.id");
		}
		return query;
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
	private StringBuilder buildSqlPart2(Map<String, Object> parameter, String[] types, StringBuilder query) {

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
			query.append(sqlType);
			query.append(")");
		}
		return query;
	}
	
}
