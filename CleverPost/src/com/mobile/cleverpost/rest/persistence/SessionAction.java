package com.mobile.cleverpost.rest.persistence;

import org.hibernate.Session;

public abstract class SessionAction implements IAction {

	@Override
	public void onBeforeExecute() {
		return;
	}

	@Override
	public void onException(Exception e) throws Exception {
		throw e;
	}

	@Override
	public void onExecuted() {
		return;
	}
	
	@Override
	public final void execute(Object obj) throws Exception {
		if (obj instanceof Session) {
			this.execute((Session) obj);
		} else {
			throw new IllegalArgumentException(
					"Only org.hibernate.Session allowed");
		}
	}

	public abstract void execute(Session session) throws Exception;

}
