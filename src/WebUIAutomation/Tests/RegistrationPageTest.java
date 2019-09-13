package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import WebUIAutomation.Pages.LoginPage;
import WebUIAutomation.Pages.RegistrationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationPageTest extends TestBase {

    @Before
    public void clickingRegistrationLink()
    {
        LoginPage.clickingSingupLink();
    }

    @Test
    public void registrationSuccessful()
    {
        RegistrationPage.fillingForm(properties.getProperty("newUserName"), properties.getProperty("newName"), properties.getProperty("newAccountNumber"), properties.getProperty("newPassword"), properties.getProperty("newPassword2"));
        RegistrationPage.clickingSaveButton();
        Assert.assertTrue("Unable to register", DriverInitiation.driver.findElement(RegistrationPage.accountHeader).isDisplayed());
        System.out.println("User has registered successfully, account details are shown");
    }

    @Test
    public void unableToRegisterAlreadyExistingOne()
    {
        RegistrationPage.fillingForm(properties.getProperty("newUserName"), properties.getProperty("newName"), properties.getProperty("newAccountNumber"), properties.getProperty("newPassword"), properties.getProperty("newPassword2"));
        RegistrationPage.clickingSaveButton();
        RegistrationPage.validatingMessageAlreadyRegisteredUser();
        Assert.assertTrue("Something went wrong!", RegistrationPage.AlreadyRegisterMss.contentEquals("This username is already in user."));
        System.out.println("Existing user cannot register again!");
    }

    @Test
    public void unableToEnterStringCharacterOnAccountNumberField()
    {
        DriverInitiation.driver.findElement(RegistrationPage.aNumberField).sendKeys("ABC");
        RegistrationPage.validatingMessageValidAccountNumber();
        Assert.assertTrue("Something went wrong!", RegistrationPage.ValidAccountMss.contentEquals("Please enter valid account number."));
        System.out.println("Please enter a valida account number");
    }

    @Test
    public void passwordFieldsMustMatchIsBeingValidated()
    {
        RegistrationPage.fillingPasswordFields();
        if (RegistrationPage.pssw1Text != RegistrationPage.pssw2Text)
        {
            RegistrationPage.validatingMessageNotMatch();
            Assert.assertTrue("Something went wrong!", RegistrationPage.textNoMatch.contentEquals("Password doesn't match."));
        }
        System.out.println("Password fields must match");
    }
}



