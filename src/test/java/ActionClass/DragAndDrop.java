package ActionClass;

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

public class DragAndDrop {
    @Test

    public void dragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));

        String actualMsg= BrowserUtils.getText(orangeBox);
        String expectedMsg="... Or here.";

        Assert.assertEquals(actualMsg, expectedMsg);

        String actualColor=orangeBox.getCssValue("background-color");
        String expectedColor = "rgba(238, 111, 11, 1)";

        Assert.assertEquals(actualColor,expectedColor);

        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(draggable,orangeBox).perform();
        // actions.scrollByAmount(200,200).perform(); --> to scroll down we can use this command
        Thread.sleep(2000);
        orangeBox= driver.findElement(By.xpath("//div[@id='droptarget']//div[@class='test2']"));
        String actualAfterDragDrop =BrowserUtils.getText(orangeBox);
        String expectedAfterDragDrop= "You did great!";
        ;
        Assert.assertEquals(actualAfterDragDrop,expectedAfterDragDrop);

    }

    @Test
    public void DragAndDropPractice1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");
        WebElement blueBox= driver.findElement(By.xpath("//div[@class='test1']"));

        String actualMsg =BrowserUtils.getText(blueBox);
        String expectedMsg="Drag the small circle here ...";
        Assert.assertEquals(actualMsg,expectedMsg);

        String actualColor=blueBox.getCssValue("background-color");
        String expectedColor="rgba(63, 81, 181, 1)";

        Assert.assertEquals(actualColor,expectedColor);

        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions=new Actions(driver);
        actions.clickAndHold(draggable).moveToElement(blueBox).release().perform();

        blueBox= driver.findElement(By.xpath("//div[@class='test1']"));

        String afterMst =BrowserUtils.getText(blueBox);
        String afterExpectedMsg = "You did great!";

        Assert.assertEquals(afterMst,afterExpectedMsg);



    }
}

