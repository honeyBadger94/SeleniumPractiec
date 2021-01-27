package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    private static WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

    public static void wait(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
    public static void clickOnElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Method to click with a javascript
     * @param element target web element
     */
    public static void clickWithJS(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)(Driver.getDriver())).executeScript("arguments[0].click()",element);
    }

    public static void enterText(WebElement element, String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    //    wait.until(ExpectedConditions.attributeToBe(element,"value","text"));
        element.sendKeys(text);
        wait(1);
    }


}
