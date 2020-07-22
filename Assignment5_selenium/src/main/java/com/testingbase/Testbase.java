package com.testingbase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.objectrepo.Objectrepository;


public class Testbase {

	public static WebDriver driver;
	public static Properties prop;
	public static Objectrepository objpages;

	
public Testbase( ) {
		
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/resource/Propertyfile/config.properties");
		prop.load(ip);		} 
	
	catch (IOException e) {
		e.printStackTrace();
	}
}
	
	
	@BeforeMethod
	public void setup ()  
	{	
		initialization();
		objpages= new Objectrepository(driver);
					
	}
	
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
		
	public static void initialization(){
		
		
		String Browser= prop.getProperty("browser");
		
		if(Browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/com/resource/drivers/chromedriver.exe");			
			driver = new ChromeDriver(); 
					
		}
		else if(Browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "/src/main/java/com/resource/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
			
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.MINUTES);
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		
		
	}
	
}		
	