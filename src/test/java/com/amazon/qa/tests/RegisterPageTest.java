package com.amazon.qa.tests;  
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.qa.base.TestBase;

import com.amazon.qa.pages.RegisterPage;
import com.amazon.qa.pages.SigninPage;

public class RegisterPageTest extends TestBase{
	
 SigninPage signinPage;  
 RegisterPage registerPage;
 private static Logger logger = LogManager.getLogger();
 
	//create constructor of SignInPageTest
	public RegisterPageTest(){
		
		super();	
	}
	
	@BeforeMethod
	public void setUp(){
		initialisation();
		//create objects of SignInPage
		signinPage = new SigninPage();  
		logger.info("Signin message");
		registerPage = new RegisterPage();
		logger.info("Register message");   
	}
	
	@Test(priority = 1)
	public void RegisterTest(){
		
		registerPage.signin(prop.getProperty("name"), prop.getProperty("email"), prop.getProperty("password"), prop.getProperty("pwd")); 
		logger.info("Register account with name, email, password and repassword message");  
	}
	
	@AfterMethod
	public void tearDown(){ 
		driver.quit(); 
		logger.info("Close browser message");  
	}
	
}