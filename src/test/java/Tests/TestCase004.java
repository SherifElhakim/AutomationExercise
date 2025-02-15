package Tests;

import DriverFactory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
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
public class TestCase004 {
    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void LogoutUser() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Login button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifyLoginTextVisibility());

        //Enter Valid Email & Password then Clicking Login
        new LoginPage(getDriver()).SetLoginEmail(DataUtils.getJsonData("ValidLogin","Email"))
                .SetLoginPassword(DataUtils.getJsonData("ValidLogin","Password"))
                .ClickLoginButton();

        //Verifying "logged as" text Visibility
        Assert.assertTrue(new HomePage(getDriver()).VerifyLoggedInText());

        //Logout and Verify Redirection to Login Page
        new HomePage(getDriver()).ClickLogoutButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(),"https://www.automationexercise.com/login"));
    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
