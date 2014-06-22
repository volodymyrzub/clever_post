package com.cleverpost.admin.web.bean.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Order;

@ManagedBean(name = "orderListBean")
@ViewScoped
public class OrderListBean extends ListPageBean<Order> {

}
