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
public class TestCase010 {

    private final String SubscriptionEmail = "Email@Subscription.com" + Util.getTimeStamp();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void Subscribe() throws FileNotFoundException
    {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Scrolling Down to Footer And Verifying The Visibility of Subscription
        new HomePage(getDriver()).ScrollDownToFooter();
        Assert.assertTrue(new HomePage(getDriver()).VerifySUBSCRIPTIONText());

        //Entering Email and Verifying Subscription Alert
        new HomePage(getDriver()).EnterSubscriptionEmail(SubscriptionEmail)
                .ClickSubscriptionButton();
        Assert.assertTrue(new HomePage(getDriver()).VerifyVisibilityOfSubscriptionAlert());
    }

    @AfterMethod
    public void quit(){getDriver().quit();
    }
}
