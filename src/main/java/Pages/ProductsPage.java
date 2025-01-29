package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private WebDriver driver;
    public ProductsPage(WebDriver driver)
    {this.driver = driver;}

    //Locators
    private By clickOnAProduct(int productIndex){
        return By.xpath("(//a[text()='View Product'])["+productIndex+"]");
    }

}
