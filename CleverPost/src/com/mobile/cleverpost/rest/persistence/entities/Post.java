package com.mobile.cleverpost.rest.persistence.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "post")
public class Post extends Entity implements Comparable<Post>, Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column
	private String photo;

	@Column(name = "description")
	private String description;

	@Column(name = "time")
	private Date time;

	@Column(name = "date")
	@Temporal(value = TemporalType.DATE)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupSocialNetwork group;

	public GroupSocialNetwork getGroup() {
		return group;
	}

	public void setGroup(GroupSocialNetwork group) {
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int compareTo(Post post) {
		return this.date.compareTo(post.getDate());
	}
}
