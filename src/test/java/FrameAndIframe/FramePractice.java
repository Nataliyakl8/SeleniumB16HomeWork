package FrameAndIframe;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class FramePractice {

    @Test
    public void practice() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));

        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");

        driver.switchTo().parentFrame();
        header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header)); // to be able to do it - i have to come out from the FRAME


    }

    @Test
    public void practice1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

       /*
TASK 1:
  1-Navigate to the website "https://skpatro.github.io/demo/iframes/"
  2-Click pavilion (new tab will be opened, consider switch window)
  3-Choose "Selenium-Phyton" from Selenium button (Action class is suggested)
  4-Validate the Header "Selenium-Python Tutorial"
  5-Print out(NO validation) all the links from website
  6-Wait for Second task
 */

        WebElement pavilion= driver.findElement(By.xpath("//a[contains(text(),'Pavilion')]"));
        pavilion.click();

        BrowserUtils.switchByTitle(driver,"Home - qavalidation");

        Actions actions=new Actions(driver);

        WebElement seleniumButton = driver.findElement(By.linkText("Selenium")); //or //ul[@id='primary-menu']//span[.='Selenium']

        actions.moveToElement(seleniumButton).perform();


        WebElement seleniumPhyton= driver.findElement(By.linkText("Selenium-Python"));
        seleniumPhyton.click();// or actions.click(seleniumP).perform();

        BrowserUtils.switchByTitle(driver,"Selenium-Python");

        WebElement header=driver.findElement(By.tagName("h1"));


        String actualHeader=BrowserUtils.getText(header);
        String expectedHeader="Selenium-Python Tutorial";
        Assert.assertEquals(actualHeader,expectedHeader);

        List<WebElement> all=driver.findElements(By.xpath("//p//a"));

        for(WebElement link:all){

            System.out.println(link.getText());
        }
        /*
TASK 2:
1-Go back to the main page "iframe"
2-click category 1
3-Validate the header "Category Archives: SeleniumTesting"
4-Print out all the headers of the contents(i will show you)
 */

        BrowserUtils.switchByTitle(driver,"iframes");
        driver.switchTo().frame("Frame1");

        WebElement category1=driver.findElement(By.linkText("Category1"));
        category1.click();

        BrowserUtils.switchByTitle(driver,"SeleniumTesting Archives");

        WebElement headerCategory1=driver.findElement(By.tagName("h1"));
        String actualCategory1=BrowserUtils.getText(headerCategory1);
        String expectedCategory1="Category Archives: SeleniumTesting";
        Assert.assertEquals(actualCategory1,expectedCategory1);

         Thread.sleep(2000);
        List<WebElement> allTextList=driver.findElements(By.tagName("h3")); //h3[@class='entry-title']

        for(WebElement text:allTextList){

            System.out.println(BrowserUtils.getText(text));
        }

      /*
TASK 3:
1-Go back mainPage
2-Click Category3
3-Validate the header "Category Archives: SoftwareTesting"

 */

        BrowserUtils.switchByTitle(driver,"iframes");

        driver.switchTo().frame("Frame1");

        WebElement textInsideFrame= driver.findElement(By.xpath("//p[@id='frametext']"));
        System.out.println(BrowserUtils.getText(textInsideFrame));

        driver.switchTo().parentFrame();

        driver.switchTo().frame("Frame2");

        WebElement category3= driver.findElement(By.xpath("//a[contains(text(),'Category3')]"));
        category3.click();

        BrowserUtils.switchByTitle(driver,"SoftwareTesting");

        Thread.sleep(1000);

        WebElement header3= driver.findElement(By.tagName("h1"));

        System.out.println(BrowserUtils.getText(header3));


















    }
}