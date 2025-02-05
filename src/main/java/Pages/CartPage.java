package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
