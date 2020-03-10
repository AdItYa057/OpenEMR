package com.cts.openemrpages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatePatientPage {
	
	private static By searchOrPatientloc = By.xpath("//h2[text()='Search or Add Patient']");
	private static By firstNameLoc = By.xpath("//input[@id='form_fname']");
	private static By lastNameLoc = By.id("form_lname");
	private static By dobLoc = By.name("form_DOB");
	private static By sexLoc = By.name("form_sex");
	private static By createLoc = By.name("create");
	private static By conformPatient = By.xpath("//input[@value='Confirm Create New Patient']");
	private static By happyBirthDayLoc = By.xpath("//div[@class='closeDlgIframe']");
	

	public static void presenceOfSearchOrAddPatient(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver,50);
		 wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchOrPatientloc));
		
		    
	}
	
	public static void frames(WebDriver driver,String frameName)
	{
		driver.switchTo().frame(frameName);
	}
	
	public static void enterName(WebDriver driver,String firstname, String lastname)
	{
		driver.findElement(firstNameLoc).sendKeys(firstname);
		
		driver.findElement(lastNameLoc).sendKeys(lastname);
	}
	
	public static void enterDob(WebDriver driver, String dob)
	{
		driver.findElement(dobLoc).sendKeys(dob);
	}
	
	public static void enterSex(WebDriver driver,String sex)
	{
		WebElement genEle = driver.findElement(sexLoc);
		Select gen = new Select(genEle);
		gen.selectByVisibleText(sex);
		
	}
	
	public static void createPatient(WebDriver driver)
	{
		driver.findElement(createLoc).click();
	}
	
	public static void closeFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	
	/*
	 * public static void otherFrame(WebDriver driver, String otherframename) {
	 * driver.switchTo().frame(otherframename); }
	 */
	
	
	public static void conformNewPatient(WebDriver driver)
	{
		driver.findElement(conformPatient).click();
	}
	
	public static void acceptAlert(WebDriver driver)
	{
		 WebDriverWait wait = new WebDriverWait(driver,50);
		 wait.until(ExpectedConditions.alertIsPresent());
		 
			
		   Alert alertbox =driver.switchTo().alert();
			String s = alertbox.getText();
			System.out.println(s);
			
			alertbox.accept();
	}
	
	public static void closeHappyBirthday(WebDriver driver)
	{
		driver.findElement(happyBirthDayLoc).click();
	}
	
}
