package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "product_categories")
public class ProductCategory extends Entity implements
		Comparable<ProductCategory> {

	@Column
	private String name;
	
	@Column
	private String picture;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private ProductCategory parent;

	@OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
	private List<ProductCategory> children;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
	private List<Product> products;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
	private List<ProductCategoryAddition> productCategoryAdditions;

	@OneToMany(mappedBy = "productCategory", cascade = CascadeType.REMOVE)
	private List<ProductCategoryParameter> productCategoryParameters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public ProductCategory getParent() {
		return parent;
	}

	public void setParent(ProductCategory parent) {
		this.parent = parent;
	}

	public List<ProductCategory> getChildren() {
		return children;
	}

	public void setChildren(List<ProductCategory> children) {
		this.children = children;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<ProductCategoryAddition> getProductCategoryAdditions() {
		return productCategoryAdditions;
	}

	public void setProductCategoryAdditions(
			List<ProductCategoryAddition> productCategoryAdditions) {
		this.productCategoryAdditions = productCategoryAdditions;
	}

	public List<ProductCategoryParameter> getProductCategoryParameters() {
		return productCategoryParameters;
	}

	public void setProductCategoryParameters(
			List<ProductCategoryParameter> productCategoryParameters) {
		this.productCategoryParameters = productCategoryParameters;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(ProductCategory o) {
		return name.compareTo(o.getName());
	}
}
