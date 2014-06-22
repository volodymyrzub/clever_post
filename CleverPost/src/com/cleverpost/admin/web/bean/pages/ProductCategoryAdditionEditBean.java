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
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryAddition;

@ManagedBean(name = "productCategoryAdditionEditBean")
@ViewScoped
public class ProductCategoryAdditionEditBean extends
		EditPageBean<ProductCategoryAddition> implements Serializable {

	private static final String DEFAULT_CATEGORY_NAME = "";
	private List<SelectItem> categories;
	private List<SelectItem> additions;
	private Long catSelected;
	private Long addSelected;

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	public List<SelectItem> getAdditions() {
		return additions;
	}

	public void setAdditions(List<SelectItem> additions) {
		this.additions = additions;
	}

	public Long getAddSelected() {
		return addSelected;
	}

	public void setAddSelected(Long addSelected) {
		this.addSelected = addSelected;
	}

	public Long getCatSelected() {
		return catSelected;
	}

	public void setCatSelected(Long catSelected) {
		this.catSelected = catSelected;
	}

	@Override
	public void onSave() {
		onSaveAdditionCategory();
		onSaveProductCategory();
		super.onSave();

	}

	@Override
	public void onLoad() {
		super.onLoad();
		loadAdditionCategory();
		loadProductCategory();
	}

	public void loadProductCategory() {
		try {
			if (getEntity().getProductCategory() != null) {
				catSelected = getEntity().getProductCategory().getId();
			}
			categories = new ArrayList<SelectItem>();
			categories.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (ProductCategory item : DAOManager.load(ProductCategory.class)) {
				categories.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadAdditionCategory() {
		try {
			if (getEntity().getAdditionCategory() != null) {
				addSelected = getEntity().getAdditionCategory().getId();
			}
			additions = new ArrayList<SelectItem>();
			additions.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (AdditionCategory item : DAOManager
					.load(AdditionCategory.class)) {
				additions.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void categorySelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setCatSelected(Long.valueOf(str));
	}

	public void additionSelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setAddSelected(Long.valueOf(str));
	}

	public void onSaveProductCategory() {
		if (this.getCatSelected() != 0) {
			try {
				ProductCategory item1 = DAOManager.get(ProductCategory.class,
						getCatSelected());
				this.getEntity().setProductCategory(item1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onSaveAdditionCategory() {
		if (this.getAddSelected() != 0) {
			try {
				AdditionCategory item = DAOManager.get(AdditionCategory.class,
						getAddSelected());
				this.getEntity().setAdditionCategory(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
