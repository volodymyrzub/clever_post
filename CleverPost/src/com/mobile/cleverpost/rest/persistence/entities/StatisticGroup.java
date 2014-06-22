package com.mobile.cleverpost.rest.persistence.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@javax.persistence.Entity
@Table(name = "statistic_group")
public class StatisticGroup extends Entity implements
		Comparable<StatisticGroup>, Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "full_coverage")
	private Long fullCoverage;
	
	@Column(name = "coverage_user")
	private Long coverageUser;

	@Column(name = "visitors")
	private Long visitors;

	@Column(name = "views")
	private Long views;

	@Column(name = "visibility")
	private Long visibility;

	@Column(name = "intersection_audience")
	private Long intersectionAudience;

	@ManyToOne
	@JoinColumn(name = "group_id")
	private GroupSocialNetwork group;

	public Long getFullCoverage() {
		return fullCoverage;
	}

	public void setFullCoverage(Long fullCoverage) {
		this.fullCoverage = fullCoverage;
	}

	public GroupSocialNetwork getGroup() {
		return group;
	}

	public void setGroup(GroupSocialNetwork group) {
		this.group = group;
	}

	public Long getCoverageUser() {
		return coverageUser;
	}

	public void setCoverageUser(Long coverageUser) {
		this.coverageUser = coverageUser;
	}

	public Long getVisitors() {
		return visitors;
	}

	public void setVisitors(Long visitors) {
		this.visitors = visitors;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

	public Long getVisibility() {
		return visibility;
	}

	public void setVisibility(Long visibility) {
		this.visibility = visibility;
	}

	public Long getIntersectionAudience() {
		return intersectionAudience;
	}

	public void setIntersectionAudience(Long intersectionAudience) {
		this.intersectionAudience = intersectionAudience;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object) sort by visitors
	 */
	public int compareTo(StatisticGroup stat) {
		return this.visitors.compareTo(stat.visitors);
	}

}
