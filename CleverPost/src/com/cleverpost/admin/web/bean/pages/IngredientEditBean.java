package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.data.PageEvent;

import com.cleverpost.admin.common.enums.PagesTypes;
import com.cleverpost.admin.common.helpers.RedirectHelper;
import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Ingredient;

@ManagedBean(name = "ingredientEditBean")
@ViewScoped
public class IngredientEditBean extends EditPageBean<Ingredient> implements
		Serializable {
	public void onSave() {
		try {
			DAOManager.save(this.getEntity());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RedirectHelper.redirect(PagesTypes.INGREDIENT_LIST);
	}
}
