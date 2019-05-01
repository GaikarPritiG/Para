package com.eppm.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class MainDriver {

	

	public static WebDriver driver;

	// loginpage L = new loginpage(); //

	 @BeforeTest
	 public void initialioseBrowser() throws Exception 
	 {
		
		// String chrome=path+"src\\object\\chromedriver.exe";
		
		 System.setProperty("webdriver.chrome.driver","E:\\Automation\\PRITI\\src\\main\\resources\\chromedriver.exe");


	driver = new ChromeDriver();

	Thread.sleep(1000);

	  driver.get("https://mail.google.com/");
	  Thread.sleep(1000);
	  driver.manage().window().maximize();

	 // L.Login(driver);

	  Thread.sleep(4000);


	 }
}
