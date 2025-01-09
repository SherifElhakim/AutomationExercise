package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.file.Paths;

public class ContactUsPage {
    private WebDriver driver;
    public ContactUsPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By GetInTouchText = By.xpath("//h2[text()='Get In Touch']");

    //Actions
    public boolean CheckVisibilityOfGetInTouchText()
    {
        return Util.checkVisibilityofElement(driver, GetInTouchText);
    }

    String filePath = Paths.get("src/test/resources/test-file.txt").toAbsolutePath().toString();

}
