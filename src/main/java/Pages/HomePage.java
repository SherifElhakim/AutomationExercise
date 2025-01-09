package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  {

    private final WebDriver driver;
    public HomePage(WebDriver driver) {
        super();
        this.driver = driver;}

    //Locators
    private final By HomePageImgCarousel = By.xpath("//div[@class='item active']//img[@alt='demo website for practice']");
    private final By SignupLoginButton = By.xpath("//a[@href='/login']");
    private final By LoggedInAsText = By.className("fa-user");
    private final By DeleteAccountButton = By.className("fa-trash-o");
    private final By logoutButton = By.xpath("//a[@href='/logout']");
    private final By ContactUsButton = By.ByClassName.className("fa-envelope");

    //Actions
    public boolean VerifyHomePageVisibility()
    {
        return Util.checkVisibilityofElement(driver, HomePageImgCarousel);
    }

    public boolean VerifyLoggedInText()
    {
        return Util.checkVisibilityofElement(driver, LoggedInAsText);
    }

    public LoginPage ClickSignupButton()
    {
        Util.ClickElement(driver, SignupLoginButton);
        return new LoginPage(driver);
    }

    public boolean VerifyDeleteAccountButtonVisibility()
    {
        return Util.checkVisibilityofElement(driver, DeleteAccountButton);
    }

    public DeleteAccountPage ClickDeleteAccountButton()
    {
        Util.ClickElement(driver, DeleteAccountButton);
        return new DeleteAccountPage(driver);
    }

    public LoginPage ClickLogoutButton()
    {
        Util.ClickElement(driver, logoutButton);
        return new LoginPage(driver);
    }

    public ContactUsPage ClickContactusButton()
    {
        Util.ClickElement(driver, ContactUsButton);
        return new ContactUsPage(driver);
    }

}
