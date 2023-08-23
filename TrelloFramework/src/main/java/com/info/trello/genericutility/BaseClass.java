package com.info.trello.genericutility;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * 
 * @author MAYUR
 *
 */
public class BaseClass {

	public WebDriver driver;
	public FileUtilty fileUtils = new FileUtilty();
	public WebdriverUtility webdriverUtils = new WebdriverUtility();
	public ExcelUtility excelUtils = new ExcelUtility();

	
	@BeforeMethod
	public void configBeforeMethod() throws IOException {
		String browserName = fileUtils.readCommonData("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equals("edge")) {
			driver= new EdgeDriver();
		}else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(fileUtils.readCommonData("url"));
	}
	
	@AfterMethod
	public void configAfterMethod() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	
	
	
}
