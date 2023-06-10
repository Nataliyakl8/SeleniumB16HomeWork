package com.test.openchart.tests;

import Utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenChartLogin {

    public OpenChartLogin (WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#input-username")
    WebElement userName;
    @FindBy(css = "#input-password")
    WebElement passcode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;


    @FindBy(css="#alert")
    WebElement errorMessage;



    public void loginFunctionality(String name, String password) throws InterruptedException {

        userName.sendKeys(name);

        passcode.sendKeys(password);

        loginButton.click();

        Thread.sleep(2000);


    }



 public String errorMessage(){

        return BrowserUtils.getText(errorMessage);
 }
}
