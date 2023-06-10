package SeleniumLocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPATHLocator {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement abTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]"));
        Thread.sleep(2000);
         abTesting.click();

         WebElement header= driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        System.out.println(header.getText());

        WebElement textP= driver.findElement(By.xpath("/html/body/div[2]/div/div/p"));
        System.out.println(textP.getText());

        WebElement selenium = driver.findElement(By.xpath("//a[contains(text(),'Elemental Selenium')]"));
        selenium.click();
    }
}
