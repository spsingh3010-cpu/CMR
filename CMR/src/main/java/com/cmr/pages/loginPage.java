package com.cmr.pages;

import org.cmr.Base.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage extends baseTest{
	
@FindBy(name="email")
WebElement email;

@FindBy(name="password")
WebElement password;

@FindBy(xpath="//div[contains(text(),'Login')]")
WebElement  loginBtn;

@FindBy(linkText="Sign Up")
WebElement SignUp;

@FindBy(className="brand-name")
WebElement logo;

@FindBy(xpath="//span[contains(text(),'Log In')]")
WebElement logIn;

public loginPage()
{
   PageFactory.initElements(driver, this);	//Using the initElements method, one can initialize all the web elements located by @FindBy annotation
   }

//WebElement  logIn=driver.findElement(By.linkText("Login"));
//WebElement email=driver.findElement(By.name("email"));
//WebElement password=driver.findElement(By.name("password"));
//WebElement loginBtn =driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
//WebElement SignUp=driver.findElement(By.linkText("Sign Up"));
//WebElement logo=driver.findElement(By.className("img-responsive"));
//

public String ValidateTitle()
{
	return driver.getTitle();
}

public boolean logoImg()
{
	return logo.isDisplayed();
}

public homePage login(String uname,String upassword) {
	
    logIn.click();
	email.sendKeys(uname);
	password.sendKeys(upassword);
	loginBtn.click();
	return new homePage();
}





	}
