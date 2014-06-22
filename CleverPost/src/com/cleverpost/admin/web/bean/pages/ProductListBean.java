package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;

@ManagedBean(name = "productListBean")
@ViewScoped
public class ProductListBean extends ListPageBean<Product> implements
		Serializable {
	private List<SelectItem> categories;

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	@Override
	public void onLoad() {
		super.onLoad();
		categories = new ArrayList<SelectItem>();
		categories.add(new SelectItem("", ""));
		int i = 1;
		try {
			for (ProductCategory item : DAOManager.load(ProductCategory.class)) {
				String str = item.getName();
				categories.add(new SelectItem(str, str));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEntity() {
		Product item;
		try {
			item = DAOManager.get(getType(), getEntityDeleteId());
			IOHelper.delImg(getType().getSimpleName(), item.getPicture());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.deleteEntity();
	}
}
