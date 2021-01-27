package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class ProductDetailPage extends BasePage {

    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;
    @FindBy(xpath = "//span[@id='newBoxPrice'] | //span[@id='price']")
    WebElement newBoxPrice;

    public void clickOnAddToCart(){
        BrowserUtils.clickOnElement(addToCart);
    }

    public String getPrice(){
        return newBoxPrice.getText();
    }

}
