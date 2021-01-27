package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;
import utils.Driver;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//span[@class='a-offscreen'] | //span[class='a-price']/span ")
    WebElement priceOfFirstElement;


    public String getPrice(String list){

        String listXpath="//span[@cel_widget_id='MAIN-SEARCH_RESULTS-"+list+"']";

        WebElement listing = Driver.getDriver().findElement(By.xpath(listXpath));

        String result = listing.findElement(By.xpath("//span[@class='a-price-whole']")).getText();

        result="$"+result;

        result+="."+listing.findElement(By.xpath("//span[@class='a-price-fraction']")).getText();

        return result;
    }
    public void clickOnOption(String list){
        String listXpath="//span[@cel_widget_id='MAIN-SEARCH_RESULTS-"+list+"']";

        WebElement element = Driver.getDriver().findElement(By.xpath(listXpath)).findElement(By.tagName("a"));

        BrowserUtils.clickOnElement(element);

    }

}
