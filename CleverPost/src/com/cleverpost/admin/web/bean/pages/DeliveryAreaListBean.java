package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.common.helpers.IOHelper;
import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.DAOManager;
import com.mobile.cleverpost.rest.persistence.entities.DeliveryArea;
import com.mobile.cleverpost.rest.persistence.entities.Product;

@ManagedBean(name = "deliveryAreaListBean")
@ViewScoped
public class DeliveryAreaListBean extends ListPageBean<DeliveryArea> implements
		Serializable {

}
