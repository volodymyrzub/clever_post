package com.cleverpost.admin.web.bean.pages;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.AdditionCategory;
import com.mobile.cleverpost.rest.persistence.entities.ParameterCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategoryParameter;

@ManagedBean(name = "productCategoryParameterEditBean")
@ViewScoped
public class ProductCategoryParameterEditBean extends EditPageBean<ProductCategoryParameter>{
	
	private static final String DEFAULT_CATEGORY_NAME = "";
	private List<SelectItem> categories;
	private List<SelectItem> parameters;
	private Long catSelected;
	private Long parSelected;
	public List<SelectItem> getCategories() {
		return categories;
	}
	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}
	public List<SelectItem> getParameters() {
		return parameters;
	}
	public void setParameters(List<SelectItem> parameters) {
		this.parameters = parameters;
	}
	public Long getCatSelected() {
		return catSelected;
	}
	public void setCatSelected(Long catSelected) {
		this.catSelected = catSelected;
	}
	public Long getParSelected() {
		return parSelected;
	}
	public void setParSelected(Long parSelected) {
		this.parSelected = parSelected;
	}
	
	@Override
	public void onSave() {
		onSaveParameterCategory();
		onSaveProductCategory();
		super.onSave();

	}

	@Override
	public void onLoad() {
		super.onLoad();
		loadParameterCategory();
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

	public void loadParameterCategory() {
		try {
			if (getEntity().getParameterCategory() != null) {
				parSelected = getEntity().getParameterCategory().getId();
			}
			parameters = new ArrayList<SelectItem>();
			parameters.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (ParameterCategory item : DAOManager
					.load(ParameterCategory.class)) {
				parameters.add(new SelectItem(item.getId(), item.getName()));
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

	public void parameterSelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setParSelected(Long.valueOf(str));
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

	public void onSaveParameterCategory() {
		if (this.getParSelected() != 0) {
			try {
				ParameterCategory item = DAOManager.get(ParameterCategory.class,
						getParSelected());
				this.getEntity().setParameterCategory(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
