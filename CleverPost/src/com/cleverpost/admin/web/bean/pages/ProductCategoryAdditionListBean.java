package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryAddition;

@ManagedBean(name = "productCategoryAdditionListBean")
@ViewScoped
public class ProductCategoryAdditionListBean extends
		ListPageBean<ProductCategoryAddition> implements Serializable {

}
