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

public class PracticeActions {

    @Test
    public void PracticeDragAndDrop(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement droppable= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));

        String actual = BrowserUtils.getText(droppable);
        String expected="Drop here";

        Assert.assertEquals(actual,expected);

        WebElement draggable= driver.findElement(By.xpath("//div[@id='draggable']"));

        Actions actions =new Actions(driver);

        actions.dragAndDrop(draggable,droppable).perform();

        droppable= driver.findElement(By.xpath("//div[@class='simple-drop-container']//div[@id='droppable']"));

        String actualAfter=BrowserUtils.getText(droppable);
        String expectedAfter="Dropped!";

        Assert.assertEquals(actualAfter,expectedAfter);

        String actualColor=droppable.getCssValue("background-color");
        String expectedColor ="rgba(70, 130, 180, 1)";

        Assert.assertEquals(actualColor,expectedColor);


}
    @Test
    public void practiceAndHold () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.xpath("//a[@id='droppableExample-tab-accept']"));
        acceptButton.click();

        WebElement notAcceptable= driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        Thread.sleep(2000);
        String actualText=BrowserUtils.getText(notAcceptable);
        String expectedText="Not Acceptable";

        Assert.assertEquals(actualText,expectedText);

        WebElement drop = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));

        String actualDropMsg=BrowserUtils.getText(drop);
        String expectedDropMsg="Drop here";

        Assert.assertEquals(actualDropMsg,expectedDropMsg);

        Actions actions=new Actions(driver);

        actions.clickAndHold(notAcceptable).moveToElement(drop).release().perform();

      //  drop = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']"));
        //  ---> i can have this line once i get Stale elem. Exception --reassignment.

        String actualAfter = BrowserUtils.getText(drop);
        String expectedAfter="Drop here";

        Assert.assertEquals(actualAfter,expectedAfter);





}}
