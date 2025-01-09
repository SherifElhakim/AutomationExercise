package Tests;

import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.DataUtils;
import Utilities.LogsUtils;
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
public class TestCase005 {
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
    public void RegisterUserUsingExistingEmail() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Signup button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifySignupTextVisibility());

        //Entering Already Existing Email and clicking Signup Button
        new LoginPage(getDriver()).SetSignupEmail(DataUtils.getJsonData("ValidLogin","Email"))
                .SetSignupName(DataUtils.getJsonData("ValidLogin","Name"))
                .ClickSignupButton();

        //Verifying Visibility of Email Already Exists Message
        Assert.assertTrue(new LoginPage(getDriver()).VerifyEmailAlreadyExistsVisibility());
    }

    @AfterMethod
    public void quit()
   {
        getDriver().quit();
    }
}
