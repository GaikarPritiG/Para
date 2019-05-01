package com.eppm.qa.common;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	public WebDriver webdriver=null;
	GlobalVariables g =new GlobalVariables();
	public void click(String locator,String ObjectName) 
	{
		//waitForSpinnerDisable();
		try
		{
			waitForPageLoad();
			WebElement element = findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(webdriver, 60);
			//wait.until(ExpectedConditions.elementToBeClickable(element));
			//wait.until(angularHasFinishedProcessing());
			if(g.getBrowser().trim().equalsIgnoreCase("IE"))
			{
				JavascriptExecutor js = (JavascriptExecutor) webdriver;
				((JavascriptExecutor)webdriver).executeScript("arguments[0].click();",  element);
				//Report.LogInfo("click","<b><i>"+ObjectName +"</i></b> - Is Clicked Successfully", "INFO");	

			}
			else
			{
				element.click();
				//Report.LogInfo("click","<b><i>"+ObjectName +"</i></b> - Is Clicked Successfully", "INFO");
			}

		}catch(Exception e)
		{
			//Report.LogInfo("click","<font color=red"+ObjectName +" - Is not Present on Screen</font>", "INFO");
			refreshPage();
		}
	}

		public void refreshPage()
		{	
			webdriver.navigate().refresh();	
			//waitForSpinnerDisable();
			waitForPageLoad();
		
	}
		public void waitForPageLoad()
		{
			String pageLoadStatus = null;
			JavascriptExecutor js = (JavascriptExecutor)webdriver;
			do {
				js = (JavascriptExecutor) webdriver;
				pageLoadStatus = (String)js.executeScript("return document.readyState");
			} while ( !pageLoadStatus.equals("complete") );
		}
	public void goBack()
	{
		webdriver.navigate().back();
		
		
	}
	
	protected WebElement findWebElement(String locator){

		webdriver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);

		WebElement webElement = null;
		if(!isBlankOrNull(locator)){
			try {

				//Report.LogInfo("findWebElement","Web element '"+locator+ "' is finding", "INFO");
				if(locator.startsWith("@id")){ // e.g @id='elementID'
					// Find the text input element by its id
					webElement = TestBase.webdriver.findElement(By.id(removeStart(locator, "@id=")));

				}else if(locator.startsWith("@name")){
					// Find the text input element by its name
					webElement = TestBase.webdriver.findElement(By.name(removeStart(locator, "@name=")));
				}else if(locator.startsWith("@linkText")){
					// Find the text input element by its link text
					webElement = TestBase.webdriver.findElement(By.linkText(removeStart(locator, "@linkText=")));
				}else if(locator.startsWith("@partialLinkText")){
					// Find the text input element by its link text
					webElement = TestBase.webdriver.findElement(By.partialLinkText(removeStart(locator, "@partialLinkText=")));
				}else if(locator.startsWith("@xpath")){
					//using XPATH locator.
					webElement = TestBase.webdriver.findElement(By.xpath(removeStart(locator, "@xpath="))); 
				}else if(locator.startsWith("@css")){
					// Find the text input element by its css locator
					webElement = TestBase.webdriver.findElement(By.cssSelector(removeStart(locator, "@css=")));
				}else if(locator.startsWith("@className")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(By.className(removeStart(locator, "@className=")));
				}
				else if(locator.startsWith("@tagName")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(By.className(removeStart(locator, "@tagName=")));
				}
				/*else if(locator.startsWith("@binding")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.binding(removeStart(locator, "@binding=")));
				}
				else if(locator.startsWith("@buttonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.buttonText(removeStart(locator, "@buttonText=")));
				}else if(locator.startsWith("@input")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.input(removeStart(locator, "@input=")));
				}else if(locator.startsWith("@model")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.model(removeStart(locator, "@model=")));
				}else if(locator.startsWith("@options")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.options(removeStart(locator, "@options=")));
				}else if(locator.startsWith("@partialButtonText")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.partialButtonText(removeStart(locator, "@partialButtonText=")));
				}else if(locator.startsWith("@repeater")){
					// Find the text input element by its class Name
					webElement = TestBase.webdriver.findElement(NgBy.repeater(removeStart(locator, "@repeater=")));
				}*/

			} catch(NoSuchElementException e) { 
				//Report.LogInfo("findWebElement", "Exception encountered while trying to find element [locator='"+locator+"']: "+e.getMessage(), "FAIL");
			} catch(RuntimeException e) { 
				//Report.LogInfo("findWebElement", "Element does not exist [locator='"+locator+"']: "+e.getMessage(), "FAIL");	
				((JavascriptExecutor)webdriver).executeScript("arguments[0].style.border='3px solid red'", webElement);
			}
		}
		((JavascriptExecutor)webdriver).executeScript("arguments[0].style.border='3px solid green'", webElement);

		//log.trace("Exiting method findWebElement");
		return webElement;
	}
	public static String removeStart(String str, String remove)
	{
		//log.trace((new StringBuilder()).append("Entering method removeStart [str=").append(str).append(", remove=").append(remove).append("]").toString());
		String returnStr = "";
		if(isBlankOrNull(str) || isBlankOrNull(remove))
		{
			//log.debug((new StringBuilder()).append("Returned value is [str='").append(str).append("']").toString());
			returnStr = str;
		}
		if(str.startsWith(remove))
			returnStr = str.substring(remove.length());
		//log.trace((new StringBuilder()).append("Exiting method removeStart [returnStr='").append(returnStr).append("']").toString());
		return returnStr;


	}
	public static boolean isBlankOrNull(String str)
	{
		//log.debug((new StringBuilder()).append("Inside isBlankOrNull [str=").append(str).append("]").toString());
		return str == null || str.trim().length() == 0;
	}
	public void waitForElementToAppear(String locator,int waitTimeInSeconds)
	{
		
		for(int i=0;i<waitTimeInSeconds;i++)
		{
			if(isVisible3(locator))
			{
				break;
			}
			else
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		}}
		
		public boolean isVisible3(String locator) throws NoSuchElementException {
			//log.trace("Entering method isVisible [locator='"+locator+"']");
			//waitForSpinnerDisable();
			boolean result = true;
			/*WebElement element=findWebElement(locator);
			WebDriverWait wait = new WebDriverWait(webDriver, 20);
			//wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));*/
			if(!isBlankOrNull(locator)){
				try {

					result=findWebElement(locator).isDisplayed();

				} catch (Exception ignored) {
					result= false;
					//throw e;
				} 
			}
			else{
				result = false;
			}
			//info("Exiting method isVisible returning result="+result);
			//log.trace("Exiting method isVisible returning result="+result);
			return result;
		}


}
