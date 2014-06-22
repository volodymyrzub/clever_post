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
@Table(name = "price_weights")
public class PriceWeight extends Entity {

	@ManyToOne
	@JoinColumn
	private Product product;

	@OneToMany(mappedBy = "priceWeight", cascade = CascadeType.REMOVE)
	private List<ParameterGroup> parameterGroups;

	@Column
	private Double weight;

	@Column
	private double price;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ParameterGroup> getParameterGroups() {
		return parameterGroups;
	}

	public void setParameterGroups(List<ParameterGroup> parameterGroups) {
		this.parameterGroups = parameterGroups;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
