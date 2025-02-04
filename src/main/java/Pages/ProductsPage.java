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
    private By SearchBar = By.className("input-lg");
    private By SearchButton = By.id("submit_search");
    private By SearchedProductsTitle = By.xpath("//h2[text()='Searched Products']");
    private final By AllProducts = By.cssSelector("div[class*='productinfo']");
    private final By AllProductsName = By.cssSelector("div[class*='productinfo'] > p");


    //Actions
    public ProductDetailsPage ClickOnSpecificProduct(int Index)
    {
        Util.moveToElement(driver,SpecificProduct(Index));
        Util.ClickElement(driver, SpecificProduct(Index));
        return new ProductDetailsPage(driver);
    }

    public ProductsPage SearchForProduct(String ProductName)
    {
        Util.SetData(driver, SearchBar, ProductName);
        return this;
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
}
