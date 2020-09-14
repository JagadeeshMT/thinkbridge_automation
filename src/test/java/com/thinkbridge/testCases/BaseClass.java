package com.thinkbridge.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.thinkbridge.utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	

	public String baseURL=readconfig.getApplicationURL();
	public String fullname=readconfig.getFullname();
	public String orgname=readconfig.getOrganizationname();
	public String useremail=readconfig.getUseremail();
	public String gmailusername=readconfig.getgmailusername();
	public String gmailpassword=readconfig.getgmailpassword();
	public String gmailurl=readconfig.getgmailurl();
	
	
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws Exception
	{
		logger =logger.getLogger("thinkbridge");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
		}
		else if (br.equals("firefox")) {
			System.setProperty("webdriver.geko.driver",readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
			}
		else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomstring()
	{
		String generatedalphastring=RandomStringUtils.randomAlphabetic(8);
		return (generatedalphastring);
	}
	
	public String randomnum()
	{
		String generatednumstring=RandomStringUtils.randomNumeric(4);
		return (generatednumstring);
	}
	
}