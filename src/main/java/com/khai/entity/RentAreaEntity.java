package com.khai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rentArea")
public class RentAreaEntity extends BaseEntity {

	@Column(name = "value")
	private int value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "buildingid")
	private BuildingEntity building;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}
	
	
}
