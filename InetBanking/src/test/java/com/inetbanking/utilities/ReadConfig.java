package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;

	public ReadConfig()
	
	{
		File src= new File("C:\\Users\\reshma\\eclipse-workspace\\InetBanking\\Configurations\\Config.properties");
		try
		{
			FileInputStream f=new FileInputStream(src);
			pro=new Properties();
			pro.load(f);
		}
		catch(Exception e)
		{
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String Url=pro.getProperty(("url_app"));
		return Url;
		
	}
	
	public String getUserName()
	{
		String Usname=pro.getProperty("u_name");
		return Usname;
		
	}
	
	
	public String getPassword()
	{
		String Upass=pro.getProperty("u_pass");
		return Upass;
		
	}
	
	public String getChromePath()
	{
		String Cpath=pro.getProperty("chromepath");
		return Cpath;
		
	}
	
	public String getiePath()
	{
		String ipath=pro.getProperty("iepath");
		return ipath;
		
	}
}
