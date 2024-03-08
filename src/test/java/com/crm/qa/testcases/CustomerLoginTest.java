package com.crm.qa.testcases;




import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.AmountWithdrawalPage;
import com.crm.qa.pages.CustomerLoginPage;



public class CustomerLoginTest extends TestBase{
	CustomerLoginPage loginPage;
	AmountWithdrawalPage accountPage;
	String AccountexistUser = prop.getProperty("AccontExistUser");
	String AccountNot_existUser = prop.getProperty("AccontNot_ExistUser");
	
	
	
	public CustomerLoginTest(){
		super();
	}
	
	
	
	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		screenshots("CustomerLoginTest");
		loginPage = new CustomerLoginPage();
		accountPage = new AmountWithdrawalPage();
		
	}
	
	
	@Test(priority=1)
	public void customerlogin()
	{
		loginPage.CustomerLogin(AccountexistUser);
		String name=accountPage.verifyCustomerName();
		AssertJUnit.assertEquals(AccountexistUser,name);
		
		
	}
	
//	@Test(priority=2)
//	public void customerlogin_Not_Exist()
//	{
//		loginPage.CustomerLogin(AccountNot_existUser);
//		
//		
//	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}