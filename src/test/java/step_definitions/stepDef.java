package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.jsoup.Connection;
import org.junit.Assert;
import pages.*;
import utils.ConfigurationReader;
import utils.Driver;

public class stepDef {
    HomePage hp = new HomePage();
    SearchResultPage srp = new SearchResultPage();
    ProductDetailPage pdp = new ProductDetailPage();
    PurchaseVerifyPage pvp = new PurchaseVerifyPage();
    CartPage cp = new CartPage();
    String result="";
    String resul2="";
    String result3="";
    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }


    @Given("User searches {string} as {string}")
    public void user_searches_as(String category, String search) {
        hp.selectCategory(category);
        hp.enterText(search);
        hp.clickOnSearch();



    }
    @Then("User clicks on the {string} option")
    public void userClicksOnTheOption(String list) {

        result=srp.getPrice(list);

        srp.clickOnOption(list);


    }
    @Then("Product page price and Listing price should match")
    public void product_page_price_and_listing_price_should_match() {
        Assert.assertEquals(result,resul2=pdp.getPrice());
    }

    @Then("User click on Add to cart button")
    public void userClickOnAddToCartButton() {
        pdp.clickOnAddToCart();
        pvp.clickOnCartButton();



    }

    @Then("All prices should match")
    public void allPricesShouldMatch() {
        result3=cp.getCartPrice();

        Assert.assertEquals(result,resul2,result3);
    }



}
