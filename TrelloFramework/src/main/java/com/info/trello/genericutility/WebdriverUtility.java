package com.info.trello.genericutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
/**
 * this method is used to provide implicitly Wait for findElement() and findElements().
 * @param driver
 * 
 */
	public void implicitWait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public boolean waitForCompleteTitle(WebDriver driver, String expectedTitle) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		Boolean validate = wait.until(ExpectedConditions.titleIs(expectedTitle));
		return validate;
	}
	
	public WebElement waitForElementIsClickable(WebDriver driver, WebElement TargetElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	WebElement validate = wait.until(ExpectedConditions.elementToBeClickable(TargetElement));
	return validate;
	}
	
	public String getCurrentURL(WebDriver driver) {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}
	
	public String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
	
	
}
