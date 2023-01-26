package com.cmr.testcases;

import org.cmr.Base.baseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cmr.pages.contactsPage;
import com.cmr.pages.homePage;
import com.cmr.pages.loginPage;
import com.cmr.utils.testUtils;

public class ContactPageTest extends baseTest {
	loginPage contactLoginPage;
	homePage homeTest;
	contactsPage contactpgObj;
	String sheetname="Sheet1";
	
    public ContactPageTest()
    {
    	super();
    }
    
    @BeforeMethod
    public void SetUp() throws InterruptedException {
    	launchApp();
        contactLoginPage=new loginPage();
        contactpgObj=new contactsPage();
    	homeTest=contactLoginPage.login(prop.getProperty("username"),prop.getProperty("password"));
        contactpgObj=homeTest.contact();
    	Thread.sleep(3000);
    	
    }
    @Test(priority=1)
    public void ValidateContactLabelTest()
    {
    	Assert.assertTrue(contactpgObj.ValidateContactLabel(), "contact label is missing");
    }
    
//    @Test(priority=2)
//    public void ValidateSelectcontact()
//    {
//    	contactpgObj.SelectContact("ABC XYZ");
//
  //  }
 //   @Test(priority=3)
    
//    public void SelectMulitpleContact()
//    {
//    	
//    	contactpgObj.SelectContact("Demo User");
//    	contactpgObj.SelectContact("ABC XYZ");
//
//    }
    
    @DataProvider
    
    public Object[][] getCMRTestData()
    {
    	Object data[][]=testUtils.getTestData(sheetname);
    	return data;
    }
    
    @Test(dataProvider="getCMRTestData")
    
    public void CreateContact(String ftname, String ltname, String comp) throws InterruptedException
    {
    	homeTest.NewContactPage();
    	//contactpgObj.createNewContact("Joe", "Bing");
    	contactpgObj.createNewContact(ftname,ltname,comp);
    	//Thread.sleep(3000);
    }
    @AfterMethod
     public void tearDown()
     {
    	driver.quit();
     }
}
