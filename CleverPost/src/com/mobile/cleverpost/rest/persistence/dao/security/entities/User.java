package com.mobile.cleverpost.rest.persistence.dao.security.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.mobile.cleverpost.rest.persistence.entities.Entity;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "users")
public class User extends Entity {
	// CREATE TABLE `jsf_spring_sec_users` (
	// `PK_JSF_SPRING_SEC_USERS` int(11) NOT NULL AUTO_INCREMENT,
	// `JSF_SPRING_SEC_USERS_USERNAME` varchar(45) NOT NULL,
	// `JSF_SPRING_SEC_USERS_PASSWORD` varchar(255) NOT NULL,
	// `JSF_SPRING_SEC_USERS_ENABLED` varchar(5) NOT NULL,
	// `JSF_SPRING_SEC_USERS_CREATED_DT` varchar(45) NOT NULL,
	// `JSF_SPRING_SEC_USERS_MODIFIED_DT` varchar(45) DEFAULT NULL,
	// PRIMARY KEY (`PK_JSF_SPRING_SEC_USERS`),
	// UNIQUE KEY `JSF_SPRING_SEC_USERS_USERNAME_UNIQUE`
	// (`JSF_SPRING_SEC_USERS_USERNAME`)

	// @GeneratedValue(strategy = GenerationType.AUTO)
	// @Column(name = "PK_JSF_SPRING_SEC_USERS", nullable = false)
	// private Long id;

	@Column(name = "USERNAME", nullable = false, length = 45)
	private String username;

	@Column(name = "PASSWORD", nullable = false, length = 255)
	private String password;

	@Column(name = "ENABLED", nullable = false)
	private Boolean enabled;

	@Column(name = "CREATED_DT")
	private Date createdDate;

	@Column(name = "MODIFIED_DT")
	private Date modifiedDate;

	@OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE)
	private UserRole userRole;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public User() {
		super();
	}

	public User(String username, String password, Boolean enabled,
			Date createdDate, Date modifiedDate) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
	}
}
