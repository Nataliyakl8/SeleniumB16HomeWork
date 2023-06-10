package Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {

    public static String getText(WebElement element){
        return element.getText().trim();
    }

    public static void selectBy(WebElement location, String value,String methodName){

        Select select =new Select(location);

        switch(methodName){

            case "text":
                select.selectByVisibleText(value);
                break;
            case"value":
                select.selectByValue(value);
                break;
            case"index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Your method name not correct");
                Assert.assertTrue(false);
        }
    }

    public static String  getTitleJS (WebDriver driver){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString().trim();

    }

    public static void clickWithJS(WebDriver driver,WebElement element){

        JavascriptExecutor js= (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()",element);
    }

    public static void scrollWithJS(WebDriver driver, WebElement element){

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }

    public static void switchById(WebDriver driver){

        String mainPageId=driver.getWindowHandle();
        Set< String> allPagesID = driver.getWindowHandles();

        for(String id: allPagesID){

            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);

            }
        }


    }

    public static void switchByTitle(WebDriver drive, String title){
        Set<String> allPagesId=drive.getWindowHandles();
        for (String id:allPagesId){

            drive.switchTo().window(id);
            if(drive.getTitle().contains(title)){
                break;
            }


        }

    }
}
