package com.crm.qa.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.crm.qa.TestBase.TestBase;



public class TransactionViewPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//button[normalize-space()='Transactions']")
	WebElement Transaction_button;
	
	@FindBy(xpath="//input[@id='start']")
	WebElement StartDate;
	
	@FindBy(xpath="//input[@id='end']")
	WebElement EndDate;
	
	 
	@FindBy(xpath="//*[@id=\"anchor0\"]/td[1]")
	WebElement Validation;
	
	@FindBy(xpath = "//body//div[@class='ng-scope']//div[@class='ng-scope']//div[2]")
	    WebElement pageclick;
	
	
	//Initializing the Page Objects:
	public TransactionViewPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void Filter(String startDate, String endDate)
	{
		Transaction_button.click();
		StartDate.sendKeys(startDate);
		EndDate.sendKeys(endDate);
		pageclick.click();
		 
		
	}
	
	
	
	
//	public void InValidWithdraw(int Amount) throws InterruptedException
//	{
//		int count = acno();
//		for(int i=0;i<count;i++)
//		{
//			 SelectAccount(i);
//			 int oldBal= Integer.valueOf(GetBalance());
//			 Withdraw(Amount);
//			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			 int newBal = Integer.valueOf(GetBalance());
//			 int currentBal = Withdraw_CurrentBalance(Amount,oldBal) ;
//			 Assert.assertEquals(newBal,currentBal);
//			 
//			 
//		}
//	}
	
}