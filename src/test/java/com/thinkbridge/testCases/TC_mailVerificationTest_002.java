package com.thinkbridge.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thinkbridge.pageObjects.LoginPage;

public class TC_mailVerificationTest_002 extends BaseClass
{

	@Test
	public void mailVerificationTest() throws IOException, Exception 
	{
		driver.get(gmailurl);
		logger.info("gmail url is opened");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		LoginPage lp=new LoginPage(driver);
		lp.setgmailuser(gmailusername);
		logger.info("User name is entered");
		Thread.sleep(5000);
		
		lp.selectNext();
		logger.info("next link is clicked");
		Thread.sleep(5000);
		
		lp.setgmailpassword(gmailpassword);
		logger.info("Password name is entered");
		Thread.sleep(5000);
		
		lp.selectgmailInbox();
		logger.info("Inbox link is clicked");
		Thread.sleep(5000);
		
		lp.setgmailSearch("JabaTalks");
		logger.info("Search text is entered");
		Thread.sleep(5000);
		
		
	boolean mailnotification=driver.findElement(By.xpath("//span[@name='JabaTalks Developme.']")).isDisplayed();
		
	
	if (mailnotification)
		{
			Assert.assertTrue(true);
			logger.info("Notification mail is received");
			captureScreen(driver,"mailVerificationTest");
		}
		else
		{
			captureScreen(driver,"mailVerificationTest");
			Assert.assertTrue(false);
			logger.info("notification mail is not received");
		}
	}

}
