package com.project.login;

public class Script extends Baseclass {
	public static void main(String[] args) {
		browserLaunch("chrome");
		webpage("https://www.saucedemo.com/");
		LoginPage lp = new LoginPage(driver);
	}

}
