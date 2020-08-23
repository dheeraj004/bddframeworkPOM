package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement button;
	
	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signuplink;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateLogo()
	{
		return crmlogo.isDisplayed();
	}
	
	public String validateTitle()
	{
		return driver.getTitle();
	}
	
	public HomePage Login(String un,String pass) {
		username.sendKeys(un);
		password.sendKeys(pass);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", button);
		
		return new HomePage();
		
		
	}
	
	


}
