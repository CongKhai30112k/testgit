package com.khai.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.protobuf.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	private String fullname;
	private String phone;
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
