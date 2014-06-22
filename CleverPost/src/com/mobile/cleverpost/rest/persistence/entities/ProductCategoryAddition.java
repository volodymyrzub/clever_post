package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "product_category_additions")
public class ProductCategoryAddition extends Entity {

	@ManyToOne
	@JoinColumn
	private ProductCategory productCategory;

	@ManyToOne
	@JoinColumn
	private AdditionCategory additionCategory;

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public AdditionCategory getAdditionCategory() {
		return additionCategory;
	}

	public void setAdditionCategory(AdditionCategory additionCategory) {
		this.additionCategory = additionCategory;
	}

}
