package com.cmr.pages;

import org.cmr.Base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class contactsPage extends baseTest{
	
@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]")
WebElement ContactPageLink;

@FindBy(name="first_name")
WebElement firstName;

@FindBy(name="last_name")
WebElement lastName;

@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/button[2]")
WebElement save;


@FindBy(xpath="//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[2]/div[2]/div[1]/div[1]/input[1]")
WebElement company;


   public contactsPage()
   {
	 PageFactory.initElements(driver,this);
   }
    public boolean ValidateContactLabel()
    {
    	return ContactPageLink.isDisplayed();
    }
    
//    public void SelectContact(String name)
//    {
//    	driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/label[1]")).click();
//    }
    public void createNewContact(String name, String ltname, String compny)
    {
//    	Select select=new Select(driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[2]/div[2]/div[1]/div[2]/form[1]/div[5]/div[1]/div[1]/div[1]")));
//    	select.selectByVisibleText(status);
    	firstName.sendKeys(name);
    	lastName.sendKeys(ltname);
    	company.sendKeys(compny);
    	save.click();
    }
    
}
