package com.test.openchart.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenChartHome {

    public OpenChartHome(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css  =".btn-close")
    WebElement buttonDismiss;

    @FindBy(xpath = "//a[contains(text(),' Customers')]")
    WebElement customers;

    @FindBy(xpath = "//ul[@id='collapse-5']//a[contains(text(),'Customers')]")
    WebElement customers2;


    public void homePageFunctionality() throws InterruptedException {

        buttonDismiss.click();

        customers.click();
        Thread.sleep(2000);

        customers2.click();
        Thread.sleep(1000);
    }
}
