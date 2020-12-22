package com.amazon.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class SigninPage extends TestBase {

	
	@FindBy(id = "nav-logo-sprites")
	WebElement logo;
	
	@FindBy(id = "icp-nav-flag icp-nav-flag-gb")
	WebElement flag;
	
	//Amazon Devices: Amazon Devices & Accessories: Fire Tablets, Dash Buttons, Kindle E-readers & More: Amazon.co.uk
	
	@FindBy(id = "nav-link-accountList")
	WebElement ClickSigninlink;

	@FindBy(name = "email")
	WebElement Email;
	
	@FindBy(id = "continue")
	WebElement Continue;

	@FindBy(id = "ap_password")
	WebElement Password;
	
	@FindBy(id = "signInSubmit")
	WebElement SigninBtn;
	
	public SigninPage(){
		PageFactory.initElements(driver, this);   
	}
	
	//Actions
	public String validateSigninPageTitle(){
		return driver.getTitle();   
	}
	
	public boolean validatelogo(){
		return logo.isDisplayed();
	}
	
	public void Signin(String username, String password){ 
		ClickSigninlink.click();
		Email.sendKeys(username);
		Continue.click();
		Password.sendKeys(password);
		SigninBtn.click();
	}
	
}
