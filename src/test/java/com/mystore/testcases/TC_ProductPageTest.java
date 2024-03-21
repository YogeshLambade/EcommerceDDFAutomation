package com.mystore.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexPage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_ProductPageTest extends BaseClass{

	
	
	
	@Test(enabled=true)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		indexPage indexPg = new indexPage(driver);
		indexPg.clickOnSignIn();


		//Enter account details- email and password
		myAccount pg = new myAccount(driver);
		pg.enterEmailAddress("jd2@gmail.com");

		logger.info("User Email and Password entered.");
		pg.enterPassword("jd@123");

		pg.clickSignIn();
		logger.info("Sign In link clicked");

		//Enter searchkey in search box
		registeredUserAccount productPg = new registeredUserAccount(driver);
		productPg.EnterDataInSearchBox(searchKey);
		productPg.ClickOnSearchButton();

		// Get Name of Searched Product
		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();


		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);

			productPg.clickOnSignOut();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenShot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase Search Product ends*****************"); 

	}

	
	
}
