package com.test.bank.pages;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BankLoginPage {

    public BankLoginPage(WebDriver driver){

        PageFactory.initElements(driver,this);//it does same logic as drive.findElement/s

    }

    @FindBy(css = ".mainHeading")
    WebElement header;

    @FindBy(xpath = "//button[.='Customer Login']")
    WebElement customerLogin;

    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement managerLogin;

    @FindBy(xpath = "//button[@class='btn home']")
    WebElement homeButton;




    public void LoginPageComponentsValidation(String expectedHeader){

        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);

        Assert.assertTrue(customerLogin.isDisplayed()&&customerLogin.isEnabled());

        Assert.assertTrue(managerLogin.isDisplayed()&&managerLogin.isEnabled());

    }

    public void clickManagerButton(){
        managerLogin.click();
    }

    public void clickCustomerButton(){
        customerLogin.click();
    }
   public void clickHomeButton(){
        homeButton.click();
   }
}
