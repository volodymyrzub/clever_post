package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Addition;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;

@ManagedBean(name = "additionListBean")
@ViewScoped
public class AdditionListBean extends ListPageBean<Addition> implements
		Serializable {
	private List<SelectItem> categories;

	@Override
	public void onLoad() {
		super.onLoad();
		setCategories(new ArrayList<SelectItem>());
		getCategories().add(new SelectItem("", ""));

		try {
			for (AdditionCategory item : DAOManager
					.load(AdditionCategory.class)) {
				getCategories().add(
						new SelectItem(item.getName(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

}
