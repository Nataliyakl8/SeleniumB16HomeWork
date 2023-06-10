package TestNg;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenChartTestNgPractice {
    @Test
    public void successfulLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement user= driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        Thread.sleep(2000);

        String actual =driver.getTitle();

        String expected="Dashboard";


        Assert.assertEquals(actual,expected);




    }

    @Test
    public void negativeOutcome () throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement user= driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("Demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement alert = driver.findElement(By.cssSelector(".position-fixed"));

        Thread.sleep(2000);
        String actual =alert.getText().trim();
        String expected="No match for Username and/or Password.";

        Assert.assertEquals(actual,expected);

    }

    @Test
    public void validateProductButton() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver=new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement user= driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("demo");

        WebElement login=driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement xButton=driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();

        Thread.sleep(2000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();

        Thread.sleep(2000);

        WebElement product=driver.findElement(By.xpath("//a[.='Products']"));

        Assert.assertTrue(product.isDisplayed());
        Assert.assertTrue(product.isEnabled());




    }

    @Test
    public void validateProductBoxesFunctionality () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement user = driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();

        Thread.sleep(2000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();

        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));

        product.click();

        List<WebElement> allBoxes = driver.findElements(By.cssSelector(".form-check-input"));

        for (int i = 1; i < allBoxes.size(); i++) {
            Assert.assertTrue(allBoxes.get(i).isDisplayed()&&allBoxes.get(i).isEnabled());
            Thread.sleep(1000);

            Assert.assertFalse(allBoxes.get(i).isSelected());

            allBoxes.get(i).click();

            Assert.assertTrue(allBoxes.get(i).isSelected());


            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);
        }



    }


    @Test

    public void validateProductNameFunctionalityDescendingOrder() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.opencart.com/admin/");

        WebElement user = driver.findElement(By.cssSelector("#input-username"));
        user.sendKeys("demo");

        WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
        passcode.sendKeys("demo");

        WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
        login.click();

        WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
        xButton.click();

        Thread.sleep(2000);

        WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
        catalog.click();

        Thread.sleep(2000);

        WebElement product = driver.findElement(By.xpath("//a[.='Products']"));

        product.click();


        /*
1. you will click product name button
2- you should create 2 arraylist
*one will be actual data
*another will be expected data
3. for (int =1)
*store all the names for both of the list. Please use at the end .toUppercase
4. For expected list you will use Collections.sort(expectedList)
--> Collections. reverse(expected)
Assert.equals (actualList,expectedList
 */


        List <WebElement> actualList =  driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements (w/prod name)

        List <String> list1= new ArrayList<>();
        List <String> list2=new ArrayList<>();


        for (int i = 1; i < actualList.size(); i++) {


            list1.add(actualList.get(i).getText().toLowerCase().trim());//same order same items
            list2.add(actualList.get(i).getText().toLowerCase().trim());//same order same items
        }




        Collections.sort(list2);
       //Collections.reverse(list2);


        Assert.assertEquals(list1, list2);


    }
   @Test
   public void validateDescending() throws InterruptedException {
       WebDriverManager.chromedriver().setup();
       ChromeOptions options = new ChromeOptions();
       options.addArguments("--remote -allow-origins=*");

       WebDriver driver = new ChromeDriver(options);

       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       driver.navigate().to("https://demo.opencart.com/admin/");

       WebElement user = driver.findElement(By.cssSelector("#input-username"));
       user.sendKeys("demo");

       WebElement passcode = driver.findElement(By.xpath("//input[@id='input-password']"));
       passcode.sendKeys("demo");

       WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
       login.click();

       WebElement xButton = driver.findElement(By.cssSelector(".btn-close"));
       xButton.click();

       Thread.sleep(2000);

       WebElement catalog = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]"));
       catalog.click();

       Thread.sleep(2000);

       WebElement product = driver.findElement(By.xpath("//a[.='Products']"));

       product.click();

        WebElement clickProductName=driver.findElement(By.xpath("//a[contains(text(),'Product Name')]"));
       clickProductName.click();

        Thread.sleep(3000);

       List <WebElement> descendingList =  driver.findElements(By.xpath("//td[@class='text-start']"));//11 elements (w/prod name)

       List <String> list1= new ArrayList<>();
       List <String> list2=new ArrayList<>();


       for (int i = 1; i < descendingList.size(); i++) {


           list1.add(descendingList.get(i).getText().toLowerCase().trim());//same order same items
           list2.add(descendingList.get(i).getText().toLowerCase().trim());//same order same items
       }

       Collections.sort(list2);
       Collections.reverse(list2);


       Assert.assertEquals(list1, list2);

   }


    }
