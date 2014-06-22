package com.cleverpost.admin.web.bean.pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.common.helpers.ValidationHelper;
import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Restaurant;

@ManagedBean(name = "restaurantEditBean")
@ViewScoped
public class RestaurantEditBean extends EditPageBean<Restaurant> implements
		Serializable {

	public void upload(FileUploadEvent event) {

		String contextPath = getRealContextPath();
		String pictureName = getEntity().getPicture();
		String uploadingFilename = event.getFile().getFileName();

		// del old file if exist or create unique name
		if (!ValidationHelper.isNullOrEmpty(pictureName)) {
			System.out.println("deleting " + pictureName);
			IOHelper.delete(contextPath + pictureName);
		}
		pictureName = IOHelper.getUniqueName()
				+ IOHelper.getExtension(uploadingFilename);

		FacesMessage msg = new FacesMessage("Success! ", uploadingFilename
				+ " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.getEntity().setPicture(pictureName);
		this.saveFile(event, pictureName);
	}

	private void saveFile(FileUploadEvent event, String toFilename) {
		try {
			InputStream is = event.getFile().getInputstream();
			IOHelper.writeImg(getType().getSimpleName(), toFilename,
					IOHelper.getOutputStream(is));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPicture() {
		return getImgDir() + getEntity().getPicture();
	}

}
