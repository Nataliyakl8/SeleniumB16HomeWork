package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HomeWork3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver drive = new ChromeDriver(options);
        drive.manage().window().maximize();
        drive.navigate().to("https://www.saucedemo.com/");

        WebElement userName = drive.findElement(By.xpath("//input[@id='user-name']"));
        userName.sendKeys("standard_user");

        WebElement password = drive.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("secret_sauce");

        WebElement loginB = drive.findElement(By.xpath("//input[@id='login-button']"));
        loginB.click();

        String expectedUrl="https://www.saucedemo.com/inventory.html";
        System.out.println(drive.getCurrentUrl().equals(expectedUrl)? "match":"failed");

        drive.quit();


    }
}
