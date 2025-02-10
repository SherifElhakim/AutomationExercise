package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  {

    private final WebDriver driver;
    public HomePage(WebDriver driver)
    {this.driver = driver;}

    //Locators
    private final By HomePageImgCarousel = By.xpath("//div[@class='item active']//img[@alt='demo website for practice']");
    private final By SignupLoginButton = By.xpath("//a[@href='/login']");
    private final By LoggedInAsText = By.className("fa-user");
    private final By DeleteAccountButton = By.className("fa-trash-o");
    private final By logoutButton = By.xpath("//a[@href='/logout']");
    private final By ContactUsButton = By.ByClassName.className("fa-envelope");
    private final By TestCasesButton = By.xpath("//a[text()=' Test Cases']");
    private final By ProductsButton = By.className("card_travel");
    private final By Footer = By.className("col-sm-offset-1");
    private final By SUBSCRIPTION = By.xpath("//h2[text()='Subscription']");
    private final By SubscriptionEmailField = By.id("susbscribe_email");
    private final By SubscribeButton = By.id("subscribe");
    private final By SubscribedSuccessfullyAlert = By.className("alert-success");
    private final By CartButton = By.xpath("//a[text()=' Cart']");
    private By SpecificProductAddToCart(int productIndex) {
        return By.xpath("(//a[text()='Add to cart'])["+productIndex+"]");
    }
    private final By ViewCartButton = By.xpath("//u[text()='View Cart']");

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

    public HomePage ClickTestCasesButton()
    {
        Util.ClickElement(driver, TestCasesButton);
        return this;
    }

    public ProductsPage ClickProductsButton()
    {
        Util.ClickElement(driver, ProductsButton);
        return new ProductsPage(driver);
    }

    public HomePage ScrollDownToFooter()
    {
        Util.moveToElement(driver, Footer);
        return this;
    }

    public Boolean VerifySUBSCRIPTIONTest()
    {
       return Util.checkVisibilityofElement(driver, SUBSCRIPTION);
    }

    public HomePage EnterSubscriptionEmail(String email)
    {
        Util.SetData(driver, SubscriptionEmailField, email);
        return this;
    }

    public HomePage ClickSubscriptionButton()
    {
        Util.ClickElement(driver,SubscribeButton);
        return this;
    }

    public Boolean VerifyVisibilityOfSubscriptionAlert()
    {
        return Util.checkVisibilityofElement(driver, SubscribedSuccessfullyAlert);
    }

    public CartPage ClickCartButton()
    {
        Util.moveToElement(driver,CartButton);
        Util.ClickElement(driver,CartButton);
        return new CartPage(driver);
    }

    public HomePage AddSpecificProductToCart(int Index)
    {
        Util.moveToElement(driver,SpecificProductAddToCart(Index));
        Util.ClickElement(driver, SpecificProductAddToCart(Index));
        return this;
    }

    public CartPage ClickViewCartButton()
    {
        Util.ClickElement(driver, ViewCartButton);
        return new CartPage(driver);
    }

}
