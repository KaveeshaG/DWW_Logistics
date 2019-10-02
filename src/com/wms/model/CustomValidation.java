package com.wms.model;

public class CustomValidation {

	public CustomValidation() {

	}

	public static boolean emailValidation(String email) {

		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";

		return email.matches(regex);
	}

}
