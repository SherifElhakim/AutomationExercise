package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage {
    private WebDriver driver;
    public PaymentPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By NameOnCardTextField = By.name("name_on_card");
    private final By CardNumberTextField = By.name("card_number");
    private final By CVCTextField = By.name("cvc");
    private final By ExpirationMonthTextField = By.name("expiry_month");
    private final By ExpirationYearTextField = By.name("expiry_year");
    private final By ConfirmOrderButton = By.id("submit");

    //Actions
    public PaymentPage EnterNameOnCard(String Name)
    {
        Util.SetData(driver, NameOnCardTextField, Name);
        return this;
    }

    public PaymentPage EnterCardNumber(String CardNumber)
    {
        Util.SetData(driver, CardNumberTextField, CardNumber);
        return this;
    }

    public PaymentPage EnterCVC(String CVC)
    {
        Util.SetData(driver, CVCTextField, CVC);
        return this;
    }

    public PaymentPage EnterExpirationMonth(String Month)
    {
        Util.SetData(driver, ExpirationMonthTextField, Month);
        return this;
    }

    public PaymentPage EnterExpirationYear(String Year)
    {
        Util.SetData(driver, ExpirationYearTextField, Year);
        return this;
    }

    public PaymentDonePage ClickConfirmOrder()
    {
        Util.ClickElement(driver, ConfirmOrderButton);
        return new PaymentDonePage(driver);
    }
}
