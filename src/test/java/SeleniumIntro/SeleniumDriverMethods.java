package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumDriverMethods {

    // driver.get
    //drive.manage.windows.maximize
    //driver.getTitle
    //driver.getCurrentYrl
    //driver.navigate.to
    //driver.navigate.refresh
    //driver.navigate.back
    //drive.navigate.forward
    //driver.getPageSource
    //driver.close
    //drive.quit

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        System.out.println(driver.getTitle());

        Thread.sleep(3000);//pauses system for certain time --> here 3 seconds

        driver.navigate().to("https://www.youtube.com/");

        System.out.println(driver.getCurrentUrl());
        Thread.sleep(3000);

        driver.navigate().back();//go to Google  again

        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.navigate().forward();//go back to YouTube

        System.out.println(driver.getTitle());
        Thread.sleep(3000);

        driver.navigate().refresh();//refresh page

        Thread.sleep(3000);

        // it gets HTML structure of page on console
        System.out.println(driver.getPageSource());

        driver.quit();//it closes all the pages is open from one automation






    }
}
