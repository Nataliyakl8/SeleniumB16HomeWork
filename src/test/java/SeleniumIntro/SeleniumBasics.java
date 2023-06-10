package SeleniumIntro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumBasics {
    public static void main(String[] args) {
        //First step setting up Automation

        WebDriverManager.chromedriver().setup();
        // those 2 lines because of the bug -- we have to write 2 extra line
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--remote -allow-origins=*");

        //then create your driver to start automation

        WebDriver driver= new ChromeDriver(options);

        driver.get("https://www.amazon.com/");

        System.out.println(driver.getTitle());

        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon.com. Spend less. Smile more.";

        if(actualTitle.equals(expectedTitle)){

            System.out.println("passed");
        }else {
            System.out.println("failed ");
        }

        String actualUrl = driver.getCurrentUrl();

        String expectedUrl = "https://www.amazon.com/";

        if (actualUrl.equals(expectedUrl)) {

            System.out.println(" url Passed");
        }else{
            System.out.println(" url failed ");

    }

        driver.close();



    }


}
