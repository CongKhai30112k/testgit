package com.khai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.google.protobuf.Timestamp;

@Entity
@Table(name = "transaction")
public class TransactionEntity extends BaseEntity {

	@Column(name = "code")
	private String code;
	@Column(name = "note")
	private String phone;
	@Column(name = "staffid")
	private String staffId;
	
	
	
	
}
