package com.khai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "street")
	private String street;
	@Column(name = "ward")
	private String ward;
	@Column(name = "district")
	private String district;
	@Column(name = "structure")
	private String structure;
	@Column(name = "numberofbasement")
	private String numberOfBasement;
	@Column(name = "floorarea")
	private String floorArea;
	@Column(name = "direction")
	private String direction;
	@Column(name = "level")
	private String level;
	@Column(name = "rentprice")
	private Integer rentPrice;
	@Column(name = "rentpricedescription")
	private String rentPriceDescription;
	@Column(name = "type")
	private String buildingTypes;
	
	@OneToMany(mappedBy = "building")
	private List<RentAreaEntity> renAreas = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public String getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(String numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(String floorArea) {
		this.floorArea = floorArea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Integer getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
	}
	public String getRentPriceDescription() {
		return rentPriceDescription;
	}
	public void setRentPriceDescription(String rentPriceDescription) {
		this.rentPriceDescription = rentPriceDescription;
	}
	public String getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(String buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
	public List<RentAreaEntity> getRenAreas() {
		return renAreas;
	}
	public void setRenAreas(List<RentAreaEntity> renAreas) {
		this.renAreas = renAreas;
	}
	
	
}
