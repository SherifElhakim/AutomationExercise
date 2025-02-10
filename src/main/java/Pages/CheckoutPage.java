package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;
    public CheckoutPage(WebDriver driver) {this.driver = driver;}

    //locators
    private final By CommentTextArea = By.className("form-control");
    private final By PlaceOrderButton = By.xpath("//a[text()='Place Order']");
    private final By AddressDetailsHeading= By.xpath("//h2[text()='Address Details']");
    private final By ReviewOrderHeading= By.xpath("//h2[text()='Review Your Order']");
    //Actions
    public CheckoutPage VerifyAddressDetailsHeadingVisibility()
    {
        Util.checkVisibilityofElement(driver, AddressDetailsHeading);
        return this;
    }

    public CheckoutPage VerifyReviewOrderHeadingVisibility()
    {
        Util.checkVisibilityofElement(driver, ReviewOrderHeading);
        return this;
    }

    public CheckoutPage EnterComment(String comment)
    {
        Util.SetData(driver, CommentTextArea, comment);
        return this;
    }

    public PaymentPage ClickPlaceOrderButton()
    {
        Util.ClickElement(driver, PlaceOrderButton);
        return new PaymentPage(driver);
    }

}
