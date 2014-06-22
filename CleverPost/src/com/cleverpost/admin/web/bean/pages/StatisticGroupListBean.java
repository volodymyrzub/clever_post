package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.StatisticGroup;

@ManagedBean(name = "statisticGroupListBean")
@ViewScoped
public class StatisticGroupListBean extends ListPageBean<StatisticGroup>
		implements Serializable {

	private static final long serialVersionUID = 1L;

}
