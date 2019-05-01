package com.prit.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.eppm.qa.common.PageBase;

public class LoginPage extends PageBase{
	
	public WebDriver driver;
	public static final String USERNAME="@xpath=//*[@id='identifierId']";
	By email = By.xpath("emailid");
	By password = By.xpath("password");
	By login = By.xpath("btnLogin");
	
		
		
		public WebElement getEmail() {
			return driver.findElement(email);
		}

		public WebElement getPassword() {
			return driver.findElement(password);
		}

		public WebElement getLogin() {
			//return driver.findElement(login);
		
		
			
		click(USERNAME,"User name");
		waitForElementToAppear(USERNAME,10);
		
		return null;
	}
}



