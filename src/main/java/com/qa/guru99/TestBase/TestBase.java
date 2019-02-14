package com.qa.guru99.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\Chintu\\workspace\\NextPractice\\src\\main\\java\\com"
					+ "\\qa\\guru99\\Config\\config.properties");
					
			try {
				prop.load(fis);
			} catch (IOException e) {

				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	}
	
	public static void selectBrowserAndEnterUrl(String browserName){
		 if (browserName.equalsIgnoreCase("chrome")){
			 System.setProperty("webdriver.chrome.driver", "F:\\Selenium Drivers\\chromedriver4.exe");
			 driver= new ChromeDriver();
			 
		 }
		 else if (browserName.equalsIgnoreCase("FF")){
			 System.setProperty("webdriver.gecko.driver", "F:\\Selenium Drivers\\geckodriver(1).exe");
			 driver= new FirefoxDriver();
			 
		 }
		 else if(browserName.equalsIgnoreCase("IE")){
			 System.setProperty("webdriver.ie.driver", "F:\\Selenium Drivers\\IEDriverServer_Win32_3.5.0 (1)\\IEDriverServer.exe");
			 driver= new InternetExplorerDriver();
		 }
		 else {
			 System.out.println("Enter Valid Browser Name: Like Chrome or IE or FF");
		 }
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
		 //System.out.println(prop.getProperty("url"));
		 driver.get(prop.getProperty("url"));
		
	}

}
