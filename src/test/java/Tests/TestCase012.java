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
public class TestCase012 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void AddProductsToCart() throws FileNotFoundException {
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

//        Verifying Similarity of The Data
        Assert.assertTrue(new CartPage(getDriver()).VerifyAdditionOfCorrectProductsToCart("FirstProductDetails","1"));
        Assert.assertTrue(new CartPage(getDriver()).VerifyAdditionOfCorrectProductsToCart("SecondProductDetails","2"));

        Assert.assertTrue(new CartPage(getDriver()).VerifyPricesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyPricesAreSimilar("SecondProductDetails",2));
        Assert.assertTrue(new CartPage(getDriver()).VerifyQuantitiesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyQuantitiesAreSimilar("SecondProductDetails",2));
        Assert.assertTrue(new CartPage(getDriver()).VerifyTotalPricesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyTotalPricesAreSimilar("SecondProductDetails",2));
    }

    @AfterMethod
    public void quit() {getDriver().quit();}
}