package com.heartsun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.heartsun.constant.DataBaseConstants;
import com.heartsun.utils.QEncodeUtil;

@Entity
@Table(name = DataBaseConstants.BASIC_ANSWER)
public class BasicAnswer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CM001", nullable = false)
	private Long id;//主键
	
	@Column(name = "CM002")
	private Long questionId;//唯一编号
	
	@Column(name = "CM003")
	@JsonIgnore
	private String quesitonContent;//问题答案内容
	
	@Column(name = "CM004")
	private Integer xb;//性别
	
	@Column(name = "CM005")
	private String sm;//通俗化
	
	@Column(name = "CM006")
	private String bz;//年龄
	
	@Column(name = "CM007")
	private String dybz;//
	
	@Column(name = "CM008")
	private String dysj;//通俗化时间 
	
	@Transient
	private String decodeAnswerContent;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuesitonContent() {
		return quesitonContent;
	}
	public void setQuesitonContent(String quesitonContent) {
		this.quesitonContent = quesitonContent;
	}
	public Integer getXb() {
		return xb;
	}
	public void setXb(Integer xb) {
		this.xb = xb;
	}
	public String getSm() {
		return sm;
	}
	public void setSm(String sm) {
		this.sm = sm;
	}
	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getDybz() {
		return dybz;
	}
	public void setDybz(String dybz) {
		this.dybz = dybz;
	}
	public String getDysj() {
		return dysj;
	}
	public void setDysj(String dysj) {
		this.dysj = dysj;
	}
	public String getDecodeAnswerContent() {
		return decodeAnswerContent;
	}
	public void setDecodeAnswerContent() {
		String decodeText =  "";
		if(!StringUtils.isEmpty(this.quesitonContent)) {
			try {
				decodeText = QEncodeUtil.decrypt(this.quesitonContent);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.decodeAnswerContent = decodeText;
	}
}
