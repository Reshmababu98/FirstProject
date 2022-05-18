package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;


public class BaseClass {
     
	ReadConfig rc=new ReadConfig();
	public String url_app=rc.getApplicationUrl();
	public String u_name=rc.getUserName();
	public String u_pass=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger lo;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String s)
	{
		
		
		lo=Logger.getLogger(BaseClass.class.getName());
		//DOMConfigurator.configure("log4j.xml");
		PropertyConfigurator.configure("log4j.properties");
		
		if(s.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromePath());
		driver=new ChromeDriver();
		}
		else if(s.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getiePath());
			driver=new InternetExplorerDriver();
		}
		
		driver.get(url_app);
	}
	
	@AfterClass
	public void droptest()
	{
		driver.quit();
	}
}
