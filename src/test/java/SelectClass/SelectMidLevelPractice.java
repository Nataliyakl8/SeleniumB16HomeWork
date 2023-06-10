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
import java.util.Arrays;
import java.util.List;

public class SelectMidLevelPractice {

    @Test
    public void validateOrderMessage() {
         /*1-Navigate to the website
2-Select one way trip button
3-Choose 4 passangers(1 wife-1 husband-2 kids)
4-Validate the depart from is default "Acapulco"
5-Choose the depart from is Paris
6-Choose the date August 15th
7-Choose the arrive in is San Francisco
8-Choose the date December 15th
10-Click first class option.
11-Validate All the options from Airline
12-Choose the Unified option from airline list
13-Click Continue
14-Validate the message at the top.There is a bug here/
 "After flight finder - No Seats Avaialble"

 NOTE:Your test should fail and say available is not matching with Available.
 NOTE2:You can use any select method value,visibleText*/
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement roundButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        roundButton.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        passengers.sendKeys("4");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select departing = new Select(departingFrom);

        String defaultDeparture = departing.getFirstSelectedOption().getText().trim();
        String expectedDeparture = "Acapulco".trim();

        Assert.assertEquals(defaultDeparture, expectedDeparture);

        departing.selectByVisibleText("Paris");

        WebElement monthOption = driver.findElement(By.xpath("//select[@name='fromMonth']"));

        Select monthDepart = new Select(monthOption);
        monthDepart.selectByVisibleText("August");

        WebElement dateOption = driver.findElement(By.xpath("//select[@name='fromDay']"));

        Select dateDepart = new Select(dateOption);
        dateDepart.selectByValue("15");

        WebElement arrivalCity = driver.findElement(By.xpath("//select[@name='toPort']"));

        Select selectArriveCity = new Select(arrivalCity);

        selectArriveCity.selectByVisibleText("San Francisco");

        WebElement monthOption2 = driver.findElement(By.xpath("//select[@name='toMonth']"));

        Select monthArrive = new Select(monthOption2);
        monthArrive.selectByVisibleText("December");

        WebElement dateOption2 = driver.findElement(By.xpath("//select[@name='toDay']"));

        Select dateArrive = new Select(dateOption2);
        dateArrive.selectByValue("15");

        WebElement classLevelOptions = driver.findElement(By.xpath("//input[@value='First']"));
        classLevelOptions.click();

        WebElement airLines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select chooseAirline = new Select(airLines);

        List<WebElement> actualAllAirLines = chooseAirline.getOptions();
        List<String> expectedAllAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < actualAllAirLines.size(); i++) {

            Assert.assertEquals(actualAllAirLines.get(i).getText().trim(), expectedAllAirlines.get(i).trim());

        }
        chooseAirline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));

        String actualMessage = message.getText().trim();
        String expectedMessage = "After flight finder - No Seats Available".trim();

        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void validateOrderMessageShortCut() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement roundButton = driver.findElement(By.xpath("//input[@value='oneway']"));
        roundButton.click();

        WebElement passengers = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passengers, "4", "value");

        WebElement departingFrom = driver.findElement(By.xpath("//select[@name='fromPort']"));

        Select departing = new Select(departingFrom);

        String defaultDeparture = departing.getFirstSelectedOption().getText().trim();
        String expectedDeparture = "Acapulco".trim();

        Assert.assertEquals(defaultDeparture, expectedDeparture);
         Thread.sleep(2000);

        BrowserUtils.selectBy(departingFrom, "Paris", "text");

        WebElement monthOption = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(monthOption, "August", "text");

        WebElement dateOption = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(dateOption, "15", "value");


        WebElement arrivalCity = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(arrivalCity, "San Francisco", "text");


        WebElement monthOption2 = driver.findElement(By.xpath("//select[@name='toMonth']"));

        BrowserUtils.selectBy(monthOption2, "December", "text");


        WebElement dateOption2 = driver.findElement(By.xpath("//select[@name='toDay']"));

        BrowserUtils.selectBy(dateOption2, "15", "value");


        WebElement classLevelOptions = driver.findElement(By.xpath("//input[@value='First']"));
        classLevelOptions.click();

        WebElement airLines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select chooseAirline = new Select(airLines);

        List<WebElement> actualAllAirLines = chooseAirline.getOptions();
        List<String> expectedAllAirlines = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");

        for (int i = 0; i < actualAllAirLines.size(); i++) {

            Assert.assertEquals(BrowserUtils.getText(actualAllAirLines.get(i)), expectedAllAirlines.get(i).trim());

        }
        chooseAirline.selectByVisibleText("Unified Airlines");

        WebElement continueButton = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueButton.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));

        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "After flight finder - No Seats Available".trim();

        Assert.assertEquals(actualMessage, expectedMessage);


    }

}
