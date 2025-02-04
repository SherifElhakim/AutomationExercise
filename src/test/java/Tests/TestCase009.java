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
public class TestCase009 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void SearchProduct() throws FileNotFoundException
    {
    //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

    //Clicking Products Button and Verifying Redirection to the Page
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));

    //Searching For a Product  and Verifying Searched Products Title
       boolean IsRelevant = new ProductsPage(DriverFactory.getDriver()).SearchForProduct("blue top")
                .ClickSearchButton()
                .GetProductsNamesOfSearchResults()
               .VerifyRelevantSearchResults("Top");
        Assert.assertTrue(new ProductsPage(getDriver()).VerifyVisibilityOfSearchedItems());

    //Verify Relatable Search Items
        Assert.assertTrue(IsRelevant);
    }

@AfterMethod
public void quit(){getDriver().quit();}
}
