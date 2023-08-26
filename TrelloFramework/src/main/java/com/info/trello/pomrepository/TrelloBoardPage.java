package com.info.trello.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloBoardPage {
WebDriver driver;

public TrelloBoardPage(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
}

@FindBy (xpath = "//span[.='Create new board']")
private WebElement createNewBoard;

@FindBy (xpath = "//div[text()='Board title']/following-sibling::input")
private WebElement boardTitleTextfield;

@FindBy (xpath = "//button[@data-testid='header-member-menu-button']//descendant::span")
private WebElement accountButton;

@FindBy (xpath = "//span[.='Log out']")
private WebElement logoutOption;

@FindBy (xpath = "//button[@aria-label='Show menu']//span[@data-testid='OverflowMenuHorizontalIcon']")
private WebElement menuButton;

@FindBy(xpath = "//a[contains(.,'Close board')]")
private WebElement closeBoardOption;

@FindBy(xpath = "//input[@value='Close']")
private WebElement closeBoardButton;

@FindBy (xpath = "//button[.='Permanently delete board']")
private WebElement permanentDeleteBoardButton;

@FindBy (xpath = "//button[.='Delete']")
private WebElement permanentDeleteBoardDeleteButton;

@FindBy (xpath = "//span[.='Board deleted.']")
private WebElement BoardDeletedPopUp;

@FindBy (xpath = "//p[.='Create']")
private WebElement createNavigationButton;

@FindBy (xpath = "//button[@data-testid='header-create-board-button']")
private WebElement createBoardButton;

@FindBy (xpath = "//button[@data-testid='create-board-submit-button']")
private WebElement createBoardCreateButton;

@FindBy (xpath = "//input[@placeholder='Enter list title…']")
private WebElement enterListTitleTextfield;

@FindBy (xpath = "//input[@value='Add list']")
private WebElement addListButton;

@FindBy (xpath = "//textarea[.='CreatedListOne']/ancestor::div[@class='list js-list-content']")
//@FindBy (xpath = "//h2[.='CreatedListOne']/ancestor::div[@data-testid='list-wrapper']/div")
private WebElement listOnePosition;

@FindBy (xpath = "//textarea[.='CreatedListTwo']/ancestor::div[@class='list js-list-content']")
private WebElement listTwoPosition;


@FindBy (xpath = "//textarea[.='CreatedListThree']/ancestor::div[@class='list js-list-content']")
private WebElement listThreePosition;




public WebElement getCreateNewBoard() {
	return createNewBoard;
}

public WebElement getBoardTitleTextfield() {
	return boardTitleTextfield;
}

public WebElement getAccountButton() {
	return accountButton;
}

public WebElement getLogoutOption() {
	return logoutOption;
}

public WebElement getMenuButton() {
	return menuButton;
}

public WebElement getCloseBoardOption() {
	return closeBoardOption;
}

public WebElement getCloseBoardButton() {
	return closeBoardButton;
}

public WebElement getPermanentDeleteBoardButton() {
	return permanentDeleteBoardButton;
}

public WebElement getPermanentDeleteBoardDeleteButton() {
	return permanentDeleteBoardDeleteButton;
}

public WebElement getBoardDeletedPopUp() {
	return BoardDeletedPopUp;
}

public WebElement getCreateNavigationButton() {
	return createNavigationButton;
}

public WebElement getCreateBoardButton() {
	return createBoardButton;
}

public WebElement getCreateBoardCreateButton() {
	return createBoardCreateButton;
}

public WebElement getEnterListTitleTextfield() {
	return enterListTitleTextfield;
}

public WebElement getAddListButton() {
	return addListButton;
}

public WebElement getListOnePosition() {
	return listOnePosition;
}

public WebElement getListTwoPosition() {
	return listTwoPosition;
}

public WebElement getListThreePosition() {
	return listThreePosition;
}





}
