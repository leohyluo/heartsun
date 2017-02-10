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
@Table(name = DataBaseConstants.BODY_MAIN_SYMPTOM)
public class BodyMainSymptom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", nullable = false)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM002")
	private MainSymptom mainSymptom;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CM003")
	private Body body;
	
	@Column(name = "CM004")
	private Integer order_;

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

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public Integer getOrder_() {
		return order_;
	}

	public void setOrder_(Integer order_) {
		this.order_ = order_;
	}
}
