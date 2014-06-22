package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Ingredient;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;
import com.mobile.cleverpost.rest.persistence.entities.ProductIngredient;

@ManagedBean(name = "productIngredientEditBean")
@ViewScoped
public class ProductIngredientEditBean extends EditPageBean<ProductIngredient>
		implements Serializable {
	private static final String DEFAULT_CATEGORY_NAME = "";
	private List<SelectItem> products;
	private List<SelectItem> ingredients;
	private Long selected;

	public List<SelectItem> getProducts() {
		return products;
	}

	public void setProducts(List<SelectItem> products) {
		this.products = products;
	}

	public List<SelectItem> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<SelectItem> ingredients) {
		this.ingredients = ingredients;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	@Override
	public void onLoad() {
		// TODO Auto-generated method stub
		super.onLoad();
		loadParentsProduct();
		loadParentsIngredient();
	}

	@Override
	public void onSave() {
		saveParentsProduct();
		saveParentsIngredient();
		super.onSave();
	}

	public void loadParentsProduct() {
		try {
			if (getEntity().getProduct() != null) {
				selected = getEntity().getProduct().getId();
			}
			products = new ArrayList<SelectItem>();
			products.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (Product item : DAOManager.load(Product.class)) {
				products.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadParentsIngredient() {
		try {
			if (getEntity().getIngredient() != null) {
				selected = getEntity().getIngredient().getId();
			}
			ingredients = new ArrayList<SelectItem>();
			ingredients.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (Ingredient item : DAOManager.load(Ingredient.class)) {
				ingredients.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void saveParentsProduct() {
		if (this.getSelected() != 0) {
			try {
				Product item = DAOManager.get(Product.class, getSelected());
				this.getEntity().setProduct(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void saveParentsIngredient(){
		if (this.getSelected() != 0) {
			try {
				Ingredient item = DAOManager.get(Ingredient.class, getSelected());
				this.getEntity().setIngredient(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
