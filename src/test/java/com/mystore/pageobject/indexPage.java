package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	WebDriver ldriver;
	
	public indexPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		

		PageFactory.initElements(rdriver, this);
	}
	
	//identify webelements
		//@FindBy(linkText = "Sign in") 
	    @FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/div[1]/div[1]/nav[1]/div[1]/a[1]")
		WebElement signIn;
		
		public void clickOnSignIn() {
			signIn.click();
		}
	
	
}
