package com.mobile.cleverpost.rest.persistence.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class Entity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	protected Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_date")
	protected Date createDate;

	@Column(name = "create_user_id")
	protected Long createUserId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	protected Date updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@PrePersist
	protected void onCreate() {
		updateDate = createDate = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updateDate = new Date();
	}

	public boolean isNew() {
		if (this.getId() == null || this.getId() <= 0) {
			return true;
		}

		return false;
	}
}
