package com.cleverpost.admin.common.helpers;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.cleverpost.admin.common.enums.PagesTypes;

public class RedirectHelper {
	public static final String ID_PARAMETER = "id";

	public static final String PARENT_ID_PARAMETER = "refferentId";

	public static final String ADDITIONAL_ID_PARAMETER = "aId";

	public static final String FROM_PARAMETER = "from";

	public static void redirect(PagesTypes pageType) {
		try {
			redirect(pageType.getPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String appendArgument(String url, Serializable id) {
		return new StringBuilder().append(url).append("?").append(ID_PARAMETER)
				.append("=").append(id).toString();
	}

	public static void redirect(PagesTypes pageType, Serializable id) {
		try {
			redirect(appendArgument(pageType.getPath(), id));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void redirect(String url) throws IOException {
		HttpServletRequest req = (HttpServletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();
		StringBuilder sb = new StringBuilder("");
		sb.append(req.getRequestURL().substring(
				0,
				req.getRequestURL().indexOf(
						FacesContext.getCurrentInstance().getExternalContext()
								.getRequestContextPath())));
		sb.append(FacesContext.getCurrentInstance().getExternalContext()
				.getRequestContextPath());
		if (!url.startsWith("/")) {
			sb.append("/");
		}
		sb.append(url);
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(sb.toString());
	}
}
