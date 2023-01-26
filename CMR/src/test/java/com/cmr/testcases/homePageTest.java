package com.cmr.testcases;

import org.cmr.Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cmr.pages.contactsPage;
import com.cmr.pages.homePage;
import com.cmr.pages.loginPage;

public class homePageTest extends baseTest{
	loginPage Hlogin;
	homePage hpage;
	contactsPage Contactpage;
	public homePageTest()
	{
		super();
	}
	//test cases should be independent
	//before each test case launch the browser and login
	//@Test the cases
	//after each test case close the browser
  
	@BeforeMethod
	
	public void setUp()
	{
		launchApp();
		Hlogin=new loginPage();
		hpage=Hlogin.login(prop.getProperty("username"),prop.getProperty("password"));
	}

	@Test
	public void HomePageTitle()
	{
		String expectedTitle=hpage.ValidateHomePageTitle();
	    String ActualTitle="Cogmento CRM";
		Assert.assertEquals(expectedTitle,ActualTitle );// msg will be displayed only after test case is failed
	}
	
	@Test
	
	public void CorrectUserName()
	{
		//TestUtils.Switchtoframe();
		Assert.assertTrue(hpage.CorrectUserName());
	}
	@Test
	public void ContactUserlink()
	{
		Contactpage=hpage.contact();
		
	}

	@AfterMethod
	
	public void tearDown()
	{
		driver.quit();
	}
}
	

