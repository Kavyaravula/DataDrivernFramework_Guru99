package com.qa.guru99.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.TestBase.TestBase;

public class LoginPage extends TestBase {
	@FindBy(name="uid")
	private WebElement strUserName;
	
	@FindBy(name="password")
	private WebElement strPassword;
	
	@FindBy(name="btnLogin")
	private WebElement loginButton;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	public String verifyTitle(){
		
		return driver.getTitle();
		
	}
	
	public void verifyLogin(String userName, String password){
		
		strUserName.sendKeys(userName);
		strPassword.sendKeys(password);
		loginButton.click();
		
	}
	

}
