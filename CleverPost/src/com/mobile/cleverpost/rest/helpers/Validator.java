package com.mobile.cleverpost.rest.helpers;

public class Validator {
	public static boolean isEmpty(String str) {
		if (str == null || str == "null" || str.length() == 0) {
			return true;
		}
		return false;
	}
}
