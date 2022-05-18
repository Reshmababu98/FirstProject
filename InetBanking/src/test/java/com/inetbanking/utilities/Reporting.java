package com.inetbanking.utilities;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.TestListenerAdapter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	public ExtentTest logger;
	public ExtentHtmlReporter HtmlReporter;
	public ExtentReports extent;
	
	public void onStart(ITestContext testcontext)
	{
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Test_Report"+timestamp+".html";
		HtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test_output/"+repname);
		HtmlReporter.loadConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
	    extent=new ExtentReports();
		
		extent.attachReporter(HtmlReporter);
		extent.setSystemInfo("Hostname", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "reshma");
		
		HtmlReporter.config().setReportName("Functional Test Report");
		HtmlReporter.config().setDocumentTitle("InetBanking Project");
		HtmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		HtmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onTestSuccess(ITestContext testcontext)
	{
		logger=extent.createTest(testcontext.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(testcontext.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestContext testcontext)
	{
		logger=extent.createTest(testcontext.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(testcontext.getName(), ExtentColor.RED));
	}
	
	public void onTestSkipped(ITestContext testcontext)
	{
		logger=extent.createTest(testcontext.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(testcontext.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}


}
