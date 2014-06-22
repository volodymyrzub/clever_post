package com.cleverpost.admin.common.helpers;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ValidationHelper {
	public transient final static Log log = LogFactory
			.getLog(ValidationHelper.class);

	public static String EMPTY = "";

	public static boolean isNullOrEmpty(String str) {
		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Object str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Boolean str) {
		return str == null;
	}

	public static boolean isNullOrEmpty(Date str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(List<?> list) {
		if (list == null || list.isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmptyEditor(String str) {
		if (str.equals("<br>")) {
			str = null;
		}

		if (str == null || str.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Long str) {
		if (str == null || str == 0l) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Integer str) {
		if (str == null || str == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNullOrEmpty(Double str) {
		if (str == null) {
			return true;
		}
		return false;
	}

	public static boolean isAlphanumeric(String value) {
		for (Character c : value.toCharArray()) {
			if (!Character.isLetterOrDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkMailCorrectFormat(String value) {
		return checkCorrectFormatByExpression(
				"^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}\\s{0,10}|[0-9]{1,3}\\s{0,10})(\\]?)$",
				value);
	}

	public static boolean checkCorrectFormatByExpression(String expression,
			String value) {
		return Pattern.matches(expression, value);
	}

	public static boolean validPassword(String value) {
		if (value != null && (value.length() != 0) && (value.length() < 8)) {
			return false;
		}

		boolean digit = false;
		boolean upperCase = false;
		boolean lowerCase = false;

		for (char ch : value.toCharArray()) {
			if (Character.isUpperCase(ch)) {
				upperCase = true;
			}
			if (Character.isLowerCase(ch)) {
				lowerCase = true;
			}
			if (Character.isDigit(ch)) {
				digit = true;
			}
		}

		if (!digit || !lowerCase || !upperCase) {
			return false;
		}
		return true;
	}

	public static boolean checkUserNameFormat(String value) {
		if (value != null && (value.length() < 3 || value.length() > 20)) {
			return false;
		}

		return true;
	}

	public static boolean checkFieldLengthFrom(String value, int from) {
		if (value != null && value.length() >= from) {
			return true;
		}

		return false;
	}

	public static boolean checkFieldLengthTo(String value, int to) {
		if (value != null && value.length() <= to) {
			return true;
		}

		return false;
	}

	public static boolean checkFieldLength(String value, int from, int to) {
		if (checkFieldLengthFrom(value, from) && checkFieldLengthTo(value, to)) {
			return true;
		}

		return false;
	}

	public static boolean isNumber(String value) {
		if (value == null || value.isEmpty()) {
			return true;
		}

		char[] valueMas = value.toCharArray();
		for (Character c : valueMas) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

	public static boolean checkTimeFormat(String value) {
		String[] strs = value.split(":");
		if (Integer.parseInt(strs[0]) > 23) {
			return false;
		}

		if (Integer.parseInt(strs[1]) > 59) {
			return false;
		}

		return true;
	}
}
