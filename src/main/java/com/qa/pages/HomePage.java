package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.testbase.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement usernamelabel;
	
	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement contactslink;
	
	
	@FindBy(xpath = "//td[contains(text(),'Deals')]")
	WebElement dealslink;
	

	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	
	@FindBy(xpath = "//td[contains(text(),'Tasks')]")
	WebElement taskslink;
	
	public  HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateUserNameLabel()
	{
		return usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsPage()
	{
		contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsPage()
	{
		dealslink.click();
		return new DealsPage();
	}
	
	public TasksPage clickonTasksPagePage()
	{
		taskslink.click();
		return new TasksPage();
	}

	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newContactLink.click();
		
	}

}
