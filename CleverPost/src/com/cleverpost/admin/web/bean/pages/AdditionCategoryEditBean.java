package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;

@ManagedBean(name = "additionCategoryEditBean")
@ViewScoped
public class AdditionCategoryEditBean extends EditPageBean<AdditionCategory> implements
		Serializable {
	
}
