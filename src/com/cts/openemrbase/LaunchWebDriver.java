package com.cts.openemrbase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class LaunchWebDriver {
	
public WebDriver driver;
	
	@BeforeMethod
	@Parameters({"browser"})
	public void intitialization(@Optional("ch") String browserName)
	{
		
		
		
		if(browserName.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
		    driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//page load
		driver.get("https://demo.openemr.io/b/openemr/interface/login/login.php?site=default");//60 sec
	}
	
	@AfterMethod
	public void endBrowser()
	{
		//close browser
		driver.quit();
	}
	

}
