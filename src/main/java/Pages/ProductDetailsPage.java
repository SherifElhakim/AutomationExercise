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

}
