package com.eppm.qa.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class MainDriver {

	
package com.eppm.qa.common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.eppm.qa.pageobject.LoginPage;

public class MainDriver {

	LoginPage loginPage = new LoginPage();
	public static WebDriver webdriver;
	
	public static void main(String[] args) {
		MainDriver m = new MainDriver();
		try {
			m.initialioseBrowser();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void initialioseBrowser() throws Exception {

	    System.setProperty("webdriver.chrome.driver","D:\\Supriya\\workspace\\EPPMProject\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();
		Thread.sleep(1000);
		webdriver.get("http://10.1.2.15:9000/login");
		Thread.sleep(1000);
		webdriver.manage().window().maximize();
		Thread.sleep(4000);
		//loginPage.doLogin("mayanks", "mayanks");

	}

	@AfterSuite
	public void closeBrowser() {

		webdriver.quit();

	}
}

}
