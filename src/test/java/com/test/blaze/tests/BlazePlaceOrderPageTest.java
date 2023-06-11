package com.test.blaze.tests;

import com.test.blaze.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BlazePlaceOrderPageTest extends BlazeTestBase{

    @Test
    public void orderPageValidation() throws InterruptedException {

        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);

        blazeHomePage.selectCategory("Laptops");

        LaptopPage laptopPage=new LaptopPage(driver);

        laptopPage.selectLaptop("MacBook Pro");

        MacBookProPage macBookProPage=new MacBookProPage(driver);

        macBookProPage.clickAddToCart(driver,"Product added");

        blazeHomePage.cartClick();

        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);

        blazeCartPage.clickPlaceOrder();

        BlazePlaceOrderPage orderPage=new BlazePlaceOrderPage(driver);

        orderPage.fillOutOrder("Nata","USA","Chicago","123456789","12","2025");

        orderPage.confirmPurchase("Thank you for your purchase!");

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/cart.html");

    }




}
