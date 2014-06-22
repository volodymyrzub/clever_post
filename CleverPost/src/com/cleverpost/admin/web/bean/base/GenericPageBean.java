package com.cleverpost.admin.web.bean.base;

import java.lang.reflect.ParameterizedType;

import com.mobile.cleverpost.rest.persistence.entities.Entity;

public abstract class GenericPageBean<T extends Entity> extends PageBean {
	private Class<T> type;

	@SuppressWarnings("unchecked")
	public Class<T> getType() {
		if (type == null) {
			ParameterizedType superclass = (ParameterizedType) getClass()
					.getGenericSuperclass();
			type = (Class<T>) ((ParameterizedType) superclass)
					.getActualTypeArguments()[0];
		}
		return type;
	}

	public void setType(Class<T> type) {
		this.type = type;
	}

	public GenericPageBean() {
		if (isPostback()) {
			System.out.println("!!!!!!!!! postback!!!" + getType());
		} else {
			System.out.println("!!!!!!!!! not postback!!!" + getType());
		}
		onLoad();
	}

	public abstract void onLoad();
}
