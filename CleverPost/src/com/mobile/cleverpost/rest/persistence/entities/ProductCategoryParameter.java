package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "product_category_parameters")
public class ProductCategoryParameter extends Entity {

	@ManyToOne
	@JoinColumn
	private ProductCategory productCategory;

	@ManyToOne
	@JoinColumn
	private ParameterCategory parameterCategory;

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public ParameterCategory getParameterCategory() {
		return parameterCategory;
	}

	public void setParameterCategory(ParameterCategory parameterCategory) {
		this.parameterCategory = parameterCategory;
	}

}
