package com.cleverpost.admin.web.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("BooleanConverter")
public class BooleanConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		if (value instanceof Boolean) {
			if ("true".equalsIgnoreCase(value.toString())) {
				return "Да";
			} else {
				return "Нет";
			}
		}
		return value.toString();
	}
}
