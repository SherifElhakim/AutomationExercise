package Pages;

import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;

public class CartPage {
    private final WebDriver driver;
    public CartPage(WebDriver driver)
    {this.driver = driver;}

    //Locators
    private final By Footer = By.className("col-sm-offset-1");
    private final By SUBSCRIPTION = By.xpath("//h2[text()='Subscription']");
    private final By SubscriptionEmailField = By.id("susbscribe_email");
    private final By SubscribeButton = By.id("subscribe");
    private final By SubscribedSuccessfullyAlert = By.className("alert-success");
    private By SpecificProductDescription(String Index) {
        return By.xpath("//a[contains(@href, '/product_details/" + Index + "')]");
    }
    private By GetCartPriceByIndex(int index) {
        return By.xpath("(//td[@class='cart_price'])[" + index + "]");
    }
    private By GetCartQuantityButtonByIndex(int index) {
        return By.xpath("(//td[@class='cart_quantity']/button)[" + index + "]");
    }
    private By GetTotalPrice(int index) {
        return By.xpath("(//td[@class='cart_total'])[" + index + "]");
    }

    //Actions
    public CartPage ScrollDownToFooter()
    {
        Util.moveToElement(driver, Footer);
        return this;
    }

    public Boolean VerifySUBSCRIPTIONTest()
    {
        return Util.checkVisibilityofElement(driver, SUBSCRIPTION);
    }

    public CartPage EnterSubscriptionEmail(String email)
    {
        Util.SetData(driver, SubscriptionEmailField, email);
        return this;
    }

    public CartPage ClickSubscriptionButton()
    {
        Util.ClickElement(driver,SubscribeButton);
        return this;
    }

    public Boolean VerifyVisibilityOfSubscriptionAlert()
    {
        return Util.checkVisibilityofElement(driver, SubscribedSuccessfullyAlert);
    }

    public Boolean VerifyAdditionOfCorrectProductsToCart(String JsonFile,String i) throws FileNotFoundException
    {
        //LogsUtils.info("first prod desc: "+ DataUtils.getJsonData("FirstProductDetails","ProductDescription")+ " & " +"first in cart desc: "+Util.getText(driver,SpecificProductDescription("1")));
        return Util.getText(driver,SpecificProductDescription(i)).equals(DataUtils.getJsonData(JsonFile,"ProductDescription"));
    }

    public boolean VerifyPricesAreSimilar(String JsonFile,int i) throws FileNotFoundException
    {
        return Util.getText(driver,GetCartPriceByIndex(i)).equals(DataUtils.getJsonData(JsonFile,"ProductPrice"));
    }

    public boolean VerifyQuantitiesAreSimilar(String JsonFile,int i) throws FileNotFoundException
    {
        return Util.getText(driver,GetCartQuantityButtonByIndex(i)).equals(DataUtils.getJsonData(JsonFile,"ProductQuantity"));
    }

    public boolean VerifyTotalPricesAreSimilar(String JsonFile,int i) throws FileNotFoundException
    {
        return Util.getText(driver,GetTotalPrice(i)).equals(DataUtils.getJsonData(JsonFile,"Total"));
    }
}
