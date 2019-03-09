package com.wallet.hub.java.pages;

import org.openqa.selenium.WebDriver;

import com.wallet.hub.java.util.Log;
import com.wallet.hub.java.util.ObjectRepoUtility;

public class TrelloHomePage {

	ObjectRepoUtility objRepo;

	public TrelloHomePage(WebDriver driver) {
		objRepo = new ObjectRepoUtility(driver);
	}

	public void clickOnBoard() {
		objRepo.ConstructElementByCss("a.header-boards").click();
	}

	public void clickOnCreatNewLink() {
		objRepo.constructXpathTextElement("Create new board").click();
	}
	
	public void selectTheme(String attributeValue) {
		objRepo.ConstructElementByCssTagAttributeValue("button", "title", attributeValue).click();
	}
	
	public void addBoardTitle(String boardTitle) {
		objRepo.enterTextPlaceHolderTextbox("div.board-tile input", boardTitle);
	}
	
	public void clickCreateBoardButton() {
		objRepo.constructXpathTagFollowedChildElement("button", "Create Board").click();
	}
	
	public String createdBoardHeaderDisplayed() {
		return objRepo.ConstructElementByCss("span.js-board-editing-target").getText();
	}
	
	public void searchboard(String boardTitle) {
		objRepo.enterTextPlaceHolderTextbox("input[name*=search]",boardTitle);
	}
	
	public void clickSearchedboard(String boardTitle) {
		objRepo.constructXpathTagFollowedChildElement("a",boardTitle).click();
	}

	public void CreateNewBoard(String theme, String boardTitle) {
		try {

			clickOnBoard();
			clickOnCreatNewLink();
			Thread.sleep(3000);
			selectTheme(theme);
			addBoardTitle(boardTitle);
			clickCreateBoardButton();
			
			Log.info("Created new trello board using " + theme
					+ " theme and with title " + boardTitle);

		} catch (Exception e) {
			Log.info("From Trello Login Page Thrown Exception: "
					+ e.getMessage());
		}

	}

}
