package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "parameter_categories")
public class ParameterCategory extends Entity implements Comparable<ParameterCategory> {

	@Column
	private String name;

	@OneToMany(mappedBy = "parameterCategory", cascade = CascadeType.REMOVE)
	private List<Parameter> parameters;

	@OneToMany(mappedBy = "parameterCategory", cascade = CascadeType.REMOVE)
	private List<ProductCategoryParameter> productCategoryParameters;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Parameter> getParameters() {
		return parameters;
	}

	public void setParameters(List<Parameter> parameters) {
		this.parameters = parameters;
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
	public int compareTo(ParameterCategory o) {
		return this.name.compareTo(o.getName());
	}

}
