package com.qa.testcases;



import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.testbase.TestBase;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	public LoginPageTest() {
		super();
		}
	
	@BeforeMethod 
	public void setUp()
	
	{
		initilization();
		loginpage=new LoginPage();
	}
	
	@Test(priority = 0)
	public void validateTitleTest()
	{
		String expectedtitle="CRMPRO - CRM software for customer relationship management, sales, and support.";
		String actualtitle=loginpage.validateTitle();
		Assert.assertEquals(actualtitle, expectedtitle);
	}
	
	@Test(priority = 1)
	public void validateLogoTest()
	{
		Assert.assertTrue(loginpage.validateLogo());
	}
	
	@Test(priority = 2)
	public void LoginTest() {
	homepage= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
