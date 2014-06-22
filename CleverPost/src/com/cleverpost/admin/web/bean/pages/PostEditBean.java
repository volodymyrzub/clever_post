package com.cleverpost.admin.web.bean.pages;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.common.helpers.ValidationHelper;
import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.entities.Post;

@ManagedBean(name = "postEditBean")
@ViewScoped
public class PostEditBean extends EditPageBean<Post> implements Serializable {
	private static final long serialVersionUID = 1L;

	public void upload(FileUploadEvent event) {

		String contextPath = getRealContextPath();
		String photoName = getEntity().getPhoto();
		String uploadingFilename = event.getFile().getFileName();

		// del old file if exist or create unique name
		if (!ValidationHelper.isNullOrEmpty(photoName)) {
			System.out.println("deleting " + photoName);
			IOHelper.delete(contextPath + photoName);
		}
		photoName = IOHelper.getUniqueName()
				+ IOHelper.getExtension(uploadingFilename);

		FacesMessage msg = new FacesMessage("Success! ", uploadingFilename
				+ " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		this.getEntity().setPhoto(photoName);
		this.saveFile(event, photoName);
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

	public String getPhoto() {
		return getImgDir() + getEntity().getPhoto();
	}

}
