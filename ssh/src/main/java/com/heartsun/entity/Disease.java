package com.heartsun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.heartsun.constant.DataBaseConstants;

@Entity
@Table(name = DataBaseConstants.EBM_DISEASE)
public class Disease {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="CM001", nullable = false)
	private Long id; //主键
	@Column(name="CM002")
	private String name; //疾病名称
	@Column(name="CM003")
	private String icd10; //Icd10编号
	@Column(name="CM004")
	private Integer gender; //性别0男性疾病1女性疾病
	@Column(name="CM005")
	private String scopeAge; //GT大于，LE小于
	@Column(name="CM006")
	private String symbol; //拼音简码
	@Column(name="CM007")
	private String system; //所属系统
	@Column(name="CM008")
	private String grade; //疾病分级
	@Column(name="CM009")
	private String common; //是否常见病 1是
	@Column(name="CM011")
	private String cureScheme; //治疗方案
	@Column(name="CM012")
	private String definition; //疾病定义
	@Column(name="CM013")
	private String reson; //诊断要点
	@Column(name="CM014")
	private String addMeasure; //注意事项
	@Column(name="CM015")
	private String type; //
	@Column(name="CM016")
	private String dataSources; //数据来源
	@Column(name="CM017")
	private String otherName; //别名
	@Column(name="CM018")
	private String description; //疾病描述
	
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
	public String getIcd10() {
		return icd10;
	}
	public void setIcd10(String icd10) {
		this.icd10 = icd10;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getScopeAge() {
		return scopeAge;
	}
	public void setScopeAge(String scopeAge) {
		this.scopeAge = scopeAge;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSystem() {
		return system;
	}
	public void setSystem(String system) {
		this.system = system;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCommon() {
		return common;
	}
	public void setCommon(String common) {
		this.common = common;
	}
	public String getCureScheme() {
		return cureScheme;
	}
	public void setCureScheme(String cureScheme) {
		this.cureScheme = cureScheme;
	}
	public String getDefinition() {
		return definition;
	}
	public void setDefinition(String definition) {
		this.definition = definition;
	}
	public String getReson() {
		return reson;
	}
	public void setReson(String reson) {
		this.reson = reson;
	}
	public String getAddMeasure() {
		return addMeasure;
	}
	public void setAddMeasure(String addMeasure) {
		this.addMeasure = addMeasure;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDataSources() {
		return dataSources;
	}
	public void setDataSources(String dataSources) {
		this.dataSources = dataSources;
	}
	public String getOtherName() {
		return otherName;
	}
	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
