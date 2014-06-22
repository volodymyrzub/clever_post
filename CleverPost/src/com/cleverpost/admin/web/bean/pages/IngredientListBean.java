package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.common.enums.PagesTypes;
import com.cleverpost.admin.common.helpers.RedirectHelper;
import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Ingredient;

@ManagedBean(name = "ingredientListBean")
@ViewScoped
public class IngredientListBean extends ListPageBean<Ingredient> implements
		Serializable {
	public void addEntity() {
		RedirectHelper.redirect(PagesTypes.INGREDIENT_EDIT);
	}

	public void editEntity() {
		RedirectHelper.redirect(PagesTypes.INGREDIENT_EDIT, getEntityEditId());
	}
}
