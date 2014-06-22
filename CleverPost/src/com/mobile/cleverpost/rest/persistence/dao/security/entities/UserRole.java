package com.mobile.cleverpost.rest.persistence.dao.security.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.mobile.cleverpost.rest.persistence.entities.Entity;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "authorities ")
public class UserRole extends Entity {

	@Column(name = "USERNAME", nullable = false, length = 45)
	private String username;

	@Column(name = "authority", nullable = false, length = 45)
	private String roleName;

	@Column(name = "JSF_SPRING_SEC_ROLES_CREATED_DT", nullable = false, length = 45)
	private Date createdDate;

	@Column(name = "JSF_SPRING_SEC_ROLES_MODIFIED_DT", length = 45)
	private Date modifiedDate;

	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public UserRole() {
		super();
	}

	public UserRole(String username, String roleName, Date createdDate,
			Date modifiedDate) {
		this.username = username;
		this.roleName = roleName;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return roleName;
	}
}