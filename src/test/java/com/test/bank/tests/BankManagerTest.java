package com.test.bank.tests;

import com.test.bank.pages.BankLoginPage;
import com.test.bank.pages.BankManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class BankManagerTest extends BankTestBase{

    @Test
    public void validateAddCustomerFunctionality(){

        /*WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");*/

        BankLoginPage LoginPage=new BankLoginPage(driver);
        LoginPage.clickManagerButton();

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerFunctionality(driver,"Nataliya","kl","60008",
                "Customer added successfully with customer id");

    }

    @Test
    public void validateOpenAccountFunctionality(){
       /*WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");*/

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerFunctionality(driver,"Nataliya","kl","60008",
                "Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver,"Nataliya kl","Dollar",
                "Account created successfully with account Number");

    }

    @Test
    public void validateCustomerFunctionality(){
       /*WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");*/

        BankLoginPage loginPage=new BankLoginPage(driver);
        loginPage.clickManagerButton();

        BankManagerPage bankManagerPage=new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerFunctionality(driver,"Nataliya","kl","60008",
                "Customer added successfully with customer id");

        bankManagerPage.OpenAccountFunctionality(driver,"Nataliya kl","Dollar",
                "Account created successfully with account Number");

        bankManagerPage.customersButtonFunctionality("Nataliya","kl","60008");



    }
}
