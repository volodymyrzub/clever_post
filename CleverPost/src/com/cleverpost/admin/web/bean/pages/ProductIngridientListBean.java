package com.cleverpost.admin.web.bean.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.ProductIngredient;

@ManagedBean(name = "productIngridientListBean")
@ViewScoped
public class ProductIngridientListBean extends ListPageBean<ProductIngredient> {

}
