package boards.info.trello.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.info.trello.genericutility.BaseClass;
import com.info.trello.pomrepository.TrelloBoardPage;
import com.info.trello.pomrepository.TrelloHomePage;
import com.info.trello.pomrepository.TrelloLoginPage;
import com.info.trello.pomrepository.TrelloLoginToContinuePage;
import com.info.trello.pomrepository.TrelloLogoutFromAtlassian;

public class MyFirstScript extends BaseClass {
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
