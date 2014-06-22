package com.cleverpost.admin.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("UserRoleConverter")
public class UserRoleConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if ("ROLE_USER".equals(value.toString())) {
			return "пользователь";
		} else if ("ROLE_ADMIN".equals(value.toString())) {
			return "администратор";
		}
		return null;
	}
}
