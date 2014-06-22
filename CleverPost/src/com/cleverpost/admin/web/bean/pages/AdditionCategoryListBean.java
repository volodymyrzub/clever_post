package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;

/**
 * 
 * Добавки
 * 
 */
@ManagedBean(name = "additionCategoryListBean")
@ViewScoped
public class AdditionCategoryListBean extends ListPageBean<AdditionCategory> implements Serializable {

}
