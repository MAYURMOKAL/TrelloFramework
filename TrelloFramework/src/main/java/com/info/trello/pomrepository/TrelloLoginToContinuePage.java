package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginToContinuePage {
	WebDriver driver;

		// Appearance of the base class driver.
	public TrelloLoginToContinuePage(WebDriver driver) {
		// Re-Initialise the current class driver with base class driver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/input[@id='password']")
	private WebElement passwordTextfield;

	public WebElement getPasswordTextfield() {
		return passwordTextfield;
	}

	@FindBy(xpath = "//button[@id='login-submit']")
	private WebElement loginButton;

	public WebElement getLoginButton() {
		return loginButton;
	}
}
