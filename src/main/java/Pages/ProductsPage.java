package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver)
    {this.driver = driver;}

    List<WebElement> products ;
    List<WebElement> productsName;
    List<String> productName ;

    //Locators
    private By SpecificProduct(int productIndex){
        return By.xpath("(//a[text()='View Product'])["+productIndex+"]");
    }
    private By SpecificProductAddToCart(int productIndex) {
        return By.xpath("(//a[text()='Add to cart'])["+productIndex+"]");
    }
    private By SearchBar = By.className("input-lg");
    private By SearchButton = By.id("submit_search");
    private By SearchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private final By AllProducts = By.cssSelector("div[class*='productinfo']");
    private final By AllProductsName = By.cssSelector("div[class*='productinfo'] > p");
    private final By ContinueShoppingButton = By.className("btn-block");
    private final By ViewCartButton = By.xpath("//u[text()='View Cart']");
    private final By Brands = By.className("brands_products");
    private final By PoloBrand = By.xpath("//a[text()='Polo']");
    private final By HMBrand = By.xpath("//a[text()='H&M']");
    private final By CenterTitleText = By.cssSelector(".title.text-center");


    //Actions
    public ProductDetailsPage ClickOnSpecificProduct(int Index)
    {
        Util.moveToElement(driver,SpecificProduct(Index));
        Util.ClickElement(driver, SpecificProduct(Index));
        return new ProductDetailsPage(driver);
    }

    public ProductsPage AddSpecificProductToCart(int Index)
    {
        Util.moveToElement(driver,SpecificProductAddToCart(Index));
        Util.ClickElement(driver, SpecificProductAddToCart(Index));
        return new ProductsPage(driver);
    }

    public ProductsPage SearchForProduct(String ProductName)
    {
        Util.SetData(driver, SearchBar, ProductName);
        return this;
    }

    public ProductsPage ClickContinueShoppingButton()
    {
        Util.ClickElement(driver, ContinueShoppingButton);
        return this;
    }

    public CartPage ClickViewCartButton()
    {
        Util.ClickElement(driver, ViewCartButton);
        return new CartPage(driver);
    }

    public ProductsPage ClickSearchButton()
    {
        Util.ClickElement(driver, SearchButton);
        return this;
    }

    public boolean VerifyVisibilityOfSearchedItems()
    {
        return Util.checkVisibilityofElement(driver, SearchedProductsTitle);
    }

    public ProductsPage GetProductsNamesOfSearchResults()
    {
        productsName = driver.findElements(AllProductsName);
        productName = new ArrayList<>();
        for (WebElement element : productsName)
        {
            productName.add(element.getText());
        }
        return this;
    }

    public boolean VerifyRelevantSearchResults(String ProductName) throws FileNotFoundException
    {
        for (String name : productName)
        {
            if (!name.contains(ProductName))
                return false ;
        }
        return true ;
    }

    public boolean VerifyBrandsVisibility()
    {
        return Util.checkVisibilityofElement(driver, Brands);
    }

    public ProductsPage ClickPoloBrand()
    {
        Util.ClickElement(driver, PoloBrand);
        return this;
    }

    public ProductsPage ClickHMBrand()
    {
        Util.ClickElement(driver, HMBrand);
        return this;
    }

    public String GetCenterTitleText()
    {
        return Util.getText(driver, CenterTitleText);
    }

}
