package com.cts.openemrpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardpage {
	
	private static By patientLoc = By.xpath("//div[text()='Patient/Client']");
	private static By mouseLoc = By.xpath("//div[@class='menuLabel userSection']");
	private static By logoutLoc = By.xpath("//li[text()='Logout']");
	private static By patientOrClientLoc = By.xpath("//div[text()='Patient/Client']");
	private static By newSearchLoc = By.xpath("//div[text()='New/Search']");
	
	public static void waitForPatientElementPresence(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(patientLoc));
		
	}
	
	public static String getCurrentTitle(WebDriver driver)
	{
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public static void clickOnLogout(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(mouseLoc)).build().perform();

		driver.findElement(logoutLoc).click();
	}
	
	public static void clickOnNewSearch(WebDriver driver)
	{
		WebElement patEle = driver.findElement(patientOrClientLoc);
		
		Actions action = new Actions(driver);
		
		action.moveToElement(patEle).build().perform();
		
		driver.findElement(newSearchLoc).click();
	}
	

}
