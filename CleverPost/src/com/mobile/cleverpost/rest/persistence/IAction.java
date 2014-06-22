package com.mobile.cleverpost.rest.persistence;

public interface IAction {

	public void onBeforeExecute();

	public void onException(Exception e) throws Exception;

	public void onExecuted();

	public void execute(Object obj) throws Exception;

}
