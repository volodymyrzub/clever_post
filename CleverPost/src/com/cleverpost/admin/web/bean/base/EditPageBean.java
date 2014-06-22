package com.cleverpost.admin.web.bean.base;

import com.cleverpost.admin.common.enums.PagesTypes;
import com.cleverpost.admin.common.helpers.RedirectHelper;
import com.cleverpost.admin.common.helpers.ValidationHelper;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Entity;

public class EditPageBean<T extends Entity> extends GenericPageBean<T> {
	private T entity;
	// private Long entityId;

	private boolean canEdit;

	@Override
	public void onLoad() {
		String entityId = this.getUrlParameter(RedirectHelper.ID_PARAMETER);
		System.out.println("!!!! id = " + entityId);
		if (!ValidationHelper.isNullOrEmpty(entityId)
				&& !entityId.equals("null")) {
			try {
				this.entity = DAOManager.get(getType(), entityId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				this.entity = getType().newInstance();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onSave() {
		try {
			DAOManager.save(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RedirectHelper.redirect(PagesTypes.getListPage(getType()
				.getSimpleName()));
	}

	public void goBack() {
		RedirectHelper.redirect(PagesTypes.getListPage(getType()
				.getSimpleName()));
	}

	public String getImgDir() {
		return "../../../img/" + getType().getSimpleName() + "/";
	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	// public Long getEntityId() {
	// return entityId;
	// }
	//
	// public void setEntityId(Long entityId) {
	// this.entityId = entityId;
	// }

	public boolean isCanEdit() {
		return canEdit;
	}

	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
}
