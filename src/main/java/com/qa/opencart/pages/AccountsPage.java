package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;

public class AccountsPage {
     
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By headers =By.cssSelector("div.col-sm-9 h2");
	private By search =By.name("search");
	private By SearchClick=By.cssSelector("span button");
	
	
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getAccountPageTitle() {
		String title=eleUtil.getPageTitleIs(AppConstants.ACCOUNTS_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title is: " +title);
		return title;
		
		
	}
	
	public void getAccountPageHeaders() {
		
	List<String> list=eleUtil.waitforElementsVisibleAndIterateHeaders(headers, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		
	}
	
	
	public void SearchItem(String item) {
		eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doClick(SearchClick);
	}
	
	
	
	
	
	
}
