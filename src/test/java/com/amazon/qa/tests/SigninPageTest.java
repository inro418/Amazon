package com.amazon.qa.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.HomePage;
import com.amazon.qa.pages.SigninPage;

public class SigninPageTest extends TestBase{
 SigninPage signinPage;  
 HomePage  homePage; 
 private static Logger logger = LogManager.getLogger();
 
	//create constructor of SignInPageTest
	public SigninPageTest(){
		
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		//create objects of SignInPage
		signinPage = new SigninPage();  
		logger.info("Signin message");
		homePage = new HomePage();
		logger.info("Home message");
	}
	
	@Test(priority = 1)
	public void SigninPageTitleTest(){  
		String title = signinPage.validateSigninPageTitle(); 
		logger.info("Page title message");
		Assert.assertEquals(title, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");   
	}
	
	@Test(priority = 2)
	public void logoTest(){
	 signinPage.validatelogo(); 
	 logger.info("Logo message");
		Assert.assertTrue(true);   	
	}
	
	@Test(priority = 3)    
	public void signinPageTest(){
		logger.info("Signin message");
		signinPage.Signin(prop.getProperty("username"),prop.getProperty("password"));   
		
	}
	@AfterMethod
	public void tearDown(){ 
		driver.quit(); 
		logger.info("Close browser message");
	}
	
}