package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

public class TransactionViewPage extends TestBase{
	
	// Page Factory elements for Transaction button, Start Date input field, End Date input field, and validation element
	@FindBy(xpath="//button[normalize-space()='Transactions']")
	WebElement Transaction_button;
	
	// Element representing the 'Start Date' input field
	@FindBy(xpath="//input[@id='start']")
	WebElement StartDate;
	
	// Element representing the 'End Date' input field
	@FindBy(xpath="//input[@id='end']")
	WebElement EndDate;
	
	// Element representing the validation message
	@FindBy(xpath="//*[@id=\"anchor0\"]/td[1]")
	WebElement Validation;
	
	// Element representing a clickable area on the page
	@FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
	    WebElement pageclick;
	
	
	//Initializing the Page Objects:
	public TransactionViewPage(){
		PageFactory.initElements(driver, this); // Initialize elements using PageFactory
	}
	
	// Action to validate the title of the login page
	public String validateLoginPageTitle(){
		return driver.getTitle(); // Return the title of the page
	}
	
	// Action to filter transactions by start and end dates
	public void Filter(String startDate, String endDate)
	{
		// Click on the Transaction button
		Transaction_button.click();
		
		// Enter the start date
		StartDate.sendKeys(startDate);
		
		// Enter the end date
		EndDate.sendKeys(endDate);
		
		// Click on the page to trigger the filter action
		pageclick.click();
		 
		
	}

}