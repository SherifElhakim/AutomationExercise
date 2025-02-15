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
    private final By DeliveryAddress1 = By.xpath("(//ul[@id='address_delivery']/li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[2]");
    private final By DeliveryAddress2 = By.xpath("(//ul[@id='address_delivery']/li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[3]");
    private final By BillingAddress1 = By.xpath("(//ul[@id='address_invoice']/li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[2]");
    private final By BillingAddress2 = By.xpath("(//ul[@id='address_invoice']/li[contains(@class, 'address_address1') and contains(@class, 'address_address2')])[3]");
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

    public String GetFirstDeliveryAddressText()
    {
        return Util.getText(driver, DeliveryAddress1);
    }

    public String GetSecondDeliveryAddressText()
    {
        return Util.getText(driver, DeliveryAddress2);
    }

    public String GetFirstBillingAddressText()
    {
        return Util.getText(driver, BillingAddress1);
    }

    public String GetSecondBillingAddressText()
    {
        return Util.getText(driver, BillingAddress2);
    }

}
