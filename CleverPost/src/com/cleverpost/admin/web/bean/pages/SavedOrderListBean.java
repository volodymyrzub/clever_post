package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Order;

@ManagedBean(name = "savedOrderListBean")
@ViewScoped
public class SavedOrderListBean extends ListPageBean<Order> implements
		Serializable {

}
