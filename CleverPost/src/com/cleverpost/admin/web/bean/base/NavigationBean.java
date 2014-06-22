package com.cleverpost.admin.web.bean.base;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "navigationBean")
@SessionScoped
public class NavigationBean implements Serializable {
	private String pageToNavigate = "";

	public String navigateTo() {
		if ("ToSecure".equalsIgnoreCase(pageToNavigate)) {
			return "Secured";
		} else if ("ToUnSecure".equalsIgnoreCase(pageToNavigate)) {
			return "UnSecured";
		} else {
			// This will never happen but we will use this to extend this
			// application
			return "none";
		}
	}

	public String getPageToNavigate() {
		return pageToNavigate;
	}

	public void setPageToNavigate(String option) {
		this.pageToNavigate = option;
	}

	public String navigateToCategories() {
		return "../../secure/CategoryList.xhtml?faces-redirect=true";
	}
}
