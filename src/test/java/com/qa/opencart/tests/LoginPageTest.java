package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTests;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.pages.AccountsPage;

public class LoginPageTest extends BaseTests{
	
	
	
	@Test
	public void getloginPageTitleTest() {
		String actTitle= loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void getloginPageURLTest() {
		String actURL= loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL));
	}
	
	@Test
	public void forgotPwdLinkExistTest() {
		boolean flag=loginPage.isForgotPwdLinkExist();
		Assert.assertTrue(flag, "True");
	}
	
	@Test
	public void logoExistTest() {
		//boolean flag=loginPage.isForgotPwdLinkExist();
		Assert.assertTrue(loginPage.isOpenCartLogoDisplayed());
	}
	
	@Test(priority=Integer.MAX_VALUE)
	public void loginTest() {
	AccountsPage accountPageTitle=loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	Assert.assertEquals(accountPageTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	
	

}
