package Tests;

import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;
import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase002 {

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
        LogsUtils.info("Page is redirected to URL");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void LoginUsingExistingAccount() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Login button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifyLoginTextVisibility());

        //Enter Valid Email & Password then Clicking Login
        new LoginPage(getDriver()).SetLoginEmail(DataUtils.getJsonData("ValidLogin.","Email"))
                .SetLoginPassword(DataUtils.getJsonData("ValidLogin.","Password"))
                .ClickLoginButton();

        //Verifying "logged as" text Visibility
        Assert.assertTrue(new HomePage(getDriver()).VerifyLoggedInText());
//        new HomePage(getDriver()).ClickDeleteAccountButton();
//        Assert.assertTrue(new DeleteAccountPage(getDriver()).VerifyAccountDeletedTextVisibility());
    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
