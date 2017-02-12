package com.heartsun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heartsun.constant.DataBaseConstants;

@Entity
@Table(name = DataBaseConstants.MAIN_QUESTION)
public class MainQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", nullable = false)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM002")
	@JsonIgnore
	private MainSymptom mainSymptom;
	@Column(name = "CM003")
	private String question;
	@Column(name = "CM004")
	private String questionType;
	@Column(name = "CM005")
	private String isrequest;
	@Column(name = "CM006")
	private String isdoctor;
	@Column(name = "CM007")
	private Integer gender;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MainSymptom getMainSymptom() {
		return mainSymptom;
	}
	public void setMainSymptom(MainSymptom mainSymptom) {
		this.mainSymptom = mainSymptom;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getIsrequest() {
		return isrequest;
	}
	public void setIsrequest(String isrequest) {
		this.isrequest = isrequest;
	}
	public String getIsdoctor() {
		return isdoctor;
	}
	public void setIsdoctor(String isdoctor) {
		this.isdoctor = isdoctor;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
}
