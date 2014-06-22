package com.mobile.cleverpost.rest.persistence.dao;

import org.hibernate.sql.JoinType;

public class CriteriaAlias {
	private String table;

	private String aliasName;

	private JoinType joinType;

	public CriteriaAlias(String table, String aliasName, JoinType joinType) {
		this.setTable(table);
		this.setAliasName(aliasName);
		this.setJoinType(joinType);
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public JoinType getJoinType() {
		return joinType;
	}

	public void setJoinType(JoinType joinType) {
		this.joinType = joinType;
	}

	public String getAliasName() {
		return aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}
}
