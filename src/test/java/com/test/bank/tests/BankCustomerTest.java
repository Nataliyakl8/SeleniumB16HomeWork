package com.test.bank.tests;

import com.test.bank.pages.BankCustomerPage;
import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankCustomerTest extends BankTestBase {

    @Test

    public void validationLoginFunctionality()  throws InterruptedException {

//       WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote -allow-origins=*");
//        WebDriver driver=new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerFunctionality(driver,"Nataliya","kl","60008",
                "Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver,"Nataliya kl","Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersButtonFunctionality("Nataliya","kl","60008");

        loginPage.clickHomeButton();

        loginPage.clickCustomerButton();

        BankCustomerPage bankCustomerPage=new BankCustomerPage(driver);
        bankCustomerPage.loginFunctionality("Nataliya kl","Welcome Nataliya kl !!");

        bankCustomerPage.depositFunctionality("500","Deposit Successful");

        bankCustomerPage.withdrawalFunctionality("300","Transaction successful");

        bankCustomerPage.transactionFunctionality();



    }

}
