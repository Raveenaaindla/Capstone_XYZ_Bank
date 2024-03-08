package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;
import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.AmountWithdrawalPage;
import com.crm.qa.pages.AddNewCustomerPage;
import com.crm.qa.pages.CustomerLoginPage;



public class AddCustomerPageTest extends TestBase{
	CustomerLoginPage loginPage;
	AmountWithdrawalPage accountPage;
	AddNewCustomerPage addCustomerPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String fname = prop.getProperty("fname");
	String lname = prop.getProperty("Lname");
	String postcode = prop.getProperty("postcode") ;
	String message_AddCustomer = prop.getProperty("message_AddCustomer") ;
	String message_AddCustomer_Exist = prop.getProperty("message_AddCustomer_Exist") ;
	
	
	
	public AddCustomerPageTest()
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
		addCustomerPage = loginPage.ManagerLogin();
		
		
		
	}

	
	@Test(priority=1)
	public void AddCustomerNotExist() throws InterruptedException
	{
		addCustomerPage.AddCustomer(fname,lname,postcode);
		String result = addCustomerPage.getAlertMessageText();
		String actualText = result;
        String expectedPartialText = message_AddCustomer;
		   // Assertion using assertContains (custom assertion method)
        addCustomerPage.assertContains(actualText, expectedPartialText);
        addCustomerPage.getAlert();
		
		
	}
	
	@Test(priority=2, dependsOnMethods = "AddCustomerNotExist")
	public void AddCustomerExist() throws InterruptedException
	{
		addCustomerPage.AddCustomer(fname,lname,postcode);
        addCustomerPage.getAlert();
        Thread.sleep(1000);
		addCustomerPage.AddCustomer(fname,lname,postcode);
		String result2 = addCustomerPage.getAlertMessageText();
        AssertJUnit.assertEquals(result2, message_AddCustomer_Exist);
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}