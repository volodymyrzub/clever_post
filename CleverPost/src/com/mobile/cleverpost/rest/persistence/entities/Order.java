package com.mobile.cleverpost.rest.persistence.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.cleverpost.admin.common.enums.OrderStatuses;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "orders")
public class Order extends Entity {

	@Enumerated(EnumType.STRING)
	private OrderStatuses orderStatuses;

	@OneToMany(mappedBy = "order", cascade = CascadeType.REMOVE)
	private List<OrderProduct> orderProducts;

	public OrderStatuses getOrderStatuses() {
		return orderStatuses;
	}

	public void setOrderStatuses(OrderStatuses orderStatuses) {
		this.orderStatuses = orderStatuses;
	}

	public List<OrderProduct> getOrderProducts() {
		return orderProducts;
	}

	public void setOrderProducts(List<OrderProduct> orderProducts) {
		this.orderProducts = orderProducts;
	}
}
