package com.qa.opencart.base;



import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTests {

	
	WebDriver driver;
	DriverFactory df;
	public Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accountPage;
	//AppConstants appconst;
	
	
	@BeforeTest
	public void setUp() {
		
		df= new DriverFactory();
		prop=df.initProp();
		driver=df.initDriver(prop);
		loginPage =new LoginPage(driver);
		accountPage=new AccountsPage(driver);
		
	}
	
	
	
	
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
