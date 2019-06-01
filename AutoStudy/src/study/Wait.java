package study;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;



public class Wait {

	private WebDriver driver;

	private int timeout = 10;

	public Wait(WebDriver driver){
		
		this.driver=driver;
			
		// PageFactory.initElements(driver, this);
		
	}



	public void waitForElementPresent(String locator){
		
		try{
		
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
		
		}catch(Exception e){
	
		}
	
	}



	public void waitForElementIsEnable(String locator){
	
		(new WebDriverWait(driver,timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	
	}
	
	
	
	public void waitFor(long timeout) {
			
		try{
		
		Thread.sleep(timeout);
		
		}catch(InterruptedException e){
		
		e.printStackTrace();
		
		}
	
	}
	
}
