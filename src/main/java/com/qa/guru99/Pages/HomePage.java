package com.qa.guru99.Pages;


import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.TestBase.TestBase;



public class HomePage extends TestBase{
	
	@FindBy(xpath="//marquee")
	private WebElement welcomeMsg;
	
	@FindBy(xpath="//table[@class='layout']//td[contains(text(),'Manger Id')]")
	private WebElement userIDInfo;
	
	@FindAll({@FindBy(xpath="//ul[@class='menusubnav']//a")})
	private List<WebElement> homepageLinks;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyWelcomeMsg(){
		return welcomeMsg.getText();
		
	}
	
	public String verifyUserDeatils(){
		return userIDInfo.getText();
	
	}
	
	public  HashMap<Integer, String> verifyHomePageLinks(){
		HashMap<Integer,String> links = new HashMap<Integer,String>();
		for (int i=0; i<homepageLinks.size(); i++){
			links.put(i, homepageLinks.get(i).getText());	
		}
		 return links;
	}

}
