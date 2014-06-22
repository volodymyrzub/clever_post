package com.cleverpost.admin.web.bean.pages;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.cleverpost.admin.web.bean.base.ListPageBean;
import com.mobile.cleverpost.rest.persistence.dao.security.entities.User;

@ManagedBean(name = "userListBean")
@ViewScoped
public class UserListBean extends ListPageBean<User> {

}
