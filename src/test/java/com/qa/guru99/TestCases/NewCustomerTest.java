package com.qa.guru99.TestCases;


import java.util.ArrayList;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.guru99.Pages.HomePage;
import com.qa.guru99.Pages.LoginPage;
import com.qa.guru99.Pages.NewCustomerPage;
import com.qa.guru99.TestBase.TestBase;
import com.qa.guru99.Utility.TestUtility;

public class NewCustomerTest extends TestBase{
	
	public static LoginPage loginpage;
	public static HomePage homepage;
	public NewCustomerPage newcustomerpage;
	public static TestUtility testutility;
	
	public NewCustomerTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		selectBrowserAndEnterUrl("chrome");
		loginpage = new LoginPage();
		loginpage.verifyLogin(prop.getProperty("Username"), prop.getProperty("Password"));
		newcustomerpage = new NewCustomerPage();
		newcustomerpage.verifyNavigationtoNewCustomerpage();
		
	}
	
	@Test(priority=7)
	public void verifyCustomerPageTitleTest(){
		String expTitle = "Guru99 Bank New Customer Entry Page";
		
		Assert.assertEquals(newcustomerpage.verifyNewCusPageTitle(), expTitle);
		
	}
	@DataProvider(name="customer data")
	public Object[][] getCustomerData(){
		testutility = new TestUtility();
		return testutility.getExcelData("C:\\Users\\Chintu\\workspace\\NextPractice\\src\\main"
				+ "\\java\\com\\qa\\guru99\\TestData\\Data.xlsx");
	
		
	}
	
	
	@Test(priority= 8, dataProvider="customer data")
	
	public void verifyCustomerCreationTest(String name, String gen, String dateOfBirth, String add, String cty, String ste, 
			String pin, String phoneNo, String emailId, String passWord){
		
	
		ArrayList<String> expData= new ArrayList<String>();
		expData.add(name);
		expData.add(gen);
		expData.add(dateOfBirth);
		expData.add(add);
		expData.add(cty);
		expData.add(ste);
		expData.add(pin);
		expData.add(phoneNo);
		expData.add(emailId);
		
		String actMessage= newcustomerpage.verifyNewCutCreation(name, gen, dateOfBirth, add, cty, ste,pin, phoneNo, emailId, passWord);
		String expMessage= "Customer Registered Successfully!!!";
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertEquals(actMessage, expMessage);
		//Assert.assertEquals(actMessage, expMessage);
		String cusNumber= newcustomerpage.verifyCustomerNumber();
		System.out.println(cusNumber);
		
		ArrayList<String> actData = new ArrayList<String>();
		
		actData= newcustomerpage.verifyCusDetails();
		boolean flag = expData.equals(actData);
		softAssertion.assertTrue(flag);
		softAssertion.assertAll();
		
	}

	@AfterMethod

	public void tearDown() {
		driver.quit();
	}
	
	
}
