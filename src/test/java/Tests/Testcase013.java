package Tests;

import DriverFactory.DriverFactory;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductsPage;
import Utilities.Util;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;

import java.io.FileNotFoundException;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class Testcase013 {

    private final String Quantity = "4";

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void VerifyProductQuantityInCart() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Products Button and Verifying Redirection to the Page
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));

        //Clicking on a Specific Product And Adding A Specific Quantity to the Cart
        new ProductsPage(getDriver()).ClickOnSpecificProduct(1)
                .EnterQuantity(Quantity)
                .ClickAddToCart()
                .ClickViewCartButton();

        //Verifying That the Amount in the Cart is the Correct Amount
        Assert.assertTrue(new CartPage(getDriver()).VerifyProductQuantity(1,Quantity));

    }

    @AfterMethod
    public void quit() {
        getDriver().quit();
    }
}
