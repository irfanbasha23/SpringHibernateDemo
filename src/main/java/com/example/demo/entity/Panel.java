package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Panel {

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private Long panelId;
	
	@Column(name="Panel")
	private String name;
	
	@Column(name="Tech Strems") 
	private String techStreams;
	
	@Column(name = "Detail Tech Stack")
	private String detailTechStack;
	
	@Column(name="1st Level")
	private String firstLevel;
	
	@Column(name="2nd Level")
	private String secondLevel;
	
	@Column(name="Managerial")
	private String managerial;

	/**
	 * @return the panelId
	 */
	public Long getPanelId() {
		return panelId;
	}

	/**
	 * @param panelId the panelId to set
	 */
	public void setPanelId(Long panelId) {
		this.panelId = panelId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the techStreams
	 */
	public String getTechStreams() {
		return techStreams;
	}

	/**
	 * @param techStreams the techStreams to set
	 */
	public void setTechStreams(String techStreams) {
		this.techStreams = techStreams;
	}

	/**
	 * @return the detailTechStack
	 */
	public String getDetailTechStack() {
		return detailTechStack;
	}

	/**
	 * @param detailTechStack the detailTechStack to set
	 */
	public void setDetailTechStack(String detailTechStack) {
		this.detailTechStack = detailTechStack;
	}

	/**
	 * @return the firstLevel
	 */
	public String getFirstLevel() {
		return firstLevel;
	}

	/**
	 * @param firstLevel the firstLevel to set
	 */
	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}

	/**
	 * @return the secondLevel
	 */
	public String getSecondLevel() {
		return secondLevel;
	}

	/**
	 * @param secondLevel the secondLevel to set
	 */
	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}

	/**
	 * @return the managerial
	 */
	public String getManagerial() {
		return managerial;
	}

	/**
	 * @param managerial the managerial to set
	 */
	public void setManagerial(String managerial) {
		this.managerial = managerial;
	}
	
	
	
}
