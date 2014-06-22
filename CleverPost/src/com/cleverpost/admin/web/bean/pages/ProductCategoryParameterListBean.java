package com.cleverpost.admin.web.bean.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryParameter;

@ManagedBean(name = "productCategoryParameterListBean")
@ViewScoped
public class ProductCategoryParameterListBean extends
		ListPageBean<ProductCategoryParameter> {

}
