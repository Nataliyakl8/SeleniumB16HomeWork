package SelectClass;

import Utils.BrowserUtils;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    @Test
    public void headersOfTheCars() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.cars.com/");
        /*
NOTE: Please use browser utils for the select classes if it is needed or getText.
1-Navigate to the website
2-Choose the "New" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056 element.clear()
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350
     */

        WebElement newUsed= driver.findElement(By.xpath("//select[@id='make-model-search-stocktype']"));

        BrowserUtils.selectBy(newUsed,"New","text");

        WebElement makes= driver.findElement(By.xpath("//select[@id='makes']"));

        BrowserUtils.selectBy(makes,"lexus","value");

        WebElement model= driver.findElement(By.cssSelector("#models"));

        BrowserUtils.selectBy(model,"lexus-rx_350","value");

        WebElement priceLimit= driver.findElement(By.cssSelector("#make-model-max-price"));

        Select select=new Select(priceLimit);


       String actual =  BrowserUtils.getText(select.getFirstSelectedOption());
       String expected="No max price".trim();

        Assert.assertEquals(actual,expected);

        WebElement distance =driver.findElement(By.cssSelector("#make-model-maximum-distance"));

        BrowserUtils.selectBy(distance,"40 miles","text");

        WebElement zipCode= driver.findElement(By.cssSelector("#make-model-zip"));

        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton=driver.findElement(By.xpath("//button[@data-linkname='search-new-make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.cssSelector(".sds-heading--1 "));

        String actualHeader = BrowserUtils.getText(header);

        String expectedHeader = "New Lexus RX 350 for sale";

        Assert.assertEquals(actualHeader,expectedHeader);

        WebElement sortBy= driver.findElement(By.cssSelector("#sort-dropdown"));

        BrowserUtils.selectBy(sortBy,"list_price","value");

        Thread.sleep(2000);

       List<WebElement> searchResult = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));


       for (WebElement item:searchResult){

           Assert.assertTrue(BrowserUtils.getText(item).contains("Lexus RX 350"));

           System.out.println(BrowserUtils.getText(item));


       }

       List<WebElement> allPrices= driver.findElements(By.cssSelector(".primary-price"));
       List<Integer> actual$= new ArrayList<>();
       List<Integer> expected$= new ArrayList<>();

       Thread.sleep(2000);

        for (int i = 0; i < allPrices.size(); i++) {
            Thread.sleep(1000);
            actual$.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));
            expected$.add(Integer.parseInt(BrowserUtils.getText(allPrices.get(i)).replace("$","").replace(",","")));

        }
        Collections.sort(expected$);
        Assert.assertEquals(actual$,expected$);

        System.out.println(actual$);
        System.out.println(expected$);










    }
}
