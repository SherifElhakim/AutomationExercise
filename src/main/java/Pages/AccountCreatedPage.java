package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private WebDriver driver;
    public AccountCreatedPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By AccountCratedText = By.xpath("//b[text()='Account Created!']");
    private final By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean VerifyAccountCreatedTextVisibility()
    {
        return Util.checkVisibilityofElement(driver, AccountCratedText);
    }

    public HomePage ClickContinueButton()
    {
        Util.ClickElement(driver, ContinueButton);
        return new HomePage(driver);
    }
}
