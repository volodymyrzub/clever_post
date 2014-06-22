package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "order_products")
public class OrderProduct extends Entity {

	@OneToOne
	@JoinColumn(name = "product_id")
	private PriceWeight priceWeight;

	@Column
	private Long count;

	@Column
	private String ingredient;

	@Column
	private String additions;
	
	@ManyToOne
	@JoinColumn
	private Order order;

	public PriceWeight getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(PriceWeight priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public String getIngredient() {
		return ingredient;
	}

	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}

	public String getAdditions() {
		return additions;
	}

	public void setAdditions(String additions) {
		this.additions = additions;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
