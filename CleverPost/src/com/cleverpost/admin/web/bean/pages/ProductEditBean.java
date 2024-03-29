package com.cleverpost.admin.web.bean.pages;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.common.helpers.ValidationHelper;
import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Product;
import com.mobile.cleverpost.rest.persistence.entities.ProductCategory;

@ManagedBean(name = "productEditBean")
@ViewScoped
public class ProductEditBean extends EditPageBean<Product> implements
		Serializable {

	private static final String DEFAULT_CATEGORY_NAME = "";
	private List<SelectItem> categories;
	private Long selected;

	public List<SelectItem> getCategories() {
		return categories;
	}

	public void setCategories(List<SelectItem> categories) {
		this.categories = categories;
	}

	public Long getSelected() {
		return selected;
	}

	public void setSelected(Long selected) {
		this.selected = selected;
	}

	@Override
	public void onSave() {
		if (this.getSelected() != 0) {
			try {
				ProductCategory item = DAOManager.get(ProductCategory.class,
						getSelected());
				this.getEntity().setProductCategory(item);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		super.onSave();
	}

	@Override
	public void onLoad() {
		super.onLoad();
		loadParents();
	}

	public void loadParents() {
		try {
			if (getEntity().getProductCategory() != null) {
				selected = getEntity().getProductCategory().getId();
			}
			categories = new ArrayList<SelectItem>();
			categories.add(new SelectItem(0, DEFAULT_CATEGORY_NAME));
			for (ProductCategory item : DAOManager.load(ProductCategory.class)) {
				categories.add(new SelectItem(item.getId(), item.getName()));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void categorySelected(ValueChangeEvent event) {
		String str = event.getNewValue().toString();
		setSelected(Long.valueOf(str));
	}

	public void upload(FileUploadEvent event) {

		String contextPath = getRealContextPath();
		String pictureName = getEntity().getPicture();
		String uploadingFilename = event.getFile().getFileName();

		// del old file if exist or create unique name
		if (!ValidationHelper.isNullOrEmpty(pictureName)) {
			// TODO
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
