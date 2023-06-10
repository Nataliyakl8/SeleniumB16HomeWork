package GetWindowHandle;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {

    @Test

    public void SwitchPractice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/windows");

        WebElement element= driver.findElement(By.xpath("//a[contains(text(),'Click Here')]"));

        element.click();

        WebElement header =driver.findElement(By.tagName("h3"));

        System.out.println(driver.getWindowHandle());//main page ID -  will give ID of the page/fingerprint of it 08E4D2AB731A0161E6E606943698FD0E

        Set<String> allPagesId= driver.getWindowHandles();

        System.out.println(allPagesId);//[A97A514224CD166F7380DBB7CCD638FC, 07DC75281843EBCB7489A3639CFB1702]
        String mainPageId= driver.getWindowHandle();

        for(String id :allPagesId){
            if(!id.equals(mainPageId)){

                driver.switchTo().window(id);
                break;
            }
            System.out.println(driver.getWindowHandle());//just to see it
        }
        System.out.println(allPagesId);//just to see
        header =driver.findElement(By.tagName("h3"));

        System.out.println(BrowserUtils.getText(header));

        String actualText= BrowserUtils.getText(header);
        String expectedText="New Window";

        Assert.assertEquals(actualText,expectedText);




    }

    @Test
    public void Practice(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button2= driver.findElement(By.cssSelector("#newTabBtn"));

        button2.click();

        String mainPageId= driver.getWindowHandle();//main page
        Set<String> allPages=driver.getWindowHandles();

        for(String id:allPages){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }

        String actualTitle=driver.getTitle().trim();
        String expectedTitle="AlertsDemo - H Y R Tutorials";

        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement AlertsDemo=driver.findElement(By.xpath("//h1[contains(text(),'AlertsDemo')]"));

        String actualText=BrowserUtils.getText(AlertsDemo);
        String expectedText="AlertsDemo";

        Assert.assertEquals(actualText,expectedText);





        WebElement clickButton= driver.findElement(By.cssSelector("#alertBox"));
        clickButton.click();




    }
}
