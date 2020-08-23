package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.resources.HelperUtility;
import com.qa.testbase.TestBase;

public class HomePageTest extends TestBase {
	

	LoginPage loginpage;
	HomePage homepage;
	HelperUtility help;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod()
	public void setUp()
		{
			initilization();
			loginpage=new LoginPage();
			help=new HelperUtility();
			homepage= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
			
		}
	
	@Test(priority = 0)
	public void validateHomePageTitleTest()
	{
		Assert.assertEquals(homepage.validateHomePageTitle(), "CRMPRO");
	}
	
	@Test(priority = 1)
	public void validateUserNameLabelTest()
	{
		help.switchtoFrame();
		Assert.assertTrue(homepage.validateUserNameLabel());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	

}
