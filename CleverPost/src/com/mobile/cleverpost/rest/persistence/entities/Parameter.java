package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "parameters")
public class Parameter extends Entity {

	@Column
	private String picture;

	@Column
	private String name;

	@Column
	private String impactWeight;

	@Column
	private String impactPrice;

	// @Column
	// private Double value;

	// @Column
	// private String measurement;

	@ManyToOne
	@JoinColumn(name = "parameter_category_id")
	private ParameterCategory parameterCategory;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImpactWeight() {
		return impactWeight;
	}

	public void setImpactWeight(String impactWeight) {
		this.impactWeight = impactWeight;
	}

	public String getImpactPrice() {
		return impactPrice;
	}

	public void setImpactPrice(String impactPrice) {
		this.impactPrice = impactPrice;
	}

	public ParameterCategory getParameterCategory() {
		return parameterCategory;
	}

	public void setParameterCategory(ParameterCategory parameterCategory) {
		this.parameterCategory = parameterCategory;
	}

	public List<ParameterGroup> getParameterGroups() {
		return parameterGroups;
	}

	public void setParameterGroups(List<ParameterGroup> parameterGroups) {
		this.parameterGroups = parameterGroups;
	}

	@OneToMany(mappedBy = "parameter", cascade = CascadeType.REMOVE)
	private List<ParameterGroup> parameterGroups;
}
