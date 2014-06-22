package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Addition;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;

@ManagedBean(name = "additionEditBean")
@ViewScoped
public class AdditionEditBean extends EditPageBean<Addition> implements
		Serializable {
	private static final String DEFAULT_CATEGORY_ADDITION = "";
	private List<SelectItem> restaurants;
	private Long selected;

	public List<SelectItem> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<SelectItem> restaurants) {
		this.restaurants = restaurants;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		loadParents();
	}

	@Override
	public void onSave() {
		if (this.getSelected() != 0) {
			try {
				AdditionCategory item = DAOManager.get(AdditionCategory.class,
						getSelected());
				this.getEntity().setAdditionCategory(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.onSave();
	}

	public void loadParents() {
		try {
			if (getEntity().getAdditionCategory() != null) {
				selected = getEntity().getAdditionCategory().getId();
			}
			restaurants = new ArrayList<SelectItem>();
			restaurants.add(new SelectItem(0, DEFAULT_CATEGORY_ADDITION));
			for (AdditionCategory item : DAOManager
					.load(AdditionCategory.class)) {
				restaurants.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void categorySelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setSelected(Long.valueOf(str));
	}
}
