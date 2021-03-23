package com.nuts.qa.Webpages;



import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nuts.qa.base.TestBase;

public class SearchPage extends TestBase{

	// Identifying the web elements using findby annotation
	
	@FindBy(xpath = "//form//span//input[@name='q'][@role='combobox']")
	WebElement txtBoxSearch;
	
	
	
	@FindBy(xpath="//span[@id='suggestion-list']")
	WebElement Autosuggestionslist;
	
	
	
	@FindBy(css=".dyMonitor input")
	WebElement SearchButton;
	
	
	
	@FindBy(xpath="//li[@class='search hidden-sm hidden-md hidden-lg']")
	WebElement AdditionalSearchIcon;
	
	//Initializing the webelements using Page Factory Class
	
	public SearchPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	

	
    public boolean SearchboxDispalyedwithscreenwidthabv1280() {
		
		return txtBoxSearch.isDisplayed();
	}
	
    public boolean AutopopulatedListAppearance() throws InterruptedException {
		
    	txtBoxSearch.click();
    	Thread.sleep(3000);
    	txtBoxSearch.sendKeys("cashews");
    	Thread.sleep(3000);
  		return Autosuggestionslist.isDisplayed();
  	}
  	
    public boolean NoAutoSugforMobwidBrowSize() throws InterruptedException {
		
    	Thread.sleep(3000);
    	
    	//Setting the size of the browser window to less than 600 px
    	
    	driver.manage().window().setPosition(new Point(375,550));
    	
    	Thread.sleep(3000);
    	
    	txtBoxSearch.click();
    	Thread.sleep(3000);
    	txtBoxSearch.sendKeys("cash");
    	Thread.sleep(3000);
  		return Autosuggestionslist.isSelected();
  	}
    
    public boolean SearchboxDispalyedwithscreenwidthBlw600() throws InterruptedException {
		
    	Thread.sleep(3000);
    	
    	driver.manage().window().setSize(new Dimension(300,500));
    	
  		return SearchButton.isEnabled();
  	}
  	
   public boolean AdditionalSearchIconDispalyedwithscreenwidthBlw600() throws InterruptedException {
		
    	Thread.sleep(3000);
    	driver.manage().window().setSize(new Dimension(300,500));
   	    Thread.sleep(4000);
  		return AdditionalSearchIcon.isDisplayed();
  	}
   
   public boolean AutopopulatedListAppearanceforAdditionalSearchIconsearchtextboxwithscreenwidthBlw600() throws InterruptedException {
		
   	  Thread.sleep(3000);
   	  driver.manage().window().setSize(new Dimension(300,500));
   	
  	    Thread.sleep(4000);
 		AdditionalSearchIcon.click();
 		
 		Thread.sleep(3000);
 		
 		txtBoxSearch.click();
    	Thread.sleep(3000);
    	txtBoxSearch.sendKeys("cashews");
    	Thread.sleep(3000);
  		return Autosuggestionslist.isDisplayed();
 		
 		
 	}
   
     
    
}
