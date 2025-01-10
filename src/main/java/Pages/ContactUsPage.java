package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    public ContactUsPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By GetInTouchText = By.xpath("//h2[text()='Get In Touch']");
    private final By NameTextField = By.xpath("//input[@data-qa='name']");
    private final By EmailTextField = By.xpath("//input[@data-qa='email']");
    private final By SubjectTextField = By.xpath("//input[@data-qa='subject']");
    private final By MessageTextField = By.xpath("//textarea[@data-qa='message']");
    private final By UploadFileButton = By.name("upload_file");
    private final By SubmitButton = By.xpath("//input[@data-qa='submit-button']");
    private final By SuccessMsg = By.cssSelector(".status.alert.alert-success");
    private final By HomeButton = By.className("btn-success");

    //Actions
    public boolean VerifyGetInTouchTextVisibility()
    {
        return Util.checkVisibilityofElement(driver, GetInTouchText);
    }

    public ContactUsPage SetName(String s)
    {
        Util.SetData(driver,NameTextField,s);
        return this;
    }

    public ContactUsPage SetEmail(String s)
    {
        Util.SetData(driver,EmailTextField,s);
        return this;
    }

    public ContactUsPage SetSubject(String s)
    {
        Util.SetData(driver,SubjectTextField,s);
        return this;
    }

    public ContactUsPage SetMessage(String s)
    {
        Util.SetData(driver,MessageTextField,s);
        return this;
    }

    public ContactUsPage UploadAttachment(String s)
    {
        Util.SetData(driver,UploadFileButton,s);
        return this;
    }

    public ContactUsPage ClickSubmitButton()
    {
        Util.ClickElement(driver,SubmitButton);
        return this;
    }

    public ContactUsPage AcceptAlert()
    {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        return this;
    }

    public boolean VerifySuccessMsgVisibility ()
    {
        return Util.checkVisibilityofElement(driver,SuccessMsg);
    }

    public HomePage ClickHomeButton()
    {
        Util.ClickElement(driver,HomeButton);
        return new HomePage(driver);
    }


}
