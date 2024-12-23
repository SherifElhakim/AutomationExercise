package Tests;

import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;
import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.LogsUtils;
import Utilities.Util;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Listeners;

import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase001 {

    private final String UniqueSignupName = "User" + Util.getTimeStamp();
    private final String UniqueSignupEmail = "Email@gmail.com" + Util.getTimeStamp();
    private final String zipcode = new Faker().number().digits(5);
    private final String FirstName = new Faker().name().firstName();
    private final String LastName = new Faker().name().lastName();
    private final String MobNum = new Faker().number().digits(11);

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
    public void RegisterUser() {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Signup button and Verifying the Visibility of Login Page
        new HomePage(getDriver()).ClickSignupButton();
        Assert.assertTrue(new LoginPage(getDriver()).VerifySignupTextVisibility());

        //Entering Unique Username and Email and clicking Signup Button
        LogsUtils.info("Username For this Test Case is " + UniqueSignupName);
        LogsUtils.info("Username For this Test Case is " + UniqueSignupEmail);
        new LoginPage(getDriver()).SetSignupName(UniqueSignupName)
                .SetSignupEmail(UniqueSignupEmail)
                .ClickSignupButton();

        //Verifying Visibility of ENTER ACCOUNT INFORMATION
        Assert.assertTrue(new SignupPage(getDriver()).CheckEnterAccInfoVisibility());

        //Fill in Data
        new SignupPage(getDriver()).ChooseTitle("Male")
                .SetPassword("123456")
                .ChooseDayOfBirth("28")
                .ChooseMonthOfBirth("July")
                .ChooseYearOfBirth("2000")
                .ClickOnSignupForNewsLetterCheckBox()
                .ClickOnReceiveSpecialOffersCheckBox()
                .SetFirstName(FirstName)
                .SetLastName(LastName)
                .SetCompany("Company")
                .SetAddress("Address1")
                .SetAddress2("Address2")
                .ChooseCountry("Canada")
                .SetState("State")
                .SetCity("City")
                .SetZipcode(zipcode)
                .SetMobileNumber(MobNum)
                .ClickCreateAccountButton();
        LogsUtils.info("Full name For this Test Case is " + FirstName + " " + LastName);
        LogsUtils.info("ZipCode For this Test Case is " + zipcode);
        LogsUtils.info("Mobile Number For this Test Case is " + MobNum);

        //Verifying Account Created Visibility And Clicking Continue to be Redirected Back to HomePage
        Assert.assertTrue(new AccountCreatedPage(getDriver()).VerifyAccountCreatedTextVisibility());
        new AccountCreatedPage(getDriver()).ClickContinueButton();

        //Verifying "logged as" text Visibility and Deleting Account
        Assert.assertTrue(new HomePage(getDriver()).VerifyLoggedInText());
        new HomePage(getDriver()).ClickDeleteAccountButton();
        Assert.assertTrue(new DeleteAccountPage(getDriver()).VerifyAccountDeletedTextVisibility());

    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
