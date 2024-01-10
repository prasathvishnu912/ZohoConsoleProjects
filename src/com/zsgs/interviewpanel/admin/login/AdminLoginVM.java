package com.zsgs.interviewpanel.admin.login;

public class AdminLoginVM {
	public boolean loginCheck(AdminLoginView adView) {
		if(adView.un.equals("admin")&&adView.pwd.equals("12345"))
			return true;
		return false;
	}
}
