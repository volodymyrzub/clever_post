package com.cleverpost.admin.web.bean.pages;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import com.cleverpost.admin.web.bean.base.EditPageBean;
import com.mobile.cleverpost.rest.persistence.entities.DeliveryArea;

@ManagedBean(name = "deliveryAreaEditBean")
@ViewScoped
public class DeliveryAreaEditBean extends EditPageBean<DeliveryArea> implements
		Serializable {

}
