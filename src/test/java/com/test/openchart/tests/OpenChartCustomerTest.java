package com.test.openchart.tests;

import com.test.openchart.pages.OpenChartCustomerPage;
import com.test.openchart.pages.OpenChartHome;
import org.testng.annotations.Test;

public class OpenChartCustomerTest extends OpenChartTestBase {

    @Test

    public void validationCustomerPage () throws InterruptedException {

        OpenChartLogin openChartLogin=new OpenChartLogin(driver);

        openChartLogin.loginFunctionality("demo","demo");

        OpenChartHome openChartHome=new OpenChartHome(driver);

        openChartHome.homePageFunctionality();

        OpenChartCustomerPage openChartCustomerPage=new OpenChartCustomerPage(driver);

        openChartCustomerPage.customerPageAddInfo("Nata","kl","mail@mail.com","1234","1234");

        openChartCustomerPage.customerPageSelectOthers(driver);

        Thread.sleep(2000);

        openChartCustomerPage.message("Warning: You do not have permission to modify customers!");


    }


}
