package com.cleverpost.admin.web.bean.pages;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.ProductIngredient;

@ManagedBean(name = "productIngredientListBean")
@ViewScoped
public class ProductIngredientListBean extends ListPageBean<ProductIngredient> {
	private List<SelectItem> products;

	@Override
	public void onLoad() {
		super.onLoad();
		setProducts(new ArrayList<SelectItem>());
		getProducts().add(new SelectItem("", ""));
		try {
			for (Product item : DAOManager.load(Product.class)) {
				getProducts().add(
						new SelectItem(item.getName(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<SelectItem> getProducts() {
		return products;
	}

	public void setProducts(List<SelectItem> products) {
		this.products = products;
	}
}
