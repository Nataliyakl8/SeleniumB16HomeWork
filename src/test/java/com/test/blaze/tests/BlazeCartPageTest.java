package com.test.blaze.tests;

import com.test.blaze.pages.BlazeCartPage;
import com.test.blaze.pages.BlazeHomePage;
import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import org.testng.annotations.Test;

public class BlazeCartPageTest extends BlazeTestBase{

    @Test
    public void validationCartPage() throws InterruptedException {

        BlazeHomePage blazeHomePage=new BlazeHomePage(driver);

        blazeHomePage.selectCategory("Laptops");

        LaptopPage laptopPage=new LaptopPage(driver);

        laptopPage.selectLaptop("MacBook Pro");

        MacBookProPage macBookProPage=new MacBookProPage(driver);

        macBookProPage.clickAddToCart(driver,"Product added");

        blazeHomePage.cartClick();

        BlazeCartPage blazeCartPage=new BlazeCartPage(driver);
        blazeCartPage.cartItemsList("MacBook Pro","1100");

        blazeCartPage.clickPlaceOrder();

    }
}
