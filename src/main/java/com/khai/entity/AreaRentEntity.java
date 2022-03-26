package com.khai.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rentArea")
public class AreaRentEntity extends BaseEntity {

	private int areaRent;

	public int getAreaRent() {
		return areaRent;
	}

	public void setAreaRent(int areaRent) {
		this.areaRent = areaRent;
	}

	

	
	
}
