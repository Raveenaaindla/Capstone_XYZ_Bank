package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.crm.qa.TestBase.TestBase;

public class OpenNewAccountPage extends TestBase{
	
	// Page Factory elements for Open Account button, Customer Name dropdown, Currency dropdown, and Submit button
	@FindBy(xpath="/html/body/div/div/div[2]/div/div[1]/button[2]")
	public
	WebElement OpenAccount_button;
	
	@FindBy(xpath="//select[@id='userSelect']")
	WebElement Customer_Name;
	
	@FindBy(xpath="//select[@id='currency']")
	WebElement Currency;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Submit;
	
	// Message for successful account opening
	String openAccount_msg= prop.getProperty("openAccount_msg");
	
	
	//Initializing the Page Objects:
	public OpenNewAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Method to get the number of options in the Currency dropdown
	public int currency_Size()
	{
		Select dropdown = new Select(Currency);
		  int itemCount = dropdown.getOptions().size();
		  return itemCount; 
		
	}
	
	// Method to select an account by index from the Currency dropdown
	public void SelectAccount(int index)
	{
		 Select dropdown = new Select(Currency);
		 dropdown.selectByIndex(index);
	}
	
	// Method to select a user from the Customer Name dropdown by visible text
	public void SelectUser(String username)
	{
		 Select dropdown = new Select(Customer_Name);
		
		dropdown.selectByVisibleText(username);
	}
	
	// Method to get the text of the alert message
	public String getAlertMessageText() {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
        
    }
	
	// Method to accept the alert
	public void getAlert() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
        
    }

	// Method to add a customer and open a new account
	public OpenNewAccountPage AddCustomer(String name) throws InterruptedException
	{
		int count = currency_Size();
		for(int i=1;i<count;i++)
		{
			OpenAccount_button.click();
			Thread.sleep(1000);
			SelectUser(name);
			Thread.sleep(1000);
			SelectAccount(i);
			Submit.click();
			Thread.sleep(1000);
			String message = getAlertMessageText();
			assertContains(message,openAccount_msg);
			getAlert();
			
		}
		return new OpenNewAccountPage();
	}
	
	
	// Utility method to assert if actual text contains expected partial text
	public static void assertContains(String actualText, String expectedPartialText) {
        Assert.assertTrue(actualText.contains(expectedPartialText), "Actual text does not contain expected partial text");
    }
	
}