package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;
import com.mobile.cleverpost.rest.persistence.entities.Restaurant;

@ManagedBean(name = "restaurantListBean")
@ViewScoped
public class RestaurantListBean extends ListPageBean<Restaurant> implements Serializable {
	
	@Override
	public void deleteEntity() {
		Restaurant item;
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
