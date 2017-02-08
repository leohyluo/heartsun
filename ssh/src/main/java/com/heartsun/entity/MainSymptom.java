package com.heartsun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.heartsun.constant.DataBaseConstants;

@Entity
@Table(name = DataBaseConstants.MAIN_SYMPTOM)
public class MainSymptom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", unique = true, updatable = false, nullable = false)
	private Long id;
	@Column(name = "CM002")
	private String name;
	@Column(name = "CM003")
	private String required_num;
	@Column(name = "CM004")
	private String symbol;
	@Column(name = "CM005")
	private String sm;
	@Column(name = "CM006")
	private int idbh;
	@Column(name = "CM007")
	private int total_question;
	@Column(name = "CM008")
	private int order;
	@Column(name = "CM009", nullable = true)
	private Integer sex;
	
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
	public String getRequired_num() {
		return required_num;
	}
	public void setRequired_num(String required_num) {
		this.required_num = required_num;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSm() {
		return sm;
	}
	public void setSm(String sm) {
		this.sm = sm;
	}
	public int getIdbh() {
		return idbh;
	}
	public void setIdbh(int idbh) {
		this.idbh = idbh;
	}
	public int getTotal_question() {
		return total_question;
	}
	public void setTotal_question(int total_question) {
		this.total_question = total_question;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
}
