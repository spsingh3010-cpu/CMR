package com.cmr.pages;

import java.awt.Desktop.Action;

import org.cmr.Base.baseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class homePage extends baseTest{
	
	contactsPage ctpage;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	@CacheLookup                 //It is used to create cache so the element which is not likely to be change frequently should use this annotation
	                             //It improves script performance
	WebElement contactlink;
	
	@FindBy(xpath="//body/div[@id='ui']/div[1]/div[1]/div[5]/a[1]")
	WebElement dealslink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasklink;
	
	@FindBy(xpath="//span[contains(text(),'Singh')]")
	WebElement userlink;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/button[1]/i[1]")
	WebElement AddContact;
	
	public homePage()
	{
		PageFactory.initElements(driver, this);
	}
	@Test
	
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean CorrectUserName()
	{
		return userlink.isDisplayed();
	}
	 public contactsPage contact()
	 {
		 contactlink.click();
		 return new contactsPage();
	 }
	 
	 public dealsPage deals()
	 {
		 dealslink.click();
		 return new dealsPage();
	 }
	 
	 public TasksPage task()
	 {
		 tasklink.click();
		 return new TasksPage();
	 }
	 public void NewContactPage()
	 {
		 Actions action=new Actions(driver);// action listener is uses for mouse movement drag n drop/click
		 action.moveToElement(contactlink).build().perform();// whenever we are action class we have to use build() n perform()
		 AddContact.click();
	 }

}
