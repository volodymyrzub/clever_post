package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "additions")
public class Addition extends Entity  {

	@Column
	private String name;

	@Column
	private Double weight;

	@Column
	private Double price;

	@ManyToOne
	// (fetch = FetchType.LAZY)
	@JoinColumn(name = "addition_id")
	private AdditionCategory additionCategory;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public AdditionCategory getAdditionCategory() {
		return additionCategory;
	}

	public void setAdditionCategory(AdditionCategory additionCategory) {
		this.additionCategory = additionCategory;
	}

}
