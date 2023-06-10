package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class selectPractice {

    @Test

    public void practice() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("file:///C:/Users/natal/Downloads/Techtorial.html");

        WebElement country= driver.findElement(By.xpath("//select[@name='country']"));

        Select choice=new Select(country);

        String defaultCountry = choice.getFirstSelectedOption().getText().trim();
        String expectedCountry="UNITED STATES".trim();

        Assert.assertEquals(defaultCountry,expectedCountry);

         List <WebElement> allCountries = choice.getOptions();
         int count =0;
        for (WebElement countryByOne :allCountries){
            System.out.println(countryByOne.getText().trim() );
            count++;

        }
        System.out.println(count);



        choice.selectByVisibleText("UKRAINE");

        Thread.sleep(2000);

        choice.selectByValue("198");

        Thread.sleep(2000);

        choice.selectByIndex(6);







    }
}
