package com.thinkbridge.testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.thinkbridge.pageObjects.LoginPage;

public class TC_AccountCreationTest_001 extends BaseClass
{

	@Test
	public void accountCreationTest() throws IOException, Exception 
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		Thread.sleep(5000);


		LoginPage lp=new LoginPage(driver);



		try
		{
			driver.findElement(By.xpath("//div[@placeholder='Choose Language']")).click();
			Thread.sleep(1000);
			List<WebElement> allOptions = driver.findElements(By.xpath("//div[@ng-bind-html='language']"));
			//System.out.println(allOptions.getText());
			int languagecount=allOptions.size();

			if (languagecount==2) {
				Assert.assertTrue(true);
				logger.info("Languages count is matching");
			}
			else {
				Assert.assertTrue(false);
				logger.info("Languages count is not matching");
			}

			for (WebElement option:allOptions) {
				String language = option.getText();
				
				switch(language)
				{
				case "English":
					Assert.assertTrue(true);
					logger.info(language + " : Language is matching");
					break;

				case "Dutch":
					Assert.assertTrue(true);
					logger.info(language + " : Language is matching");
					break;
					
				default:
					Assert.assertTrue(false);
					logger.info(language + " : Language is not matching");
				}

			}


		}
		catch(Exception e) {
			logger.info("language validation is not successful: " + e);
		}
		finally{

			driver.findElement(By.xpath("//div[@id='ui-select-choices-row-1-0']")).click();

			lp.setFullName(fullname);
			logger.info("Full name is entered");
			lp.setOrgName(orgname);
			logger.info("Organisztion name is entered");
			lp.setEmail(useremail);
			logger.info("User email is entered");
			lp.selectcheckbox();
			logger.info("Terms and condition check box is selected");
			lp.ClickSubmit();
			logger.info("clicked on Get started button");

			Thread.sleep(10000);	
			String alertmessagetext=driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/section/div[1]/form/div/span")).getText();


			if (alertmessagetext.equals("A welcome email has been sent. Please check your email."))
			{
				Assert.assertTrue(true);
				logger.info("user account created");
				captureScreen(driver,"accountCreationTest");
			}
			else
			{
				captureScreen(driver,"accountCreationTest");
				Assert.assertTrue(false);
				logger.info("user account not created");
			}
		}

	}
}
