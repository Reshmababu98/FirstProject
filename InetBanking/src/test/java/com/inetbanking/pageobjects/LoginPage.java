package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
   public LoginPage(WebDriver rdriver)
    {
    	ldriver=rdriver;
    	PageFactory.initElements(rdriver, this);
    }

    
    @FindBy(name="uid")
    WebElement Username;
    
    @FindBy(name="password")
    WebElement Password;
    
    @FindBy(name="btnLogin")
    WebElement Login;
    
    public void SetUsername(String uname)
    {
    	Username.sendKeys(uname);
    }
    
    public void SetPassword(String upass)
    {
    	Password.sendKeys(upass);
    }
    
    public void ClickLgn()
    {
    	Login.click();
    }
    
    
	}


