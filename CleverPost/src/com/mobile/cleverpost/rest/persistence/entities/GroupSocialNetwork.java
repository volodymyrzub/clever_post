package com.mobile.cleverpost.rest.persistence.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "group_social_network")
public class GroupSocialNetwork extends Entity implements
		Comparable<GroupSocialNetwork>, Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
	private String name;

	@Column(name = "key_group")
	private String keyGroup;

	@Column(name = "description")
	private String description;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private List<Post> post;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "group")
	private List<StatisticGroup> group;

	@Override
	public int compareTo(GroupSocialNetwork o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
