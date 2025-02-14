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
public class TestCase019 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void ViewCartBrandProducts() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Products Button Then Verifying Redirection to the Page & Visibility of Brands
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));
        Assert.assertTrue(new ProductsPage(getDriver()).VerifyBrandsVisibility());

        //Clicking On a Brand and Verifying Redirection to the Correct Page
        new ProductsPage(getDriver()).ClickPoloBrand();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/brand_products/Polo"));
        Assert.assertEquals(new ProductsPage(getDriver()).GetCenterTitleText(), "BRAND - POLO PRODUCTS");

        //Clicking On a Different Brand and Verifying Redirection to the Correct Page
        new ProductsPage(getDriver()).ClickHMBrand();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/brand_products/H&M"));
        Assert.assertEquals(new ProductsPage(getDriver()).GetCenterTitleText(), "BRAND - H&M PRODUCTS");

    }
    @AfterMethod
    public void quit() {
        getDriver().quit();
    }
}
