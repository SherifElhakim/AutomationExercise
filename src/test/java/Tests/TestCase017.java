package Tests;

import DriverFactory.DriverFactory;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductsPage;
import Utilities.DataUtils;
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
public class TestCase017 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void RemovingProductsFromCart() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Products Button and Verifying Redirection to the Page
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));

        //Adding Products to Cart And Clicking View Cart Button
        new ProductsPage(getDriver()).AddSpecificProductToCart(1)
                .ClickContinueShoppingButton()
                .AddSpecificProductToCart(3)
                .ClickViewCartButton();

        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(),"https://www.automationexercise.com/view_cart"));

        //Verifying That the First Product in the cart is the first product that was added
        Assert.assertEquals(new CartPage(getDriver()).ReturnProductDescription("1"), DataUtils.getJsonData("FirstProductDetails","ProductDescription"));

        //Removing the First Product & Checking Again
        new CartPage(getDriver()).ClickRemoveButton(1);
        Assert.assertEquals(new CartPage(getDriver()).ReturnProductDescription("2"), DataUtils.getJsonData("SecondProductDetails","ProductDescription"));

        //Removing The Remaining Product & Verifying the Visibility of the Cart is Empty Text
        new CartPage(getDriver()).ClickRemoveButton(2);
        Assert.assertTrue(new CartPage(getDriver()).VerifyEmptyCartTextVisibility());
    }
    @AfterMethod
    public void quit() {getDriver().quit();}
}
