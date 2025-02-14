package Tests;

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
import Listeners.ITestResultListenerClass;
import Listeners.IinvokedListenerClass;

import java.io.FileNotFoundException;
import java.time.Duration;

import static DriverFactory.DriverFactory.getDriver;

@Listeners({IinvokedListenerClass.class, ITestResultListenerClass.class})
public class TestCase021 {

    private final String ReviewName = new Faker().name().fullName();
    private final String ReviewEmail = "Email@gmail.com" + Util.getTimeStamp();

    @BeforeMethod
    public void setUp()
    {
        DriverFactory.setupDriver("chrome");
        DriverFactory.getDriver().manage().window().maximize();
        DriverFactory.getDriver().get("https://www.automationexercise.com/");
    }

    @Test
    public void AddReviewOnProduct() throws FileNotFoundException {
        //Verifying Visibility of HomePage
        Assert.assertTrue(new HomePage(getDriver()).VerifyHomePageVisibility());

        //Clicking Products Button and Verifying Redirection to the Page
        new HomePage(getDriver()).ClickProductsButton();
        Assert.assertTrue(Util.VerifyRedirectToPage(getDriver(), "https://www.automationexercise.com/products"));

        //Clicking on a Specific Product to Be Redirected to Product Details Page
        new ProductsPage(getDriver()).ClickOnSpecificProduct(30);

        //Verify Visibility of Product Details
        Assert.assertTrue(new ProductDetailsPage(getDriver()).VerifyWriteYourReviewVisibility());

        //Submit Review & Verifying That ThankYou Message is Displayed
        new ProductDetailsPage(getDriver()).EnterReviewName(ReviewName)
                        .EnterReviewEmail(ReviewEmail)
                        .EnterReview("Great Product!")
                        .ClickSubmitReviewButton();
        Assert.assertTrue(new ProductDetailsPage(getDriver()).VerifyThankYouForYourReviewVisibility());
    }

    @AfterMethod
    public void quit() {getDriver().quit();}
}
