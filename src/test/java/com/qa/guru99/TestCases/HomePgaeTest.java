package com.qa.guru99.TestCases;




import java.util.HashMap;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.guru99.Pages.HomePage;
import com.qa.guru99.Pages.LoginPage;
import com.qa.guru99.TestBase.TestBase;

public class HomePgaeTest extends TestBase {

	public static LoginPage loginpage;
	public static HomePage homepage;

	public HomePgaeTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		selectBrowserAndEnterUrl("chrome");
		loginpage = new LoginPage();
		loginpage.verifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		homepage = new HomePage();
	}

	@Test(priority = 3)
	public void veryHomepageTitleTest() {

		String actTitle = homepage.verifyHomePageTitle();
		String expTitle = "Guru99 Bank Manager HomePage";
		Assert.assertEquals(actTitle, expTitle);

	}

	@Test(priority = 4)
	public void verifyWelcomeMsgTest() {
		String actWelcomeMsg = homepage.verifyWelcomeMsg();
		String expWelcomeMsg = "Welcome To Manager's Page of Guru99 Bank";
		Assert.assertEquals(actWelcomeMsg, expWelcomeMsg);

	}

	@Test(priority = 5)

	public void verifyUserInfoTest() {
		String actUserDetails = homepage.verifyUserDeatils();
		String expUserDetails = "Manger Id : " + prop.getProperty("Username");
		Assert.assertEquals(actUserDetails, expUserDetails);
	}

	@Test(priority = 6)

	public void verifyHomePageLinksTest() {
		HashMap<Integer,String> actLinks = new HashMap<Integer,String>();
		actLinks = homepage.verifyHomePageLinks();
		String[] arrayExpLinks = { "Manager","New Customer","Edit Customer","Delete Customer","New Account",
				"Edit Account", "Delete Account", "Deposit", "Withdrawal", "Fund Transfer", "Change Password",
				"Balance Enquiry","Mini Statement","Customised Statement","Log out"};

		HashMap<Integer,String> expLinksList = new HashMap<Integer,String>();
		
		for (int i=0; i<arrayExpLinks.length;i++){
			expLinksList.put(i, arrayExpLinks[i]);	
			
		}		
		
		boolean flag=  actLinks.equals(expLinksList);
		Assert.assertTrue(flag);
	
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}

}
