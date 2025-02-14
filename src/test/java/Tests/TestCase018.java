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
public class TestCase018 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void ViewCategoriesProducts() throws FileNotFoundException {
        //Verifying Visibility of HomePage and the Categories Side Panel
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());
        Assert.assertTrue(new HomePage(getDriver()).VerifyCategoriesVisibility());

        //Clicking on Women Category Then Dress And Verifying Redirection to Page And visibility of Text
        new HomePage(getDriver()).ClickWomenCategory()
                .ClickDressSubCategory();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.automationexercise.com/category_products/1");
        Assert.assertTrue(new HomePage(getDriver()).VerifyWomenDressTitleVisibility());

        //Switching to Men's Category And Verifying Redirection to Page
        new HomePage(getDriver()).ClickMenCategory()
                .ClickTShirtsSubCategory();
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.automationexercise.com/category_products/3");
        Assert.assertTrue(new HomePage(getDriver()).VerifyMenTShirtsTitleVisibility());
    }
    @AfterMethod
    public void quit() {
        getDriver().quit();
    }
}
