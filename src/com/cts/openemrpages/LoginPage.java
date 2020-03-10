package com.cts.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class LoginPage 
{
    
	private static By usernameLoc = By.id("authUser");
	private static By passwordLoc = By.id("clearpass");
	private static By languageLoc = By.name("languageChoice");
	private static By loginLoc = By.xpath("//button[@type='submit']");
	private static By errorLoc = By.xpath("//div[@class='alert alert-danger login-failure m-1']");
	
	public static void enterUserName(WebDriver driver,String username)
	{
		
		driver.findElement(usernameLoc).sendKeys(username);
		
	}
	
	public static void enterPassword(WebDriver driver,String password)
	{
		
		driver.findElement(passwordLoc).sendKeys(password);
		
	}
	
	
	  public static void selectLanguage(WebDriver driver,String selectLanguage)
	  {
		  
		  WebElement selEle = driver.findElement(languageLoc); 
		  Select drop = new Select(selEle);
		  drop.selectByVisibleText(selectLanguage); 
		  
	  }
	  
	  public static void clickOnLogin(WebDriver driver)
	  {
		  
		  driver.findElement(loginLoc).click();
		  
	  }
	  
	  public static String errorMessage(WebDriver driver)
	  {
		  WebElement err = driver.findElement(errorLoc);
			String errMsg = err.getText();
			return errMsg;
	  }
	  
	 
	
	
	
	
}
