package com.swag.helper;

import org.openqa.selenium.WebDriver;

import com.project.login.LoginPage;

public class PageObjcetManager {
	public static WebDriver driver;
	private LoginPage lp;
	public PageObjcetManager (WebDriver driver1) {
		this.driver = driver1;
	}
	public LoginPage getLoginPage() {
		lp = new LoginPage(driver);
		return lp;
		
	}
}
