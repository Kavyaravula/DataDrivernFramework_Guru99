package com.qa.guru99.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.Pages.LoginPage;
import com.qa.guru99.TestBase.TestBase;

public class LoginTest extends TestBase {

	public static LoginPage loginpage;
	
	public LoginTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		selectBrowserAndEnterUrl("chrome");
		loginpage = new LoginPage();
	}
	
	@Test (priority=1)
	
	public void verifyTitleTest(){
		
		String actTitle= loginpage.verifyTitle();
		String expTitle = "Guru99 Bank Home Page";
		Assert.assertEquals(actTitle, expTitle);
	}
	
	@Test (priority=2)
	
	public void verifyLoginTest(){
		loginpage.verifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		
	}
	
@AfterMethod
	
	public void tearDown(){
		driver.quit();
	}
}
