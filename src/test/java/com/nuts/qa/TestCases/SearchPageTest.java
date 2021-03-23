package com.nuts.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nuts.qa.Webpages.SearchPage;
import com.nuts.qa.base.TestBase;

public class SearchPageTest extends TestBase{
	
	SearchPage SearchPageobj;
	
	
	public SearchPageTest() {
		
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		SearchPageobj = new SearchPage();
	}

    //Step 1
	//This testcase tests the presence of Search bar on Nuts.com homepage when browser has a screen width above 1280 px
	
	@Test(priority = 1 )
	public void VerifySearchboxdisplayedwithSizeAbv1280() {
		Assert.assertTrue(SearchPageobj.SearchboxDispalyedwithscreenwidthabv1280());
	}
	
	//This test case tests if the search bar supports auto-suggestion feature on Nuts.com homepage when browser has a screen width above 1280 px
	
	@Test(priority = 2)
	public void VerifyAutopopulatedListAppearancewithSizeAbv1280() throws InterruptedException {
		Assert.assertTrue(SearchPageobj.AutopopulatedListAppearance());
	}
	
	
	
	//step 2
	//This test case tests the presence Search bar on Nuts.com homepage when browser has a screen width below 600 px
	
	@Test(priority = 3)
	public void VerifySearchboxdisplayedwithSizeblw600() throws InterruptedException {
		Assert.assertTrue(SearchPageobj.SearchboxDispalyedwithscreenwidthBlw600());
	}
	
	//This testcase tests the search bar in screen width below 600 px does not support auto suggestion feature
	
	@Test(priority = 4)
	public void VerifyNoAutoSuggestionforMobileWidthBrowsersize() throws InterruptedException {
		Assert.assertFalse(SearchPageobj.NoAutoSugforMobwidBrowSize());
	}
		
	//step 3
	//This testcase tests the presence of second search bar (magnifying glass icon) in browser screen width below 600 px
	
	@Test(priority = 5)
	public void VerifyAdditionalSearchIcondisplayedwithSizeblw600() throws InterruptedException {
		Assert.assertTrue(SearchPageobj.AdditionalSearchIconDispalyedwithscreenwidthBlw600());
	}
	
	//This testcase tests the second search bar (magnifying glass icon) when clicked displays another search box which supports auto-suggestion feature
	
	@Test(priority=6)
    public void VerifyAutopopulatedTextforAddSearchiconSearchbox() throws InterruptedException {
		Assert.assertTrue(SearchPageobj.AutopopulatedListAppearanceforAdditionalSearchIconsearchtextboxwithscreenwidthBlw600());
	}	
	
	//To close browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
