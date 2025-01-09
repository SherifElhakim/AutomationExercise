package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    public LoginPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By SignupText = By.xpath("//h2[text()='New User Signup!']");
    private final By LoginText = By.xpath("//h2[text()='Login to your account']");
    private final By SignupName = By.xpath("//input[@data-qa='signup-name']");
    private final By SignupEmail = By.xpath("//input[@data-qa='signup-email']");
    private final By SignupButton = By.xpath("//button[@data-qa='signup-button']");
    private final By LoginEmail = By.xpath("//input[@data-qa='login-email']");
    private final By LoginPassword = By.xpath("//input[@data-qa='login-password']");
    private final By LoginButton = By.xpath("//button[@data-qa='login-button']");
    private final By ValidationMsg = By.xpath("//p[text()='Your email or password is incorrect!']");
    private final By EmailExistsMsg = By.xpath("//p[text()='Email Address already exist!']");

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

    public boolean VerifyLoginTextVisibility()
    {
        return Util.checkVisibilityofElement(driver, LoginText);
    }

    public LoginPage SetLoginEmail(String email)
    {
        Util.SetData(driver, LoginEmail, email);
        return this;
    }

    public LoginPage SetLoginPassword(String pw)
    {
        Util.SetData(driver, LoginPassword, pw);
        return this;
    }

    public HomePage ClickLoginButton()
    {
        Util.ClickElement(driver, LoginButton);
        return new HomePage(driver);
    }

    public boolean VerifyValidationMessageVisibility()
    {
        return Util.checkVisibilityofElement(driver, ValidationMsg);
    }

    public boolean VerifyEmailAlreadyExistsVisibility()
    {
        return Util.checkVisibilityofElement(driver, EmailExistsMsg);
    }
}
