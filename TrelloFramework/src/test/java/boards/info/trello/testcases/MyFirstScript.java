package boards.info.trello.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.info.trello.genericutility.BaseClass;
import com.info.trello.pomrepository.TrelloBoardPage;
import com.info.trello.pomrepository.TrelloHomePage;
import com.info.trello.pomrepository.TrelloLoginPage;
import com.info.trello.pomrepository.TrelloLoginToContinuePage;
import com.info.trello.pomrepository.TrelloLogoutFromAtlassian;

public class MyFirstScript extends BaseClass {

	
	public void TrelloUserLogin() throws EncryptedDocumentException, IOException {
		webdriverUtils.implicitWait(driver);
		// Verify HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello Homepage Title is Not Matched");
		TrelloHomePage homepage = new TrelloHomePage(driver);
		// Click On the Login Button
		homepage.getLoginOption().click();
		// Verify Login Page using URL
		Assert.assertEquals(webdriverUtils.getCurrentURL(driver), excelUtils.readStringData("Sheet1", 2, 1),
				"Trello LoginPage URL is Not Matched");
		// Verify Login Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 3, 1),
				"Trello LoginPage Title is Not Matched");
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		// Enter email in Email Textfield
		loginPage.getEmailTextfield().sendKeys(fileUtils.readCommonData("email"));
		// Click on Continue Button
		loginPage.getContinueButton().click();
		webdriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("Sheet1", 5, 1));
		// Verify Login To Continue Page using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 4, 1)),
				"Trello Login To Continue Page URL is Not Matched. Please Enter Valid Email");
		// Verify Login To Continue Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 5, 1),
				"Trello Login To Continue Page Title is Not Matched");
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);
		webdriverUtils.waitForElementIsClickable(driver, loginToContinuePage.getPasswordTextfield());
		// Enter the Password in Password Textfield
		loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		// Click on Login Button
		loginToContinuePage.getLoginButton().click();
		webdriverUtils.waitForCompleteTitle(driver, excelUtils.readStringData("Sheet1", 7, 1));
		// Verify Profile Boards Page using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("LoginUsers", 1, 0)),
				"Trello Profile Boards Page Title is Not Matched");
		// Verify Profile Boards Page using Title
				Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 7, 1),
						"Trello Profile Boards Page URL is Not Matched");
	}
	
	
	public void trelloUserLogout() throws EncryptedDocumentException, IOException {
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// Click On Account Option
		boardPage.getAccountButton().click();
		// Verify Logout Option is Enable
		Assert.assertTrue(boardPage.getLogoutOption().isEnabled(),
				"Trello Profile Board Page Logout Option is Not Visible and Clickable");
		// Click on Logout Option
		boardPage.getLogoutOption().click();
		// Verify the Logout Page using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 9, 1)),
				"Trello Logout Page URL is Not Matched");
		// Verify the Logout Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 10, 1),
				"Trello Logout Page Title is Not Matched");
		TrelloLogoutFromAtlassian finalLogout = new TrelloLogoutFromAtlassian(driver);
		// Click on the Final Logout Button
		finalLogout.getfinalLogoutButton().click();
		TrelloHomePage homepage = new TrelloHomePage(driver);
		webdriverUtils.waitForElementIsClickable(driver, homepage.getLoginOption());
		// Verify the HomePage using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("home"), "Trello HomePage URL is Not Matched");
		// Verify the HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello HomePage Title is Not Matched");
	}
	

	@Test
	public void loginLogoutToTrello() throws IOException, InterruptedException {
		webdriverUtils.implicitWait(driver);
		TrelloHomePage homepage = new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextfield().sendKeys(fileUtils.readCommonData("email"));
		loginPage.getContinueButton().click();
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);
		webdriverUtils.waitForElementIsClickable(driver, loginToContinuePage.getPasswordTextfield());
		loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		loginToContinuePage.getLoginButton().click();
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getAccountButton().click();
		boardPage.getLogoutOption().click();
		TrelloLogoutFromAtlassian logoutPage = new TrelloLogoutFromAtlassian(driver);
		logoutPage.getfinalLogoutButton().click();
	}

	@Test
	public void loginCreateBoardDeleteBoardLogout() throws IOException {
		webdriverUtils.implicitWait(driver);
		TrelloHomePage homepage = new TrelloHomePage(driver);
		homepage.getLoginOption().click();
		TrelloLoginPage loginPage = new TrelloLoginPage(driver);
		loginPage.getEmailTextfield().sendKeys(fileUtils.readCommonData("email"));
		loginPage.getContinueButton().click();
		TrelloLoginToContinuePage loginToContinuePage = new TrelloLoginToContinuePage(driver);
		webdriverUtils.waitForElementIsClickable(driver, loginToContinuePage.getPasswordTextfield());
		loginToContinuePage.getPasswordTextfield().sendKeys(fileUtils.readCommonData("password"));
		loginToContinuePage.getLoginButton().click();
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		boardPage.getCreateNewBoard().click();
		boardPage.getBoardTitleTextfield().sendKeys("Framework");
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getCreateBoardCreateButton());
		boardPage.getCreateBoardCreateButton().click();
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getMenuButton());
		boardPage.getMenuButton().click();
		boardPage.getCloseBoardOption().click();
		boardPage.getCloseBoardButton().click();
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getPermanentDeleteBoardButton());
		boardPage.getPermanentDeleteBoardButton().click();
		boardPage.getPermanentDeleteBoardDeleteButton().click();
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getAccountButton());
		boardPage.getAccountButton().click();
		boardPage.getLogoutOption().click();
		TrelloLogoutFromAtlassian logoutPage = new TrelloLogoutFromAtlassian(driver);
		logoutPage.getfinalLogoutButton().click();
	}

}
