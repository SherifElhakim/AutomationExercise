package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By SignupText = By.xpath("//h2[text()='New User Signup!']");
    private final By SignupName = By.xpath("//input[@data-qa='signup-name']");
    private final By SignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By SignupButton = By.xpath("//button[@data-qa='signup-button']");

    public boolean VerifySignupTextVisibility()
    {
        return Util.checkVisibilityofElement(driver, SignupText);
    }

    public LoginPage SetSignupName (String name)
    {
        Util.SetData(driver, SignupName, name);
        return this;
    }

    public LoginPage SetSignupEmail(String email)
    {
        Util.SetData(driver, SignupEmail, email);
        return this;
    }

    public SignupPage ClickSignupButton()
    {
        Util.ClickElement(driver, SignupButton);
        return new SignupPage(driver);
    }
}
