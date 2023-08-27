package boards.info.trello.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.info.trello.genericutility.BaseClass;
import com.info.trello.pomrepository.TrelloBoardPage;
import com.info.trello.pomrepository.TrelloHomePage;
import com.info.trello.pomrepository.TrelloLoginPage;
import com.info.trello.pomrepository.TrelloLoginToContinuePage;
import com.info.trello.pomrepository.TrelloLogoutFromAtlassian;

public class TestCases extends BaseClass {

	@Test
	public void trelloHomePageCheck() throws EncryptedDocumentException, IOException {
		webdriverUtils.implicitWait(driver);
		// Verify HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello Homepage Title is Not Matched");
	}

	@Test()
	public void trelloLoginPageCheck() throws EncryptedDocumentException, IOException {
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
	}

	@Test
	public void trelloBoardPageCheck() throws EncryptedDocumentException, IOException {
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
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("mayurmokal"),
				"Trello Profile Boards Page URL is Not Matched");
		// Verify Profile Boards Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 7, 1),
				"Trello Profile Boards Page Title is Not Matched");
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// Click On Account Option
		boardPage.getAccountButton().click();
		// Verify Logout Option is Enable
		Assert.assertTrue(boardPage.getLogoutOption().isEnabled(),
				"Trello Profile Board Page Logout Option is Not Visible and Clickable");
		// Click on Logout Option
		boardPage.getLogoutOption().click();
		
		TrelloLogoutFromAtlassian finalLogout = new TrelloLogoutFromAtlassian(driver);
		
		webdriverUtils.waitForElementIsClickable(driver, finalLogout.getfinalLogoutButton());
		// Verify the Logout Page using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 8, 1)),
				"Trello Logout Page URL is Not Matched");
		// Verify the Logout Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 9, 1),
				"Trello Logout Page Title is Not Matched");
		
		// Click on the Final Logout Button
		finalLogout.getfinalLogoutButton().click();
		webdriverUtils.waitForElementIsClickable(driver, homepage.getLoginOption());
		// Verify the HomePage using URL
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("home"), "Trello HomePage URL is Not Matched");
		// Verify the HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello HomePage Title is Not Matched");
	}

	@Test
	public void trelloCreateAndDeleteBoard() throws EncryptedDocumentException, IOException {
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
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("mayurmokal"),
				"Trello Profile Boards Page URL is Not Matched");
		// Verify Profile Boards Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 7, 1),
				"Trello Profile Boards Page Title is Not Matched");
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// Click On Account Option
		boardPage.getAccountButton().click();
		// Verify Logout Option is Enable
		Assert.assertTrue(boardPage.getLogoutOption().isEnabled(),
				"Trello Profile Board Page Logout Option is Not Visible and Clickable");
		// Click On Account Option to Close Menu
		boardPage.getAccountButton().click();
		// Click on the Create Button
		boardPage.getCreateNavigationButton().click();
		Assert.assertTrue(boardPage.getCreateBoardButton().isEnabled(), "Create Board Button is Not Enable");
		boardPage.getCreateBoardButton().click();
		Assert.assertTrue(boardPage.getBoardTitleTextfield().isEnabled(), "Board Title Textfield is Not Enabled");
		// Enter Value in BoardTitleTextfield to Create New Board
		boardPage.getBoardTitleTextfield().sendKeys("CreateBoardOne");
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getCreateBoardCreateButton());
		boardPage.getCreateBoardCreateButton().click();
		// Verify Created Boards Page using URL
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getMenuButton());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("createboardone"),
				"Created Board Page URL is Not Matched");
		// Click on the Menu Button
		boardPage.getMenuButton().click();
		// Click on Close Board Button
		boardPage.getCloseBoardOption().click();
		boardPage.getCloseBoardButton().click();
		// Click on Permannent Delete Board Button
		boardPage.getPermanentDeleteBoardButton().click();
		boardPage.getPermanentDeleteBoardDeleteButton().click();
		Assert.assertTrue(boardPage.getBoardDeletedPopUp().isDisplayed(), "Board is Deleted PopUp is Not Displayed");
		// Click on Account Button
		boardPage.getAccountButton().click();
		// Click on Logout Option
		boardPage.getLogoutOption().click();
		TrelloLogoutFromAtlassian logoutFromAtlassian = new TrelloLogoutFromAtlassian(driver);
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 8, 1)),
				"Atlassion Logout Page URL is Not Matched");
		// Click on Atlassion Logout Button
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 9, 1),
				"Atlassion Logout Page Title is Not Matched");
		logoutFromAtlassian.getfinalLogoutButton().click();
		// Verify HomePage using URL
		webdriverUtils.waitForElementIsClickable(driver, homepage.getLoginOption());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("home"),
				"After Logout HomePage URL is Not Matched");
		// Verify HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello Homepage Title is Not Matched");
	}

	
	public void trelloCreateMultipleListInCreatedBoard() throws EncryptedDocumentException, IOException {
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
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("mayurmokal"),
				"Trello Profile Boards Page URL is Not Matched");
		// Verify Profile Boards Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 7, 1),
				"Trello Profile Boards Page Title is Not Matched");
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// Click On Account Option
		boardPage.getAccountButton().click();
		// Verify Logout Option is Enable
		Assert.assertTrue(boardPage.getLogoutOption().isEnabled(),
				"Trello Profile Board Page Logout Option is Not Visible and Clickable");
		// Click On Account Option to Close Menu
		boardPage.getAccountButton().click();
		// Click on the Create Button
		boardPage.getCreateNavigationButton().click();
		Assert.assertTrue(boardPage.getCreateBoardButton().isEnabled(), "Create Board Button is Not Enable");
		boardPage.getCreateBoardButton().click();
		Assert.assertTrue(boardPage.getBoardTitleTextfield().isEnabled(), "Board Title Textfield is Not Enabled");
		// Enter Value in BoardTitleTextfield to Create New Board
		boardPage.getBoardTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 0, 1));
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getCreateBoardCreateButton());
		boardPage.getCreateBoardCreateButton().click();
		// Verify Created Boards Page using URL
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getMenuButton());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("createboardone"),
				"Created Board Page URL is Not Matched");
		// Create 2 List
		boardPage.getEnterListTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 1, 1));
		boardPage.getAddListButton().click();
		boardPage.getEnterListTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 1, 2));
		boardPage.getAddListButton().click();
		// Click on the Menu Button
		boardPage.getMenuButton().click();
		// Click on Close Board Button
		boardPage.getCloseBoardOption().click();
		boardPage.getCloseBoardButton().click();
		// Click on Permannent Delete Board Button
		boardPage.getPermanentDeleteBoardButton().click();
		boardPage.getPermanentDeleteBoardDeleteButton().click();
		Assert.assertTrue(boardPage.getBoardDeletedPopUp().isDisplayed(), "Board is Deleted PopUp is Not Displayed");
		// Click on Account Button
		boardPage.getAccountButton().click();
		// Click on Logout Option
		boardPage.getLogoutOption().click();
		TrelloLogoutFromAtlassian logoutFromAtlassian = new TrelloLogoutFromAtlassian(driver);
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 8, 1)),
				"Atlassion Logout Page URL is Not Matched");
		// Click on Atlassion Logout Button
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 9, 1),
				"Atlassion Logout Page Title is Not Matched");
		logoutFromAtlassian.getfinalLogoutButton().click();
		// Verify HomePage using URL
		webdriverUtils.waitForElementIsClickable(driver, homepage.getLoginOption());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("home"),
				"After Logout HomePage URL is Not Matched");
		// Verify HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello Homepage Title is Not Matched");
	}

	@Test
	public void trelloCreateMultipleListAndSwapInCreatedBoard()
			throws EncryptedDocumentException, IOException, InterruptedException {
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
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("mayurmokal"),
				"Trello Profile Boards Page URL is Not Matched");
		// Verify Profile Boards Page using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 7, 1),
				"Trello Profile Boards Page Title is Not Matched");
		
		TrelloBoardPage boardPage = new TrelloBoardPage(driver);
		// Click On Account Option
		boardPage.getAccountButton().click();
		// Verify Logout Option is Enable
		Assert.assertTrue(boardPage.getLogoutOption().isEnabled(),
				"Trello Profile Board Page Logout Option is Not Visible and Clickable");
		// Click On Account Option to Close Menu
		boardPage.getAccountButton().click();
		// Click on the Create Button
		boardPage.getCreateNavigationButton().click();
		Assert.assertTrue(boardPage.getCreateBoardButton().isEnabled(), "Create Board Button is Not Enable");
		boardPage.getCreateBoardButton().click();
		Assert.assertTrue(boardPage.getBoardTitleTextfield().isEnabled(), "Board Title Textfield is Not Enabled");
		// Enter Value in BoardTitleTextfield to Create New Board
		boardPage.getBoardTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 0, 1));

		webdriverUtils.waitForElementIsClickable(driver, boardPage.getCreateBoardCreateButton());
		boardPage.getCreateBoardCreateButton().click();
		// Verify Created Boards Page using URL
		webdriverUtils.waitForElementIsClickable(driver, boardPage.getMenuButton());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("createboardone"),
				"Created Board Page URL is Not Matched");
		// Create 2 List
		boardPage.getEnterListTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 1, 1));
		boardPage.getAddListButton().click();
		boardPage.getEnterListTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 1, 2));
		boardPage.getAddListButton().click();
		boardPage.getEnterListTitleTextfield().sendKeys(excelUtils.readStringData("CreatedBoard", 1, 3));
		boardPage.getAddListButton().click();
		// Swapping Position of List 1 and List2
			// Delay to see the execution			
		Thread.sleep(2000);
		Actions actions = new Actions(driver);
		//actions.dragAndDrop(boardPage.getListOnePosition(), boardPage.getListTwoPosition()).perform();			
		//actions.dragAndDrop(boardPage.getListTwoPosition(), boardPage.getListOnePosition()).perform();
		actions.dragAndDropBy(boardPage.getListOnePosition(), 400, 10).perform();
		//actions.clickAndHold(boardPage.getListOnePosition()).pause(2000).moveByOffset(400, 10).pause(2000).release().build().perform();
		Thread.sleep(2000);
		// Click on the Menu Button
		boardPage.getMenuButton().click();
		// Click on Close Board Button
		boardPage.getCloseBoardOption().click();
		boardPage.getCloseBoardButton().click();
		// Click on Permannent Delete Board Button
		boardPage.getPermanentDeleteBoardButton().click();
		boardPage.getPermanentDeleteBoardDeleteButton().click();
		Assert.assertTrue(boardPage.getBoardDeletedPopUp().isDisplayed(), "Board is Deleted PopUp is Not Displayed");
		
		// Click on Account Button
		boardPage.getAccountButton().click();
		// Click on Logout Option
		boardPage.getLogoutOption().click();
		TrelloLogoutFromAtlassian logoutFromAtlassian = new TrelloLogoutFromAtlassian(driver);
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains(excelUtils.readStringData("Sheet1", 8, 1)),
				"Atlassion Logout Page URL is Not Matched");
		// Click on Atlassion Logout Button
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 9, 1),
				"Atlassion Logout Page Title is Not Matched");
		logoutFromAtlassian.getfinalLogoutButton().click();
		// Verify HomePage using URL
		webdriverUtils.waitForElementIsClickable(driver, homepage.getLoginOption());
		Assert.assertTrue(webdriverUtils.getCurrentURL(driver).contains("home"),
				"After Logout HomePage URL is Not Matched");
		// Verify HomePage using Title
		Assert.assertEquals(webdriverUtils.getTitle(driver), excelUtils.readStringData("Sheet1", 1, 1),
				"Trello Homepage Title is Not Matched");
	}

	
	
	
}
