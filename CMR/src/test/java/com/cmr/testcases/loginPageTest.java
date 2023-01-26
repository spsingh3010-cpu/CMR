package com.cmr.testcases;

import org.cmr.Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmr.pages.homePage;
import com.cmr.pages.loginPage;

public class loginPageTest extends baseTest {
	homePage HomePage;
	
	loginPage loginpg;
	
	public loginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp()
	{
	launchApp();
	loginpg=new loginPage();
	}
	
	@Test(priority=1)
	
	public void loginPageTitle()
	{
		String ActualTitle=loginpg.ValidateTitle();
		String ExcpectedTitle="Free CRM Software for every business";
		Assert.assertEquals(ActualTitle,ExcpectedTitle,"failed");
	}
	
	@Test(priority=2)
	
	public void logo()
	{
		boolean flag=loginpg.logoImg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void Validatelogin()
	{
		HomePage=loginpg.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
}
