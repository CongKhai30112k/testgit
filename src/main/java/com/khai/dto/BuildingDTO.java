package com.khai.dto;

public class BuildingDTO extends AbstractDTO<BuildingDTO> {
	
	private String name;
	private String numberOfBasement;
	private String floorArea;
	private String street;
	private String ward;
	private String district;
	private String structure;
	private Integer rentPrice;
	private String rentPriceDescription;
	private String[] buildingTypes = new String[] {};
	private String costRentFrom;
	private String costRentTo;
	private String areaRentFrom;
	private String areaRentTo;
	private String staffId;
	private int areaRent;
	private String address;
	private String type;
	private String direction;
	private String level;
	private String rentAreaDescription;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String[] getBuildingTypes() {
		return buildingTypes;
	}
	public void setBuildingTypes(String[] buildingTypes) {
		this.buildingTypes = buildingTypes;
	}
	public String getCostRentFrom() {
		return costRentFrom;
	}
	public void setCostRentFrom(String costRentFrom) {
		this.costRentFrom = costRentFrom;
	}
	public String getCostRentTo() {
		return costRentTo;
	}
	public void setCostRentTo(String costRentTo) {
		this.costRentTo = costRentTo;
	}
	public String getAreaRentFrom() {
		return areaRentFrom;
	}
	public void setAreaRentFrom(String areaRentFrom) {
		this.areaRentFrom = areaRentFrom;
	}
	public String getAreaRentTo() {
		return areaRentTo;
	}
	public void setAreaRentTo(String areaRentTo) {
		this.areaRentTo = areaRentTo;
	}
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public int getAreaRent() {
		return areaRent;
	}
	public void setAreaRent(int areaRent) {
		this.areaRent = areaRent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getRentAreaDescription() {
		return rentAreaDescription;
	}
	public void setRentAreaDescription(String rentAreaDescription) {
		this.rentAreaDescription = rentAreaDescription;
	}
	

}
