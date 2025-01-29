package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage {
    private WebDriver driver;
    public DeleteAccountPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By AccountDeletedText = By.xpath("//b[text()='Account Deleted!']");
    private final By ContinueButton = By.xpath("//a[@data-qa='continue-button']");

    //Actions
    public boolean VerifyAccountDeletedTextVisibility()
    {
        return Util.checkVisibilityofElement(driver, AccountDeletedText);
    }

    public HomePage ClickContinueButton()
    {
        Util.ClickElement(driver, ContinueButton);
        return new HomePage(driver);
    }
}
