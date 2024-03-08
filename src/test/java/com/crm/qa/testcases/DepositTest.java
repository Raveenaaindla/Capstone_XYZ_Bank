package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.TestBase.TestBase;
import com.crm.qa.pages.AmountWithdrawalPage;
import com.crm.qa.pages.CustomerLoginPage;

public class DepositTest extends TestBase {
    CustomerLoginPage loginPage;
    AmountWithdrawalPage accountPage;
    String AccountexistUser = prop.getProperty("AccontExistUser");
    int ValidAmount = Integer.valueOf(prop.getProperty("ValidAmount"));
    int InValidAmount = Integer.valueOf(prop.getProperty("InValidAmount")); // Define InValidAmount

    public DepositTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
    	
    	// Initialize test environment
        initialization();
        try {
        	// Initialize login page object
            loginPage = new CustomerLoginPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
     // Login with existing account username
        accountPage = loginPage.CustomerLogin(AccountexistUser);
    }

    @Test(priority = 1)
    public void VerifyDepositWithValidAmount() {
        // Verify the deposit with a valid amount
        accountPage.ValidDeposit("Deposit Successful", ValidAmount);
    }

    @Test(priority = 2)
    public void VerifyDepositWithInvalidAmount() {
        // Verify the deposit with an invalid amount
        accountPage.InValidDeposit(InValidAmount);
    }

    @AfterMethod
    public void tearDown() {
    	// Quit the WebDriver after test execution
        driver.quit();
    }
}
