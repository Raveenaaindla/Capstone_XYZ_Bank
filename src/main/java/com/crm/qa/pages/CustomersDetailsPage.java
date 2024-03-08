package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.TestBase.TestBase;

public class CustomersDetailsPage extends TestBase{
	
	// Page Factory elements for Customer button, Search Box, and Delete button
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/button[3]")
	public
	WebElement Customer_button;
	
	@FindBy(xpath="//input[@placeholder='Search Customer']")
	WebElement SearchBox;
	
	@FindBy(xpath="//button[@ng-click='deleteCust(cust)']")
	WebElement Delete;
	
	
	
	//Initializing the Page Objects:
	public CustomersDetailsPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Action to delete customer entry
	// Clicks on the Customer button, searches for the specified username, and deletes the entry
	public void DeleteEntry(String username) throws InterruptedException 
	{
		Customer_button.click();
		SearchBox.sendKeys(username);
		Delete.click();
		System.out.println("Deleted customers details successfully");      
    }
	
}