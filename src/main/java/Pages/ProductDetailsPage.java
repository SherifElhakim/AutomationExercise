package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private WebDriver driver;
    public ProductDetailsPage(WebDriver driver)
    {this.driver = driver;}

    //Locators
    private final By ProductName = By.cssSelector("div[class='product-information'] > h2");
    private final By productCategory = By.cssSelector("div.product-information p:first-of-type");
    private final By productPrice = By.xpath("//div[@class='product-information']//span//span");
    private final By productAvailability = By.xpath("//div[@class='product-information']//p[2]");
    private final By productCondition = By.xpath("//div[@class='product-information']//p[3]");
    private final By productBrand = By.xpath("//div[@class='product-information']//p[4]");
    private final By QuantityTextField = By.id("quantity");
    private final By AddToCartButton = By.xpath("//button[@class='btn btn-default cart']");
    private final By ViewCartButton = By.xpath("//u[text()='View Cart']");
    private final By ReviewName = By.id("name");
    private final By ReviewEmail = By.id("email");
    private final By ReviewTextBox = By.name("review");
    private final By SubmitReviewButton = By.id("button-review");
    private final By WriteYourReviewText = By.xpath("//a[@href='#reviews']");
    private final By ThankYouForYourReviewText = By.xpath("//span[text()='Thank you for your review.']");

    //Actions
    public boolean VerifyVisibilityOfProductName()
    {
        return Util.checkVisibilityofElement(driver, ProductName);
    }

    public boolean VerifyVisibilityOfProductCategory()
    {
       return Util.checkVisibilityofElement(driver, productCategory);
    }

    public boolean VerifyVisibilityOfProductPrice()
    {
       return Util.checkVisibilityofElement(driver, productPrice);
    }

    public boolean VerifyVisibilityOfProductAvailability()
    {
        return Util.checkVisibilityofElement(driver, productAvailability);
    }

    public boolean VerifyVisibilityOfProductCondition()
    {
        return Util.checkVisibilityofElement(driver, productCondition);
    }

    public boolean VerifyVisibilityOfProductBrand()
    {
       return Util.checkVisibilityofElement(driver, productBrand);
    }

    public ProductDetailsPage EnterQuantity(String quantity)
    {
        Util.clearText(driver, QuantityTextField);
        Util.SetData(driver, QuantityTextField, quantity);
        return this;
    }

    public ProductDetailsPage ClickAddToCart()
    {
        Util.ClickElement(driver, AddToCartButton);
        return this;
    }

    public CartPage ClickViewCartButton()
    {
        Util.ClickElement(driver, ViewCartButton);
        return new CartPage(driver);
    }

    public boolean VerifyWriteYourReviewVisibility()
    {
        return Util.checkVisibilityofElement(driver, WriteYourReviewText);
    }

    public boolean VerifyThankYouForYourReviewVisibility()
    {
        return Util.checkVisibilityofElement(driver, ThankYouForYourReviewText);
    }

    public ProductDetailsPage EnterReviewName(String name)
    {
        Util.SetData(driver, ReviewName, name);
        return this;
    }

    public ProductDetailsPage EnterReviewEmail(String email)
    {
        Util.SetData(driver, ReviewEmail, email);
        return this;
    }

    public ProductDetailsPage EnterReview(String Review)
    {
        Util.SetData(driver, ReviewTextBox, Review);
        return this;
    }

    public ProductDetailsPage ClickSubmitReviewButton()
    {
        Util.ClickElement(driver, SubmitReviewButton);
        return this;
    }
}
