package Tests;

import DriverFactory.DriverFactory;
import Pages.*;
import Utilities.DataUtils;
import Utilities.Util;
import com.github.javafaker.Faker;
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
public class TestCase016 {
    private final String FirstName = new Faker().name().firstName();
    private final String CardNumber = new Faker().number().digits(16);
    private final String CVC = new Faker().number().digits(3);

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void LoginBeforeCheckout() throws FileNotFoundException {
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

        //Adding Product to Cart From HomePage then Clicking Proceed to Checkout and filling data
        new HomePage(getDriver()).AddSpecificProductToCart(1)
                .ClickViewCartButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(),"https://www.automationexercise.com/view_cart"));

        //Clicking Proceed to Checkout and filling data
        new CartPage(getDriver()).ClickProceedToCheckoutButton()
                .VerifyAddressDetailsHeadingVisibility()
                .VerifyReviewOrderHeadingVisibility()
                .EnterComment("This is a Comment")
                .ClickPlaceOrderButton()
                .EnterNameOnCard(FirstName)
                .EnterCardNumber(CardNumber)
                .EnterCVC(CVC)
                .EnterExpirationMonth("September")
                .EnterExpirationYear("2050")
                .ClickConfirmOrder();

        //Verifying Visibility Of OrderConfirmed Message And Deleting Account
        Assert.assertTrue(new PaymentDonePage(getDriver()).VerifyOrderConfirmedMessageVisibility());

//        new PaymentDonePage(getDriver()).ClickDeleteAccountButton();
//        Assert.assertTrue(new DeleteAccountPage(getDriver()).VerifyAccountDeletedTextVisibility());
//        new DeleteAccountPage(getDriver()).ClickContinueButton();
    }

    @AfterMethod
    public void quit()
    {
        getDriver().quit();
    }
}
