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
@Table(name = "products")
public class Product extends Entity implements Comparable<Product> {

	@Column
	private String picture;

	@Column
	private String name;

	@Column(name = "is_new")
	private Boolean isNew;

	@Column(name = "is_hit")
	private Boolean isHit;

	@Column(name = "is_editable")
	private Boolean isEditable;

	@Column
	private Long count;

	@Column
	private Long weight;

	@Column
	private Double price;

	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<ProductIngredient> productIngredients;

	@OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE)
	private List<PriceWeight> priceWeights;

	@ManyToOne
	@JoinColumn
	private ProductCategory productCategory;

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getIsNew() {
		return isNew;
	}

	public void setIsNew(Boolean isNew) {
		this.isNew = isNew;
	}

	public Boolean getIsHit() {
		return isHit;
	}

	public void setIsHit(Boolean isHit) {
		this.isHit = isHit;
	}

	public Boolean getIsEditable() {
		return isEditable;
	}

	public void setIsEditable(Boolean isEditable) {
		this.isEditable = isEditable;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public List<ProductIngredient> getProductIngredients() {
		return productIngredients;
	}

	public void setProductIngredients(List<ProductIngredient> productIngredients) {
		this.productIngredients = productIngredients;
	}

	public List<PriceWeight> getPriceWeights() {
		return priceWeights;
	}

	public void setPriceWeights(List<PriceWeight> priceWeights) {
		this.priceWeights = priceWeights;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Long getWeight() {
		return weight;
	}

	public void setWeight(Long weight) {
		this.weight = weight;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Product o) {
		return name.compareTo(o.getName());
	}
}
