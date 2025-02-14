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
public class TestCase022 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void AddRecommendedProductsToCart() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());
        Assert.assertTrue(new HomePage(getDriver()).VerifyRecommendedProductsVisibility());

        //Adding Products to Cart And Clicking View Cart Button
        new HomePage(getDriver()).AddRecommendedItemToCart(4);



    }

    @AfterMethod
    public void quit()
    {
        //getDriver().quit();
    }
}