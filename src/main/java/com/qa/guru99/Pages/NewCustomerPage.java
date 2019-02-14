package com.qa.guru99.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.guru99.TestBase.TestBase;

public class NewCustomerPage extends TestBase {

	@FindBy(linkText = "New Customer")
	private WebElement linkNewCustomer;

	@FindBy(name = "name")
	private WebElement cusName;

	@FindBy(xpath = "//td//input[@type='radio' and @value='m']")
	private WebElement radioBtnMale;

	@FindBy(xpath = "//td//input[@type='radio' and @value='f']")
	private WebElement radioBtnFemale;

	@FindBy(name = "dob")
	private WebElement cusDOB;

	@FindBy(name = "addr")
	private WebElement cusAddress;

	@FindBy(name = "city")
	private WebElement cusCity;

	@FindBy(name = "state")
	private WebElement cusState;

	@FindBy(name = "pinno")
	private WebElement cusPinNo;

	@FindBy(name = "telephoneno")
	private WebElement cusMobileNo;

	@FindBy(name = "emailid")
	private WebElement cusEmail;

	@FindBy(name = "password")
	private WebElement cusPassword;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement cusSubmitBtn;

	@FindBy(xpath = "//p[contains(text(),'Customer Registered Successfully!!!')]")
	private WebElement newCustomerCreatedMsg;

	@FindBy(xpath = "//table[@name='customer']//td[contains(text(),'Customer ID')]//following-sibling::td")
	private WebElement customerID;

	@FindBy(xpath = "//table[@name='customer']//td//following-sibling::td")
	private List<WebElement> customerDetails;

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public void verifyNavigationtoNewCustomerpage() {
		linkNewCustomer.click();
	}

	public String verifyNewCusPageTitle() {

		String actTitle = driver.getTitle();
		return actTitle;

	}

	public String verifyNewCutCreation(String name, String cusGender, String dob, String address, String city,
			String state, String pin, String mobile, String email, String password) {
		cusName.sendKeys(name);
		if (cusGender.equalsIgnoreCase("female")) {
			radioBtnFemale.click();
		} else {
			radioBtnMale.click();
		}

		cusDOB.sendKeys(dob);
		cusAddress.sendKeys(address);
		cusCity.sendKeys(city);
		cusState.sendKeys(state);
		cusPinNo.sendKeys(pin);
		cusMobileNo.sendKeys(mobile);
		cusEmail.sendKeys(email);
		cusPassword.sendKeys(password);
		cusSubmitBtn.click();
		String customerRegistration = newCustomerCreatedMsg.getText();
		return customerRegistration;

	}

	public String verifyCustomerNumber() {
		return customerID.getText();

	}

	public ArrayList<String> verifyCusDetails() {
		ArrayList<String> actualCusDetails = new ArrayList<String>();

		for (int i = 1; i < customerDetails.size(); i++) {
			if ((customerDetails.get(i).getText()).contains("-")) {
				String date = customerDetails.get(i).getText();
				String[] date1 = date.split("-");
				String str = "";
				for (int j = (date1.length - 1); j >= 0; j--) {

					str = str + date1[j];
				}
				actualCusDetails.add(str);

			} else {
				actualCusDetails.add(customerDetails.get(i).getText());
			}
		}

		return actualCusDetails;

	}

}