package com.crm.qa.testcases;



import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.TransactionViewPage;
import com.crm.qa.pages.CustomerLoginPage;



public class CustomerTransactionPageTest extends TestBase{
	CustomerLoginPage loginPage;
	TransactionViewPage customerTransactionPage;
	
	String date = prop.getProperty("ValidationDate");
	String Startdate = prop.getProperty("StartDate");
	String Enddate = prop.getProperty("EndDate");
	
	String AccountexistUser = prop.getProperty("AccontExistUser");
	
	
	
	public CustomerTransactionPageTest()
	{
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		try {
			loginPage = new CustomerLoginPage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customerTransactionPage = loginPage.CustomerLogin1(AccountexistUser);
		
		
	}
	


	@Test(priority=1)
	public void Verify_Deposit_With_ValideAmmount()
	{
		customerTransactionPage.Filter(Startdate, Enddate);
		
	}
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}