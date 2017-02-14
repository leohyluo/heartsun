package com.heartsun.entity.resultset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnswerPojo implements Comparable<AnswerPojo> {
	
	private Integer diseaseNum;		//疾病数量
	private String answerIds;		//问题答案关系表id组合以,分隔
	private String diseaseIds;		//疾病id组合以,分隔
	private String answerText;		//答案内容
	private Integer normalDiseaseCount;	//常见病个数
	
	public Integer getDiseaseNum() {
		return diseaseNum;
	}
	public void setDiseaseNum(Integer diseaseNum) {
		this.diseaseNum = diseaseNum;
	}
	public String getAnswerIds() {
		return answerIds;
	}
	public void setAnswerIds(String answerIds) {
		this.answerIds = answerIds;
	}
	public String getDiseaseIds() {
		return diseaseIds;
	}
	public void setDiseaseIds(String diseaseIds) {
		this.diseaseIds = diseaseIds;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public Integer getNormalDiseaseCount() {
		return normalDiseaseCount;
	}
	public void setNormalDiseaseCount(Integer normalDiseaseCount) {
		this.normalDiseaseCount = normalDiseaseCount;
	}
	
	@Override
	public int compareTo(AnswerPojo o) {
		if(this.getDiseaseNum() != o.getDiseaseNum()) {
			return o.getDiseaseNum().compareTo(this.getDiseaseNum());
		} else {
			return o.getNormalDiseaseCount().compareTo(this.getNormalDiseaseCount());
		}
	}
	
	public static void main(String[] args) {
		List<AnswerPojo> list = new ArrayList<>();
		AnswerPojo pojo1 = new AnswerPojo();
		pojo1.setDiseaseNum(5);
		pojo1.setNormalDiseaseCount(3);
		
		AnswerPojo pojo2 = new AnswerPojo();
		pojo2.setDiseaseNum(5);
		pojo2.setNormalDiseaseCount(4);
		
		AnswerPojo pojo3 = new AnswerPojo();
		pojo3.setDiseaseNum(6);
		pojo3.setNormalDiseaseCount(3);
		
		AnswerPojo pojo4 = new AnswerPojo();
		pojo4.setDiseaseNum(5);
		pojo4.setNormalDiseaseCount(5);
		
		list.add(pojo2);
		list.add(pojo1);
		list.add(pojo4);
		list.add(pojo3);
		
		Collections.sort(list);
		for(AnswerPojo item : list) {
			System.out.println(item.getDiseaseNum() + ":" + item.getNormalDiseaseCount());
		}
	}
}
