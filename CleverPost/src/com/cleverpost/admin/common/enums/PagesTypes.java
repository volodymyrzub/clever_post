package com.cleverpost.admin.common.enums;

public enum PagesTypes {
	LOGIN("pages/common/login.xhtml"), PRODUCT_CATEGORY_EDIT(
			"pages/secure/admin/ProductCategoryEdit.jsf"), PRODUCT_CATEGORY_LIST(
			"pages/secure/admin/ProductCategoryList.jsf"), DELIVERY_AREA_EDIT(
			"pages/secure/admin/DeliveryAreaEdit.jsf"), DELIVERY_AREA_LIST(
			"pages/secure/admin/DeliveryAreaList.jsf"), DISCOUNT_EDIT(
			"pages/secure/admin/DiscountEdit.jsf"), DISCOUNT_LIST(
			"pages/secure/admin/DiscountList.jsf"), PRODUCT_EDIT(
			"pages/secure/admin/ProductEdit.jsf"), PRODUCT_LIST(
			"pages/secure/admin/ProductList.jsf"), RESTAURANT_LIST(
			"pages/secure/admin/RestaurantList.jsf"), RESTAURANT_EDIT(
			"pages/secure/admin/RestaurantEdit.jsf"), ADDITION_CATEGORY_LIST(
			"pages/secure/admin/AdditionCategoryList.jsf"), ADDITION_CATEGORY_EDIT(
			"pages/secure/admin/AdditionCategoryEdit.jsf"), ADDITION_LIST(
			"pages/secure/admin/AdditionList.jsf"), ADDITION_EDIT(
			"pages/secure/admin/AdditionEdit.jsf"), USER_LIST(
			"pages/secure/admin/UserList.jsf"), USER_EDIT(
			"pages/secure/admin/UserEdit.jsf"), INGREDIENT_EDIT(
			"pages/secure/admin/IngredientEdit.jsf"), INGREDIENT_LIST(
			"pages/secure/admin/IngredientList.jsf"), PRODUCT_INGREDIENT_LIST(
			"pages/secure/admin/ProductIngredientList.jsf"), PRODUCT_INGREDIENT_EDIT(
			"pages/secure/admin/ProductIngredientEdit.jsf"), PARAMETER_CATEGORY_LIST(
			"pages/secure/admin/ParameterCategoryList.jsf"), PARAMETER_CATEGORY_EDIT(
			"pages/secure/admin/ParameterCategoryEdit.jsf"), PARAMETER_LIST(
			"pages/secure/admin/ParameterList.jsf"), PARAMETER_EDIT(
			"pages/secure/admin/ParameterEdit.jsf"), PRODUCT_CATEGORY_PARAMETER_LIST(
			"pages/secure/admin/ProductCategoryParameterList.jsf"), PRODUCT_CATEGORY_PARAMETER_EDIT(
			"pages/secure/admin/ProductCategoryParameterEdit.jsf"), PRODUCT_CATEGORY_ADDITION_LIST(
			"pages/secure/admin/ProductCategoryAdditionList.jsf"), PRODUCT_CATEGORY_ADDITION_EDIT(
			"pages/secure/admin/ProductCategoryAdditionEdit.jsf"), POST_EDIT(
			"pages/secure/admin/PostEdit.jsf"), POST_LIST(
			"pages/secure/admin/PostList.jsf");
	;

	private String page;

	private PagesTypes(String page) {
		this.page = page;
	}

	public String getPath() {
		return this.page;
	}

	public static PagesTypes getEditPage(String clazz) {
		return getPageType(clazz, "Edit");
	}

	public static PagesTypes getListPage(String clazz) {
		return getPageType(clazz, "List");
	}

	private static PagesTypes getPageType(String clazz, String page) {
		StringBuilder str = new StringBuilder(clazz).append(page);
		for (PagesTypes type : PagesTypes.values()) {
			if (type.getPath().contains(str.toString())) {
				return type;
			}
		}
		return null;
	}
}
