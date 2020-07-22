package com.objectrepo;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testingbase.Testbase;

public class Objectrepository extends Testbase{	
	
	@FindBy(tagName = "a")	
	List<WebElement> links	;

		
	// Initializing the Page Objects:
public Objectrepository(WebDriver driver) {
		Testbase.driver = driver;
		PageFactory.initElements(driver, this);
		}
		

  public void verifyhyperLinks () throws Exception {
		  		  
	  // To print the total number of links
	  System.out.println("Total links are " + links.size());

	  // Used for-loop
	  for (int i = 0; i < links.size(); i++) {
		  
	    WebElement element = links.get(i);
	    
	   // By using "href" attribute, we could get the url of the requried link   
	   String url = element.getAttribute("href");	    
	    
	   if(url.startsWith("http://") || url.startsWith("https://") ||url.startsWith("ftp://")){
		   System.out.println(url + " - " + "Hyperlinks starts with the Correct protocol");
	   }
	   else {
		   System.out.println(url + " - " + " Hyperlinks starts with the In-Correct Protocol");
	   }
	    	    
     }
  }
}

		
	
	
	
			

