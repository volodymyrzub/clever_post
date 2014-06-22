package com.cleverpost.admin.web.bean.base;

import java.util.Map;

import javax.faces.context.FacesContext;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public abstract class PageBean {
	private static boolean isUserAdmin;

	{
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (auth != null && auth.getPrincipal() != null) {
			System.out.println(auth.getPrincipal().toString());

			isUserAdmin = (auth.getPrincipal().toString().toUpperCase()
					.contains("ROLE_ADMIN"));
			System.out.println("contains ROLE_ADMIN " + isUserAdmin);
		}
	}

	public boolean getIsUserAdmin() {
		return isUserAdmin;
	}

	public boolean isPostback() {
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("role")
		return FacesContext.getCurrentInstance().isPostback();
	}

	public String getUrlParameter(String key) {
		FacesContext context = FacesContext.getCurrentInstance();

		Map<String, String> paramMap = context.getExternalContext()
				.getRequestParameterMap();
		return paramMap.get(key);
	}

	public String getRealContextPath() {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getRealPath("/");
	}
}
