package Tests;

import DriverFactory.DriverFactory;
import Pages.CartPage;
import Pages.HomePage;
import Utilities.Util;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static DriverFactory.DriverFactory.getDriver;

public class TestCase011 {

    private final String SubscriptionEmailCartPage = "Email@Subscription.com" + Util.getTimeStamp();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void SubscribeFromCartPage() throws FileNotFoundException
    {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Click Cart Button
        new HomePage(getDriver()).ClickCartButton();

        //Scrolling Down to Footer And Verifying The Visibility of Subscription
        new CartPage(getDriver()).ScrollDownToFooter();
        Assert.assertTrue(new HomePage(getDriver()).VerifySUBSCRIPTIONTest());

        //Entering Email and Verifying Subscription Alert
        new CartPage(getDriver()).EnterSubscriptionEmail(SubscriptionEmailCartPage)
                .ClickSubscriptionButton();
        Assert.assertTrue(new HomePage(getDriver()).VerifyVisibilityOfSubscriptionAlert());
    }

    @AfterMethod
    public void quit(){getDriver().quit();}
}
