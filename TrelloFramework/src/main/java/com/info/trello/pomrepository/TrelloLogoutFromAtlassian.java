package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLogoutFromAtlassian {
	WebDriver driver;

		// Appearance of the base class driver.
	public TrelloLogoutFromAtlassian(WebDriver driver) {
		// Re-Initialise the current class driver with base class driver.
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "logout-submit")
	private WebElement finalLogoutButton;

	public WebElement getfinalLogoutButton() {
		return finalLogoutButton;
	}
}
