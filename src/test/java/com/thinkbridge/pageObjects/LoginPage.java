package com.thinkbridge.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	@FindBy(id="name")
	@CacheLookup
	WebElement txtfullname;
	
		
	@FindBy(id="orgName")
	@CacheLookup
	WebElement txtorgname;
	
	@FindBy(name="email")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(xpath="//span[@class='black-color ng-binding']")
	@CacheLookup
	WebElement cboxagree;
	
	@FindBy(xpath="//button[contains(@type,'submit')]")
	@CacheLookup
	WebElement btnsubmit;
	
	@FindBy(id="identifierId")
	@CacheLookup
	WebElement txtgmailuser;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtgmailpassword;
	

	@FindBy(xpath="//div[@class='VfPpkd-RLmnJb']")
	@CacheLookup
	WebElement linknext;
	
	@FindBy(xpath="//a[contains(text(),'Inbox')]")
	@CacheLookup
	WebElement linkinbox;
	
	@FindBy(name="q")
	@CacheLookup
	WebElement txtsearchbox;
	
	

public void setFullName(String fullname)
{

	txtfullname.sendKeys(fullname);
}

public void setOrgName(String orgname)
{

	txtorgname.sendKeys(orgname);
}

public void setEmail(String email)
{

	txtemail.sendKeys(email);
}

public void selectcheckbox()
{

	cboxagree.click();
}
public void ClickSubmit()
{

	btnsubmit.click();
}
public void setgmailuser(String gmailuser)
{

	txtgmailuser.sendKeys(gmailuser);
}
public void setgmailpassword(String gmailpassword)
{

	txtgmailuser.sendKeys(gmailpassword);
}
public void selectgmailInbox()
{

	linkinbox.click();
}
public void setgmailSearch(String searchtext)
{

	txtsearchbox.sendKeys(searchtext);
}

public void selectNext()
{

	linknext.click();
}
}