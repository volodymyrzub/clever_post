package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "product_ingredients")
public class ProductIngredient extends Entity {

	@ManyToOne
	@JoinColumn
	private Product product;

	@ManyToOne
	@JoinColumn
	private Ingredient ingredient;

	@Column
	private Long count;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
}
