package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver)
    {this.driver = driver;}

    //Locators
    private By SpecificProduct(int productIndex){
        return By.xpath("(//a[text()='View Product'])["+productIndex+"]");
    }


    //Actions
    public ProductDetailsPage ClickOnSpecificProduct(int Index)
    {
        Util.ClickElement(driver, SpecificProduct(Index));
        return new ProductDetailsPage(driver);
    }
}
