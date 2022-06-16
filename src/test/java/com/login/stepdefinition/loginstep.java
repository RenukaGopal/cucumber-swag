package com.login.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.login.runner.loginrunner;
import com.project.login.Baseclass;
import com.project.login.LoginPage;
import com.swag.helper.PageObjcetManager;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.textui.TestRunner;

public class loginstep extends Baseclass {
	public static WebDriver driver = loginrunner.driver;
	LoginPage lp = new LoginPage(driver);
	PageObjcetManager pom = new PageObjcetManager(driver);
	@Before
	public void beforeHooks(Scenario scenario) {
		String name = scenario.getName();
		System.out.println("scenarioName: "+name);
	}
	@After
	public void afterHooks(Scenario scenario) throws IOException {
		Status status = scenario.getStatus();
		System.out.println("scenarioStatus: "+status);
		if(scenario.isFailed()) {
			screenShot(scenario.getName());
		}
	}

	@Given("user launches swag {string} application")
	public void user_launches_swag_application(String url) {
	   webpage(url);
	}

	@When("user enter the user name in user textbox")
	public void user_enter_the_user_name_in_user_textbox() {
	    inputValue(lp.getUsername(), "standard_user");
	}

	@When("user enter the password in pass textbox")
	public void user_enter_the_password_in_pass_textbox() {
	   inputValue(lp.getPassword(), "secret_sauce");
	}

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
    	clickOnElement(lp.getLogin());
}
	@Then("user verifies the product homepage")
	public void user_verifies_the_product_homepage()  {
	    System.out.println("User verified successfully");
	}


}
