package com.cts.openemrtest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cts.openemrpages.DashBoardpage;
import com.cts.openemrpages.LoginPage;

public class LoginTest 
{

	WebDriver driver;

	@BeforeMethod
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");
	}

	@AfterMethod
	public void endBrowser()
	{
		driver.quit();
	}

	@Test

	public void validCredentialsTest() 
	{

		LoginPage.enterUserName(driver, "admin");
		
		LoginPage.enterPassword(driver, "pass");
		
		LoginPage.selectLanguage(driver, "English (Indian)");

	    LoginPage.clickOnLogin(driver);

		DashBoardpage.waitForPatientElementPresence(driver);

		String actualTitle = DashBoardpage.getCurrentTitle(driver);
		
		String expTitle = "OpenEMR";
		
		Assert.assertEquals(actualTitle, expTitle, "Assertion on validCredentials");

		DashBoardpage.clickOnLogout(driver);

	}

	@Test

	public void invalidCredentialTest()
	{

		LoginPage.enterUserName(driver, "admin123");

		LoginPage.enterPassword(driver, "pass123");

		LoginPage.selectLanguage(driver, "English (Indian)");
		
		 LoginPage.clickOnLogin(driver);
		 
		String errorMessage=  LoginPage.errorMessage(driver);

		String expMsg = "Invalid username or password";
		
 
		Assert.assertEquals(errorMessage, expMsg);

	}

}
