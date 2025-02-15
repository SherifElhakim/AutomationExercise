package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentDonePage {
    private WebDriver driver;
    public PaymentDonePage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By OrderConfirmedMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private final By ContinueButton = By.xpath("//a[@data-qa='continue-button']");
    private final By DeleteAccountButton = By.className("fa-trash-o");
    private final By DownloadInvoiceButton = By.xpath("//a[text()='Download Invoice']");


    //Actions
    public boolean VerifyOrderConfirmedMessageVisibility()
    {
        return Util.checkVisibilityofElement(driver, OrderConfirmedMessage);
    }

    public HomePage ClickContinueButton()
    {
        Util.checkVisibilityofElement(driver, ContinueButton);
        return new HomePage(driver);
    }

    public DeleteAccountPage ClickDeleteAccountButton()
    {
        Util.ClickElement(driver, DeleteAccountButton);
        return new DeleteAccountPage(driver);
    }

    public PaymentDonePage ClickDownloadInvoiceButton()
    {
        Util.ClickElement(driver, DownloadInvoiceButton);
        return this;
    }
}
