package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.errors.Apperror;
import com.qa.opencart.exceptions.BrowserExecption;

public class DriverFactory {

	 public static String isHighlight;
	WebDriver driver;
     Properties prop;
	 
	 
	 /**
	  * This method is used to initialize the driver
	  * @param browsername
	  * Author Rishesh Jha
	  * @return
	  */
	public WebDriver initDriver(Properties prop) {
         String browserName=prop.getProperty("browser");
		System.out.println("Browser name is : " + browserName);

		switch (browserName.toLowerCase().trim()) {

		case "chrome":

			driver = new ChromeDriver();
          break;
		case "firefox":

			driver = new FirefoxDriver();
			break;
		case "Edge":

			driver = new EdgeDriver();
			break;
		case "safarI":

			driver = new SafariDriver();
			break;
		default:
			System.out.println(Apperror.INVALID_BROWSER_MESG +browserName );
			throw new BrowserExecption("INVALID BROWSER" + browserName);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));

		return driver;
		
	}
	
	/**
	 * This method is used to init the properties from config file
	 * @return
	 */
	
	public Properties initProp() {
	
	prop=new Properties();
	try {
		FileInputStream ip=new FileInputStream("src\\test\\resources\\config\\config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
           return prop;
	}
}