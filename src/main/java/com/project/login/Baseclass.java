package com.project.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	public static  WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("ie")) {
		//	System.setProperty("webdriver.ie.driver", ".//Driver//IEdriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new InternetExplorerDriver();
			
		}
		else if (browser.equalsIgnoreCase("firefox")) {
		//	System.setProperty("webdriver.gecko.driver", ".//Driver//geckodriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new FirefoxDriver();
			
		}
		else {
			System.out.println("Invalid Browser");
		}
		driver.manage().window().maximize();
		return driver;
	}
	public static void webpage(String url) {
		driver.get(url);
	}
	public static void navigate(String url2) {
		driver.navigate().to(url2);
	}
	public static void title() {
		driver.getTitle();
	}
	public void currentUrl() {
		driver.getCurrentUrl();
	}
	public static void forward() {
		driver.navigate().forward();
	}
	public static void backward() {
		driver.navigate().back();
	}
	public static void refresh() {
		driver.navigate().refresh();
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	public static void inputValue(WebElement element,String value) {
		element.sendKeys(value);
	}
	public static void clickOnElement(WebElement element) {
		element.click();
	}
	//screenshot
	public static void screenShot(String path) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotAs = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("C:\\Users\\krishna\\eclipse-workspace\\Selenium\\screenshot//s1.png");
		FileUtils.copyFile(screenshotAs, f);
	}
	//select
	public static void selectMethod(WebElement element,String option,String value) {
		Select s = new Select(element);
		if (option.equalsIgnoreCase("byIndex")) {
			int parseInt = Integer.parseInt(value);
			s.selectByIndex(parseInt);
		}
		else if (option.equalsIgnoreCase("by Value")) {
			s.selectByValue(value);
		}
		else if (option.equalsIgnoreCase("byVisibleText")) {
			s.selectByVisibleText(value);
		}
		else {
			System.out.println("Invalid Selection");
		}	
	}
		public static void enabled(WebElement element) {
			element.isEnabled();
		}
		public static void displayed(WebElement element) {
			element.isDisplayed();
		}
		public static void selected(WebElement element) {
			element.isSelected();
		}
		//alert
		public static void alertmethod(String option, String value) {
			Alert a = driver.switchTo().alert();
			if (option.equalsIgnoreCase("accept")) {
				a.accept();
			}
			else if (option.equalsIgnoreCase("dismiss")) {
				a.dismiss();
			}
			else if (option.equalsIgnoreCase("sendkeys")) {
				a.sendKeys(value);
			}
		}
		
		//action
		public static void actionMethod(WebElement element,WebElement drop, String object) {
			Actions a = new Actions(driver);
			if (object.equalsIgnoreCase("movetoelement")) {
				a.moveToElement(element).build().perform();
			}else if (object.equalsIgnoreCase("doubleclick")) {
				a.doubleClick(element).build().perform();
			}else if (object.equalsIgnoreCase("contextclick")) {
				a.contextClick(element).build().perform();
			}else {
				System.out.println("Invalid Action");
			}
		}
		public static void dragDrop(WebElement element,WebElement element1) {
			Actions ad = new Actions(driver);
			ad.dragAndDrop(element, element1).build().perform();
		}
		//robot
	public static void robotClass(String option) throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	
	//scroll
	public static void scrollFuction(WebElement element, String option, String value) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if (option.equalsIgnoreCase("scroll")) {
			js.executeScript("arguments[0].scrollIntoView()", element);
		}
		else if (option.equalsIgnoreCase("click")) {
			js.executeScript("arguments[0].click", element);
		}
		
	}
	//frame
	public static void frameMethod(WebElement element,String option, String value) {
		if (option.equalsIgnoreCase("byIndex")) {
			int parseInt = Integer.parseInt(value);
			driver.switchTo().frame(parseInt);
		} 
		else if (option.equalsIgnoreCase("byString")) {
			driver.switchTo().frame("value");
		}
		else if (option.equalsIgnoreCase("byElement")) {
			driver.switchTo().frame(element);
		}
		
	}
	public static void elementClear(WebElement element) {
		element.clear();
	}
	//windowhandles
	public static void windowHandles() {
		Set<String> element = driver.getWindowHandles();
		for (String st : element) {
			String title = driver.switchTo().window(st).getTitle();
			System.out.println(title);
		}
	}
	// multiple
	public static void multiselect(WebElement element) {
		Select s1 = new Select(element);
		List<WebElement>list = s1.getOptions();
		for (WebElement fa : list) {
			System.out.println(fa.getText());
		}
	}
	//tab
	public static void newtab(String option) {
		if (option.equalsIgnoreCase("tab")){
			driver.switchTo().newWindow(WindowType.TAB);
		}else if (option.equalsIgnoreCase("window")) {
			driver.switchTo().newWindow(WindowType.WINDOW);
		}
	}
	
	

}
