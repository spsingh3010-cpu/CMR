package org.cmr.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.cmr.utils.WebEventListener;
import com.cmr.utils.testUtils;


public class baseTest {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public baseTest() 
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\Supriya\\eclipse-workspace\\CMR\\src"
					+ "\\main\\java\\org\\cmr\\config\\coniguration.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void launchApp()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Supriya\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
		 driver=new ChromeDriver();
		}
		
		else if(browserName.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Supriya\\Downloads\\chromedriver_win32 (3)\\geckodriver.exe");
		    driver=new FirefoxDriver();
		}
		
		e_driver=new EventFiringWebDriver(driver);
		eventListener=new WebEventListener();
		e_driver.register(eventListener);
		driver=e_driver;
		
		 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(testUtils.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(testUtils.IMPLICIT_WAIT_TIMEOUT, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	}
}
