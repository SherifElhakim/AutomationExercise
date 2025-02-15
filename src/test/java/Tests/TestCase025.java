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
public class TestCase025 {

    private final String SubscriptionEmail = "Email@Subscription.com" + Util.getTimeStamp();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void VerifyScrollUpUsingArrow() throws FileNotFoundException
    {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Scrolling Down to Footer And Verifying The Visibility of Subscription
        new HomePage(getDriver()).ScrollToBottom();
        Assert.assertTrue(new HomePage(getDriver()).VerifySUBSCRIPTIONText());

        //Clicking Scroll Up Arrow & Verifying Text Visibility
        new HomePage(getDriver()).ClickScrollUpButton();
        Assert.assertTrue(new HomePage(getDriver()).VerifyCarouselTextVisibility());
    }

    @AfterMethod
    public void quit(){
        getDriver().quit();
    }
}
