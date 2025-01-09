package Tests;

import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;
import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import Utilities.Util;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase003 {

    private final String InvalidEmail = "InvalidMail@Invalid.com" + Util.getTimeStamp();
    private final String InvalidPassword = "InvalidPassword" + Util.getTimeStamp();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void LoginUsingIncorrectData() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Login button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifyLoginTextVisibility());

        //Enter Valid Email & Password then Clicking Login
        new LoginPage(getDriver()).SetLoginEmail(InvalidEmail)
                .SetLoginPassword(InvalidPassword)
                .ClickLoginButton();

        LogsUtils.info("Invalid Email for this Test Case is " + InvalidEmail);
        LogsUtils.info("Invalid Password for this Test Case is " + InvalidPassword);

        //Verifying Validation Message Visibility
        Assert.assertTrue(new LoginPage(getDriver()).VerifyValidationMessageVisibility());
    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
