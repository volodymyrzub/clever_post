package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;

@ManagedBean(name = "categoryListBean")
@ViewScoped
public class ProductCategoryListBean extends ListPageBean<ProductCategory>
		implements Serializable {

	@Override
	public void deleteEntity() {
		ProductCategory item;
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
