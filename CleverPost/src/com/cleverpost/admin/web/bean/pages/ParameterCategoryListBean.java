package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Parameter;
import com.mobile.cleverpost.rest.persistence.entities.ParameterCategory;

@ManagedBean(name = "parameterCategoryListBean")
@ViewScoped
public class ParameterCategoryListBean extends ListPageBean<ParameterCategory> implements Serializable {

}
