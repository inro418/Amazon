package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class RegisterPage extends TestBase{  
	
	    //Page Factory - OR
		
	    @FindBy(xpath = "(//*[text()='Start here.'])[2]")
	    WebElement ClickStartHere; 

	    @FindBy(id= "createAccountSubmit")
	    WebElement ClickCreateAccount; 

	    @FindBy(name = "customerName")
	    WebElement Name; 
	    
	    @FindBy(name = "email")
	    WebElement Email;  
	    
	    @FindBy(name = "password")
	    WebElement Password;
	    
	    @FindBy(name ="passwordCheck")
	    WebElement ReEnterPassword;
	    
	    @FindBy(xpath ="//input[@type='submit']")
	    WebElement ClickCreatYourAccount;
	    
	    @FindBy(xpath = "//*[text()='Sign Out']")
	    WebElement ClickSignOut;
	    
		//create constructor of this and initialised the page objects
		public RegisterPage(){
			PageFactory.initElements(driver, this);  
		}
		//Actions 
		public RegisterPage signin(String name, String email, String password, String pawd){     
			ClickStartHere.click();
			Name.sendKeys(name); 
			Email.sendKeys(email);  
			Password.sendKeys(password); 
			ReEnterPassword.sendKeys(pawd);
			ClickCreatYourAccount.click();
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();  
			ClickSignOut.click();
			return new RegisterPage();    
			
		}
}