package Tests;

import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Util;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;

import java.io.FileNotFoundException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase020 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        getDriver().manage().window().maximize();
        getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void SearchAndVerifyLogin() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Products Button and Verifying Redirection to the Page
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));

        //Searching For a Product  and Verifying Searched Products Title
        boolean IsRelevant = new ProductsPage(getDriver()).SearchForProduct("blue top")
                .ClickSearchButton()
                .GetProductsNamesOfSearchResults()
                .VerifyRelevantSearchResults("Top");
        Assert.assertTrue(new ProductsPage(getDriver()).VerifyVisibilityOfSearchedItems());

        //Verify Relatable Search Items
        Assert.assertTrue(IsRelevant);

        //Adding Products to Cart And Verifying their Addition
        new ProductsPage(getDriver()).AddSpecificProductToCart(1)
                .ClickViewCartButton();
        Assert.assertTrue(new CartPage(getDriver()).VerifyAdditionOfCorrectProductsToCart("FirstProductDetails","1"));
        Assert.assertTrue(new CartPage(getDriver()).VerifyPricesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyQuantitiesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyTotalPricesAreSimilar("FirstProductDetails",1));

        //Clicking Login button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifyLoginTextVisibility());

        //Enter Valid Email & Password then Clicking Login
        new LoginPage(getDriver()).SetLoginEmail(DataUtils.getJsonData("ValidLogin","Email"))
                .SetLoginPassword(DataUtils.getJsonData("ValidLogin","Password"))
                .ClickLoginButton();

        //Going Back to Cart Page & Rechecking
        new HomePage(getDriver()).ClickCartButton();

        Assert.assertTrue(new CartPage(getDriver()).VerifyAdditionOfCorrectProductsToCart("FirstProductDetails","1"));
        Assert.assertTrue(new CartPage(getDriver()).VerifyPricesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyQuantitiesAreSimilar("FirstProductDetails",1));
        Assert.assertTrue(new CartPage(getDriver()).VerifyTotalPricesAreSimilar("FirstProductDetails",1));
    }

    @AfterMethod
    public void quit (){getDriver().quit();}
}
