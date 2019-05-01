package com.prit.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eppm.qa.common.PageBase;

public class LoginPage extends PageBase{
	
	public WebDriver webdriver;
	
	public static final String RuleName1="@xpath=//td[3][contains(.,'-')]";
	public static final String RuleName2="@xpath=//td[4][contains(.,'02/11/2018')]";
	public static final String RuleName3="@xpath=//td[6][contains(.,'Populate Cancellation Date with Endorsement Effective Date if blank')]";
	public static final String Okbtn="@xpath=//div[@ng-click='cancel()']";
	public static final String USERNAME="@xpath=//*[@id='identifierId']";
	public static final String Login="@xpath=//*[@id='identifierNext']/content/span";
	By email = By.xpath("emailid");
	By password = By.xpath("password");
	By login = By.xpath("//*[@id='identifierNext']/content/span");
	
		
		
		public WebElement getEmail() {
			return webdriver.findElement(email);
		}

		public WebElement getPassword() {
			return webdriver.findElement(password);
		}

		public void Loginop() {
			//return driver.findElement(login);
		
		System.out.print("Prititdfgh");
		webdriver.findElement(By.xpath("//*[@id='maximenuck243']/div[2]/ul/li[2]/a/span")).click();
		//driver.findElement(login);
		/*	
		click(Login,"User name");
		waitForElementToAppear(USERNAME,10);
		sendKeys(USERNAME, "pritigaikar17@gmal.com" );*/
	}
}



