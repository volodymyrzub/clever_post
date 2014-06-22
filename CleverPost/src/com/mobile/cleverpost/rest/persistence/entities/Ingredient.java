package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "ingredients")
public class Ingredient extends Entity implements Comparable<Ingredient> {

	@Column
	private String name;

	// @Column
	// private Double weight;

	// @Column
	// private Long count;

	@OneToMany(mappedBy = "ingredient", cascade = CascadeType.REMOVE)
	private List<ProductIngredient> productIngredients;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// public Double getWeight() {
	// return weight;
	// }
	//
	// public void setWeight(Double weight) {
	// this.weight = weight;
	// }

	// public Long getCount() {
	// return count;
	// }
	//
	// public void setCount(Long count) {
	// this.count = count;
	// }

	public List<ProductIngredient> getProductIngredients() {
		return productIngredients;
	}

	public void setProductIngredients(List<ProductIngredient> productIngredients) {
		this.productIngredients = productIngredients;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Ingredient o) {
		return this.name.compareTo(o.getName());
	}

}
