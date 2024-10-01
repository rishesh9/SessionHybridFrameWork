package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utilities.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. Page locators
	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By loginbtn = By.xpath("//input[@class='btn btn-primary']");
	private By ForgottenLink = By.linkText("Forgotten Password");
	private By openCartLogo = By.cssSelector(".img-responsive");

	// 2. Public page Constructor...
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);

	}

	// 3. Public page actions method

	public String getLoginPageTitle() {
		String title=eleUtil.waitForTitleContainsAndReturn(AppConstants.LOGIN_PAGE_TITLE, AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("Login page title is: " +title);
		return title;
	}

	public String getLoginPageURL() {
		String loginURL = driver.getCurrentUrl();
		System.out.println("Login Page URL is: " + loginURL);
		return loginURL;
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(ForgottenLink).isDisplayed();
	}

	public boolean isOpenCartLogoDisplayed() {
		return driver.findElement(openCartLogo).isDisplayed();
	}

	public AccountsPage doLogin(String userName, String userPassword) {
		driver.findElement(username).sendKeys(userName);
		driver.findElement(password).sendKeys(userPassword);
		driver.findElement(loginbtn).click();
		String accPageTitle = driver.getTitle();
		System.out.println("Acc page title: " + accPageTitle);
		return new AccountsPage(driver);
	}

}
