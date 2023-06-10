package JavaScriptExecutorClass;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class JavaScriptMethods {
    @Test
    public void getTitle() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");
        System.out.println(driver.getTitle() + " with reg. Selenium method");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        System.out.println(js.executeScript("return document.title") + " Java Script");
    }

    @Test

    public void clickJS() throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://codefish.io/");

        WebElement aboutUS = driver.findElement(By.xpath("//button[.='About us']"));

        Actions actions = new Actions(driver);
        actions.click(aboutUS).perform();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        aboutUS = driver.findElement(By.xpath("//button[.='About us']"));
        aboutUS.click();

        driver.navigate().back();

        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()", aboutUS);

    }

    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");

        WebElement findOutCourse = driver.findElement(By.xpath("//span[contains(text(),'which course')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].scrollIntoView(true)", findOutCourse);
        Thread.sleep(2000);
        findOutCourse.click();


    }

    @Test

    public void practice2() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");
        //div[contains(text(),'Copyright')]---other way
        WebElement copyR = driver.findElement(By.xpath("//div[@class='learnworlds-main-text learnworlds-main-text-small learnworlds-element']"));
        BrowserUtils.scrollWithJS(driver, copyR);

        //JavascriptExecutor js= (JavascriptExecutor) driver;
        // js.executeScript("arguments[0].scrollIntoView(true)",copyR);

        String actualText = BrowserUtils.getText(copyR);
        String expectedText = "Copyright © 2023";

        Assert.assertEquals(actualText, expectedText);

        WebElement apply = driver.findElement(By.linkText("Apply Now"));

        BrowserUtils.scrollWithJS(driver, apply);
        // js.executeScript("arguments[0].scrollIntoView(true)",apply);
        BrowserUtils.clickWithJS(driver, apply);
        // js.executeScript("arguments[0].click()",apply);
        String actualTitle = BrowserUtils.getTitleJS(driver);
        String expectedTitle = "Apply Now";
        // js.executeScript("return document.title");
        Assert.assertEquals(actualTitle, expectedTitle);

        List<WebElement> allInformation = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));

        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");

        for (int i = 0; i < allInformation.size(); i++) {

            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInfo.get(i));
        }
    }

    public void practice3() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.techtorialacademy.com/");


    }
}