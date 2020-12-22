package com.amazon.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.amazon.qa.utils.TestUtil;


public class TestBase {
	
	//Initialised WebDriver
	public static WebDriver driver; 
	public static Properties prop;  
	
	// create constructor 
	public TestBase(){
		
		//Initialised Properties
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\user\\workspace\\POM\\src\\main\\java\\Config\\config.properties");
			try {
				prop.load(ip);
			} catch (IOException e){
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();   
		}
	}

	//create Initialisation method 
	public static void initialisation(){
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\user\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver","C:\\Users\\user\\Downloads\\geckodriver\\geckodriver.exe"); 
			driver = new FirefoxDriver();
		}
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS); 
		
		driver.get(prop.getProperty("url"));   
	}
}