package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "addition_categories")
public class AdditionCategory extends Entity implements
		Comparable<AdditionCategory> {

	@Column
	private String name;

	@OneToMany(mappedBy = "additionCategory", cascade = CascadeType.REMOVE)
	private List<Addition> additions;

	@OneToMany(mappedBy = "additionCategory", cascade = CascadeType.REMOVE)
	private List<ProductCategoryAddition> productCategoryAdditions;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Addition> getAdditions() {
		return additions;
	}

	public void setAdditions(List<Addition> additions) {
		this.additions = additions;
	}

	public List<ProductCategoryAddition> getProductCategoryAdditions() {
		return productCategoryAdditions;
	}

	public void setProductCategoryAdditions(
			List<ProductCategoryAddition> productCategoryAdditions) {
		this.productCategoryAdditions = productCategoryAdditions;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(AdditionCategory o) {
		return name.compareTo(o.getName());
	}
}
