package com.cleverpost.admin.web.bean.pages;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.dao.security.entities.User;

@ManagedBean(name = "userEditBean")
@ViewScoped
public class UserEditBean extends EditPageBean<User> {
	private List<SelectItem> categories;
	private String selected;

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		this.selected = selected;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		if (getEntity().getUserRole() != null) {
			setSelected(getEntity().getUserRole().getRoleName());
		}
	}

	@Override
	public void onSave() {
		try {
			DAOManager.save(getEntity().getUserRole());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onSave();
	}

	public void userRoleSelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setSelected(str);
		this.getEntity().getUserRole().setRoleName(str);
	}
}
