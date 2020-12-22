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

public class HomePageTest extends TestBase{
 SigninPage signinPage;  
 HomePage homePage;
 private static Logger logger = LogManager.getLogger();
 
	//create constructor of SignInPageTest
	public HomePageTest(){
		
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
		signinPage.Signin(prop.getProperty("username"),prop.getProperty("password"));
		logger.info("Signin with valid username and password message");
	}
	
	
	@Test (priority = 1)
	public void verifyHomePageTitle(){
		String Title =  homePage.verifyHomePagePageTitle();
		logger.info("Home page title message");
		Assert.assertEquals(Title, "Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more");   
	}
	
	@Test (priority = 2)
	public void verifyHelloPeterTest(){
		homePage.verifyHelloPeter();
		logger.info("Verify Hello Peter message");
		Assert.assertTrue(true);    
	}
	
	@Test(priority = 3)
	public void verifylogoHomePageTest(){
		 homePage.verifylogo();
		 logger.info("Verify logo message");
		Assert.assertTrue(true);
	}   
	
	@Test(priority = 4)
	public void ClickOnBasket(){
		homePage.ClickOnBasket();
		logger.info("Click basket");
	}
	
	@AfterMethod
	public void tearDown(){ 
		driver.quit(); 
		logger.info("Close browser message");
	}
	
}