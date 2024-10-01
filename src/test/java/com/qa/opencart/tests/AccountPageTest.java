package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTests;
import com.qa.opencart.constants.AppConstants;


public class AccountPageTest extends BaseTests{
	
	
	@BeforeClass
	public void accSetUp() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	@Test
	public void getAcountPageTitleTest() {
		String title=accountPage.getAccountPageTitle();
		Assert.assertEquals(title, AppConstants.ACCOUNTS_PAGE_TITLE);
		
 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
