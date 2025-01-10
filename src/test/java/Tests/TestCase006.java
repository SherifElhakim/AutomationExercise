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
import java.nio.file.Paths;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase006 {

    private final String filePath = Paths.get("src/test/resources/ForTestingAttachmentsUpload.txt").toAbsolutePath().toString();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void ContactUsForm() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Contact us Button and Verifying Visibility of Get In Touch Text
        new HomePage(getDriver()).ClickContactusButton();
        Assert.assertTrue(new ContactUsPage(getDriver()).VerifyGetInTouchTextVisibility());

        //Entering Data, Clicking Submit Button and Accepting the Alert
        new ContactUsPage(getDriver()).SetName(DataUtils.getJsonData("ValidLogin","Name"))
                .SetEmail(DataUtils.getJsonData("ValidLogin","Email"))
                .SetSubject("Test Subject")
                .SetMessage("Test Message")
                .UploadAttachment(filePath)
                .ClickSubmitButton()
                .AcceptAlert();

        //Verifying Visibility of Success Message
        Assert.assertTrue(new ContactUsPage(getDriver()).VerifySuccessMsgVisibility());

        //Clicking Home button and verifying Redirection to HomePage
        new ContactUsPage(getDriver()).ClickHomeButton();
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.automationexercise.com/");
    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
