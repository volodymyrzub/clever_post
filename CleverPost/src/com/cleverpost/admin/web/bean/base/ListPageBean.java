package com.cleverpost.admin.web.bean.base;

import java.util.ArrayList;
import java.util.List;

import com.cleverpost.admin.common.enums.PagesTypes;
import com.cleverpost.admin.common.helpers.RedirectHelper;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.Entity;

public class ListPageBean<T extends Entity> extends GenericPageBean<T> {
	private List<T> list;
	protected T[] selectedList;
	protected List<T> filteredList;
	protected Long entityEditId;
	private Long entityDeleteId;

	public ListPageBean() {

	}

	public void onLoad() {
		try {
			list = DAOManager.load(getType());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			list = new ArrayList<T>();
		}
	}

	public void addEntity() {
		RedirectHelper.redirect(PagesTypes.getEditPage(getType()
				.getSimpleName()));
	}

	public void editEntity() {
		RedirectHelper.redirect(
				PagesTypes.getEditPage(getType().getSimpleName()),
				getEntityEditId());
	}

	public void deleteEntity() {
		if (this.getEntityDeleteId() != null) {
			try {
				Entity delete = DAOManager.get(getType(), getEntityDeleteId());
				DAOManager.remove(delete);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RedirectHelper.redirect(PagesTypes.getListPage(getType()
					.getSimpleName()));
		}
	}

	public void setEntityEditId(Long entityEditId) {
		this.entityEditId = entityEditId;
	}

	public Long getEntityEditId() {
		return entityEditId;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public T[] getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(T[] selectedList) {
		this.selectedList = selectedList;
	}

	public List<T> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<T> filteredList) {
		this.filteredList = filteredList;
	}

	public Long getEntityDeleteId() {
		return entityDeleteId;
	}

	public void setEntityDeleteId(Long entityDeleteId) {
		this.entityDeleteId = entityDeleteId;
	}
}