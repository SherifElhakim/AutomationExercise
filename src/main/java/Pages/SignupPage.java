package Pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    private WebDriver driver;
    public SignupPage(WebDriver driver) {this.driver = driver;}

    //Locators
    private final By EnterAccInfo = By.xpath("//b[text()='Enter Account Information']");
    private final By GenderRadioButtonLocator(String gender)
    {
        String i;
        if(gender.equals("Male")) i="1";
        else  i="2";
        return By.id("id_gender"+ i);
    }
    private final By NameTextFieldLocator = By.xpath("//input[@data-qa='name']");
    private final By EmailTextFieldLocator = By.xpath("//input[@data-qa='email']");
    private final By PasswordTextFieldLocator = By.xpath("//input[@data-qa='password']");
    private final By DaysDropDownListLocator = By.id("days");
    private final By MonthsDropDownListLocator = By.id("months");
    private final By YearsDropDownListLocator = By.id("years");
    private final By NewsLetterCheckBoxLocator = By.id("newsletter");
    private final By SpecialOffersCheckBoxLocator = By.id("optin");
    private final By FnameTextFieldLocator = By.xpath("//input[@data-qa='first_name']");
    private final By LnameTextFieldLocator = By.xpath("//input[@data-qa='last_name']");
    private final By CompanyTextFieldLocator = By.xpath("//input[@data-qa='company']");
    private final By AddressTextFieldLocator = By.xpath("//input[@data-qa='address']");
    private final By Address2TextFieldLocator = By.xpath("//input[@data-qa='address2']");
    private final By CountryDropDownListLocator = By.id("country");
    private final By StateTextFieldLocator = By.xpath("//input[@data-qa='state']");
    private final By CityTextFieldLocator = By.xpath("//input[@data-qa='city']");
    private final By ZipCodeTextFieldLocator = By.xpath("//input[@data-qa='zipcode']");
    private final By MobileTextFieldLocator = By.xpath("//input[@data-qa='mobile_number']");
    private final By CreateAccountButtonLocator = By.xpath("//button[@data-qa='create-account']");
    private final By EmailExistsMsg = By.xpath("//p[text()='Email Address already exist!']");

    public boolean CheckEnterAccInfoVisibility()
    {
        return Util.checkVisibilityofElement(driver, EnterAccInfo);
    }

    public SignupPage ChooseTitle(String title)
    {
        Util.ClickElement(driver,GenderRadioButtonLocator(title));
        return this;
    }

    public SignupPage SetName(String name)
    {
        Util.SetData(driver,NameTextFieldLocator,name);
        return this;
    }

    public SignupPage SetEmail(String email)
    {
        Util.SetData(driver,EmailTextFieldLocator,email);
        return this;
    }

    public SignupPage SetPassword(String pw)
    {
        Util.SetData(driver,PasswordTextFieldLocator,pw);
        return this;
    }

    public SignupPage ChooseDayOfBirth(String day)
    {
        Util.SelectingFromDropDown(driver,DaysDropDownListLocator,day);
        return this;
    }

    public SignupPage ChooseMonthOfBirth(String month)
    {
        Util.SelectingFromDropDown(driver,MonthsDropDownListLocator,month);
        return this;
    }

    public SignupPage ChooseYearOfBirth(String year)
    {
        Util.SelectingFromDropDown(driver,  YearsDropDownListLocator,year);
        return this;
    }

    public SignupPage ClickOnSignupForNewsLetterCheckBox()
    {
        Util.ClickElement(driver, NewsLetterCheckBoxLocator);
        return this;
    }

    public SignupPage ClickOnReceiveSpecialOffersCheckBox()
    {
        Util.ClickElement(driver,SpecialOffersCheckBoxLocator );
        return this;
    }

    public SignupPage SetFirstName(String Fname)
    {
        Util.SetData(driver,FnameTextFieldLocator,Fname);
        return this;
    }

    public SignupPage SetLastName(String Lname)
    {
        Util.SetData(driver,LnameTextFieldLocator,Lname);
        return this;
    }

    public SignupPage SetCompany(String company)
    {
        Util.SetData(driver,CompanyTextFieldLocator,company);
        return this;
    }

    public SignupPage SetAddress(String address)
    {
        Util.SetData(driver,AddressTextFieldLocator,address);
        return this;
    }

    public SignupPage SetAddress2(String address2)
    {
        Util.SetData(driver,Address2TextFieldLocator,address2);
        return this;
    }

    public SignupPage ChooseCountry(String country)
    {
        Util.SelectingFromDropDown(driver,CountryDropDownListLocator,country);
        return this;
    }

    public SignupPage SetState(String state)
    {
        Util.SetData(driver,StateTextFieldLocator,state);
        return this;
    }

    public SignupPage SetCity(String city)
    {
        Util.SetData(driver,CityTextFieldLocator,city);
        return this;
    }

    public SignupPage SetZipcode(String zipcode)
    {
        Util.SetData(driver,ZipCodeTextFieldLocator,zipcode);
        return this;
    }

    public SignupPage SetMobileNumber(String num)
    {
        Util.SetData(driver,MobileTextFieldLocator,num);
        return this;
    }

    public AccountCreatedPage ClickCreateAccountButton()
    {
        Util.ClickElement(driver, CreateAccountButtonLocator);
        return new AccountCreatedPage(driver);
    }

}
