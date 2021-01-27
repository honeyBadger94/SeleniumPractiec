package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class PurchaseVerifyPage extends BasePage {

    @FindBy(id = "hlb-view-cart-announce" )
    WebElement cartButton;

    public void clickOnCartButton(){
        BrowserUtils.clickOnElement(cartButton);
    }


}
