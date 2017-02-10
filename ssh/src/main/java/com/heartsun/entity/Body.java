package com.heartsun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.heartsun.constant.DataBaseConstants;

@Entity
@Table(name = DataBaseConstants.BODY)
public class Body {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", nullable = false)
	private Long id;
	@Column(name = "CM002")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
