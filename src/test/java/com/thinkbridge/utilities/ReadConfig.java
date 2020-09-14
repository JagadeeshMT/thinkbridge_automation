package com.thinkbridge.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	
	Properties pro;
	
	public ReadConfig()
	
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			} catch (Exception e) {
				System.out.println("Exceptio is "+ e.getMessage());
			}
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getFullname()
	{
		String fullname=pro.getProperty("fullname");
		return fullname;	
	}
	
	public String getOrganizationname()
	{
		String orgname=pro.getProperty("organizationname");
		return orgname;	
	}
	
	public String getUseremail()
	{
		String useremail=pro.getProperty("useremail");
		return useremail;	
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;	
	}
	
	public String getIEPath()
	{
		String iepath=pro.getProperty("iepath");
		return iepath;	
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;	
	}
	
	public String getgmailurl()
	{
		String gmailurl=pro.getProperty("gmailurl");
		return gmailurl;
	}
	
	public String getgmailusername()
	{
		String gmailusername=pro.getProperty("gmailusername");
		return gmailusername;
	}
	
	public String getgmailpassword()
	{
		String gmailpassword=pro.getProperty("gmailpassword");
		return gmailpassword;
	}
	
	
	
}
