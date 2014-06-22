package com.mobile.cleverpost.rest.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
@javax.persistence.Entity
@Table(name = "discounts")
public class Discount extends Entity {

	@Column
	private String name;

	@Column
	private String about;

	@Column
	private String picture;
	
	@Column
	private Date startAction;
	
	@Column
	private Date endAction;
	
	@Column
	private Date timeOffAction;
	
	@Column
	private Date timeOnAction;
	
	@Column
	private String daysWeek;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Date getStartAction() {
		return startAction;
	}

	public void setStartAction(Date startAction) {
		this.startAction = startAction;
	}

	public Date getEndAction() {
		return endAction;
	}

	public void setEndAction(Date endAction) {
		this.endAction = endAction;
	}

	public Date getTimeOffAction() {
		return timeOffAction;
	}

	public void setTimeOffAction(Date timeOffAction) {
		this.timeOffAction = timeOffAction;
	}

	public Date getTimeOnAction() {
		return timeOnAction;
	}

	public void setTimeOnAction(Date timeOnAction) {
		this.timeOnAction = timeOnAction;
	}

	public String getDaysWeek() {
		return daysWeek;
	}

	public void setDaysWeek(String daysWeek) {
		this.daysWeek = daysWeek;
	}
	
	
}
