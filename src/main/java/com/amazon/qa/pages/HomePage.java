package com.amazon.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{  
	
	    //Page Factory - OR
	    @FindBy(xpath = "//a[@aria-label='Amazon.co.uk']")
	    WebElement logo; 
	    
	    @FindBy(xpath = "(//*[text()='Hello, Peter'])[1]")
	    WebElement HelloPeter; 
	    
	    @FindBy(xpath = "//a[@aria-label='0 items in shopping basket']")
	    WebElement ClickBasket;
	    
		//create constructor of this and initialised the page objects
		public HomePage(){
			PageFactory.initElements(driver, this);  
		}
		
		//Actions   
		public String verifyHomePagePageTitle(){
			return driver.getTitle();  
			
		}
		
		public boolean verifyHelloPeter(){
			return HelloPeter.isDisplayed();  
		}
		
		public boolean verifylogo(){
			return logo.isDisplayed(); 
		}
		
		public HomePage ClickOnBasket(){
			ClickBasket.click();
           return new HomePage();   
		}
}