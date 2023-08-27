package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {
	WebDriver driver;

		// Appearance of the base class driver.
	public TrelloLoginPage(WebDriver driver) {
		// Re-Initialise the current class driver with base class driver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "user")
	private WebElement emailTextfield;

	public WebElement getEmailTextfield() {
		return emailTextfield;
	}

	@FindBy(id = "login")
	private WebElement continueButton;

	public WebElement getContinueButton() {
		return continueButton;
	}
}
