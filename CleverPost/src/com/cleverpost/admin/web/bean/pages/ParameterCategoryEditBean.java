package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.entities.ParameterCategory;

@ManagedBean(name = "parameterCategoryEditBean")
@ViewScoped
public class ParameterCategoryEditBean extends EditPageBean<ParameterCategory> implements Serializable	{

}
