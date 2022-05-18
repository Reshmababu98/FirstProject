package com.inetbanking.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass{

	@Test
	public void testone()
	{
		
		
		lo.info("Application opened");
		
		LoginPage l=new LoginPage(driver);
		l.SetUsername(u_name);
		
		lo.info("Username Entered");
	
		l.SetPassword(u_pass);
		l.ClickLgn();
		
		lo.info("password Entered");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			
			lo.info("Title matched and condition passed");
		}
		else
		{
			Assert.assertFalse(false);
			
			lo.info("Title not matched and condition failed");
		}
	}
	
}
