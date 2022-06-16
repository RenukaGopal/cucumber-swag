package com.login.runner;

import java.io.IOException;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.project.login.Baseclass;
import com.swag.helper.FileReaderManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/com/login/feature/Login.feature",
		glue = "com/login/stepdefinition",
		dryRun = false,
		monochrome = true,
		stepNotifications = true,
		publish = true,
		plugin = {//"pretty",
				   //"usage",
				   //"html:target/cucumber-reports/swag.html",
				   // "json:target/cucumber-reports/swag.json",
				  //"junit:target/cucumber-reports/swag.xml",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				
				
		}
	)	
		
public class loginrunner {
	public static WebDriver driver;
	@BeforeClass
	public static void launch() throws IOException {
		String launchBrowser = FileReaderManager.getInstance().getcrInstance().launchBrowser();
		driver = Baseclass.browserLaunch(launchBrowser);
	}
		
	}


