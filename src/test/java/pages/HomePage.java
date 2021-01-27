package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.BrowserUtils;
import utils.Driver;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@type='submit' or @id='nav-search-submit-button']")
    WebElement searchButton;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    @FindBy(id = "searchDropdownBox")
    private WebElement dropDown;

    public void selectCategory(String category){
        Actions ac = new Actions(Driver.getDriver());

        Action moveOverElement = ac.moveToElement(dropDown).click().build();

        moveOverElement.perform();

        List<WebElement> categories = new Select(Driver.getDriver().findElement(By.id("searchDropdownBox"))).getOptions();


        for (int i = 0; i < categories.size(); i++) {
            if(categories.get(i).getText().equalsIgnoreCase(category)){
                BrowserUtils.clickOnElement(categories.get(i));
                break;
            }
        }


    }

    public void enterText(String text){
        BrowserUtils.enterText(searchBox,text);
    }

    public void clickOnSearch(){

        BrowserUtils.clickOnElement(searchButton);
    }

}
