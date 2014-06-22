package com.mobile.cleverpost.rest.persistence.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "parameter_groups")
public class ParameterGroup extends Entity {

	@ManyToOne
	@JoinColumn
	private PriceWeight priceWeight;

	@ManyToOne
	@JoinColumn
	private Parameter parameter;

	public PriceWeight getPriceWeight() {
		return priceWeight;
	}

	public void setPriceWeight(PriceWeight priceWeight) {
		this.priceWeight = priceWeight;
	}

	public Parameter getParameter() {
		return parameter;
	}

	public void setParameter(Parameter parameter) {
		this.parameter = parameter;
	}

}
