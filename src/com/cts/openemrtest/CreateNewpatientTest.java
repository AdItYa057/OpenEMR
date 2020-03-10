package com.cts.openemrtest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.cts.openemrbase.LaunchWebDriver;
import com.cts.openemrpages.CreatePatientPage;
import com.cts.openemrpages.DashBoardpage;
import com.cts.openemrpages.LoginPage;

public class CreateNewpatientTest extends LaunchWebDriver {
	
	
	@Test
	public void createPatient()
	{

       LoginPage.enterUserName(driver, "admin");
		
		LoginPage.enterPassword(driver, "pass");
		
		LoginPage.selectLanguage(driver, "English (Indian)");

	    LoginPage.clickOnLogin(driver);
	    
	    DashBoardpage.clickOnNewSearch(driver);
	
        CreatePatientPage.presenceOfSearchOrAddPatient(driver);
	CreatePatientPage.frames(driver, "pat");
	
	CreatePatientPage.enterName(driver, "yayayayaayyy..", "::)");
	
	CreatePatientPage.enterDob(driver, "1998-02-24");
	
	CreatePatientPage.enterSex(driver, "Female");
	
	CreatePatientPage.createPatient(driver);
	
	CreatePatientPage.closeFrame(driver);
	
	CreatePatientPage.frames(driver, "modalframe");
	
	CreatePatientPage.conformNewPatient(driver);
	
	
	CreatePatientPage.closeFrame(driver);
	
	
	CreatePatientPage.acceptAlert(driver);
	 
	
	CreatePatientPage.closeHappyBirthday(driver);
	
	CreatePatientPage.frames(driver, "pat");
	
	String patient = driver.findElement(By.xpath("//h2[contains(text(),'Medical Record ')]")).getText();
	
	System.out.println(patient);
		                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         
	
	driver.switchTo().defaultContent();
	
	
	
	}	
	
	
}
