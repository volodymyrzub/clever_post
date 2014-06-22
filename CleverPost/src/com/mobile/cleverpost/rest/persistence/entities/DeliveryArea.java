package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "delivery_areas")
public class DeliveryArea extends Entity {

	@Column
	private String name;

	@Column(name = "min_order")
	private Double minOrder;

	@Column
	private String cost;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMinOrder() {
		return minOrder;
	}

	public void setMinOrder(Double minCostForFreeDelivery) {
		this.minOrder = minCostForFreeDelivery;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}
	
}
