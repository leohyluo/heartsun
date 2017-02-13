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

import com.heartsun.constant.DataBaseConstants;

@Entity
@Table(name = DataBaseConstants.QUESTION_AND_ANSWER)
public class QuestionAndAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", nullable = false)
	private Long id; //主键
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM002")
	private Disease disease; //与ebm_mid_disease的id关联
	
	@Column(name = "CM003")
	private String diseaseName; //疾病名称
	
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM004")*/
	@Column(name = "CM004")
	private Long answerId; //TM003的cm002关联
	
	@Column(name = "CM005")
	private Integer questionNum; //第几个问题
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM006")
	private MainSymptom mainSymptom; //主症状tm001的cm001关联
	
	@Column(name = "CM007")
	private String isdoctor; //医学版问题的答案。患者版问题答案1医生版 0患者版
	
	@Column(name = "CM008")
	private String order_; //排序

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Disease getDisease() {
		return disease;
	}

	public void setDisease(Disease disease) {
		this.disease = disease;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public Long getAnswerId() {
		return answerId;
	}

	public void setAnswer(Long answerId) {
		this.answerId = answerId;
	}

	public Integer getQuestionNum() {
		return questionNum;
	}

	public void setQuestionNum(Integer questionNum) {
		this.questionNum = questionNum;
	}

	public MainSymptom getMainSymptom() {
		return mainSymptom;
	}

	public void setMainSymptom(MainSymptom mainSymptom) {
		this.mainSymptom = mainSymptom;
	}

	public String getIsdoctor() {
		return isdoctor;
	}

	public void setIsdoctor(String isdoctor) {
		this.isdoctor = isdoctor;
	}

	public String getOrder_() {
		return order_;
	}

	public void setOrder_(String order_) {
		this.order_ = order_;
	}
}
