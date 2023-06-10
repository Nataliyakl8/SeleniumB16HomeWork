package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class homeWork2 {

    public static void main(String[] args) {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver drive = new ChromeDriver(options);
        drive.manage().window().maximize();
        drive.navigate().to("https://www.saucedemo.com/");

        WebElement userName= drive.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("Java");

        WebElement passcode = drive.findElement(By.xpath("//input[@id='password']"));
        passcode.sendKeys("Selenium");

        WebElement login = drive.findElement(By.xpath("//input[@id='login-button']"));
        login.click();

        WebElement error= drive.findElement(By.xpath("//h3[@data-test='error']"));
        String errorActual =error.getText().trim();
        String errorExpected="Epic sadface: Username and password do not match any user in this service";

        //Epic sadface: Username and password do not match any user in this service

        System.out.println(errorActual.equals(errorExpected)? "all good":"failed");

        drive.quit();


    }
}
