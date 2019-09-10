package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import WebUIAutomation.Pages.LoginPage;
import WebUIAutomation.Pages.RegistrationPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPageTest {

    static By accountHeader = By.xpath("//*[@id=\"player-info\"]/div");
    static By aNumberField = By.xpath("//*[@id=\"account-box\"]/form/div[7]/input");

    @Before
    public void startBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Luisa_Fernanda_Munoz\\Downloads\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        DriverInitiation.startingBrowser();
        LoginPage.clickingSingupLink();
    }

    @Test
    public void registrationSuccessful()
    {
        RegistrationPage.fillingForm("Test123", "ATM2019", "987654321","Test123", "Test123" );
        RegistrationPage.clickingSaveButton();
        Assert.assertTrue ("Unable to register", DriverInitiation.driver.findElement(accountHeader).isDisplayed());
        System.out.println("User has registered successfully, account details are shown");
    }

    @Test
    public void unableToRegisterAlreadyExistingOne()
    {
        RegistrationPage.fillingForm("Test123", "ATM2019", "987654321","Test123", "Test123" );
        RegistrationPage.clickingSaveButton();
        WebElement existingNotification = DriverInitiation.driver.findElement(By.xpath("//*[@id=\"account-box\"]/form/div[3]"));
        String textExisting = existingNotification.getAttribute("innerHTML");                                           //Using 'innerHTML' to get the exact message that is displayed
        Assert.assertTrue("Something went wrong!", textExisting.contentEquals("This username is already in user."));
        System.out.println("Existing user cannot register again!");
    }

    @Test
    public void unableToRegisterWithEmptyFields() //Ask Zsuzsi what is the most efficient and fastest way to check for every individual textbox or at least those mandatories
    {
        RegistrationPage.clickingSaveButton();
        String mss = DriverInitiation.driver.findElement(By.name("userName")).getAttribute("validationMessage");
        Assert.assertTrue("Something went wrong!", mss.contentEquals("Please fill out this field."));           //Using 'validationMessage'
        System.out.println("Please fill the requested fields!");
    }

    @Test
    public void unableToEnterStringCharacterOnAccountNumberField()
    {
        DriverInitiation.driver.findElement(aNumberField).sendKeys("123");
        WebElement validANNotification = DriverInitiation.driver.findElement(By.xpath("//*[@id=\"account-box\"]/form/div[8]"));
        String textExisting = validANNotification.getAttribute("innerHTML");
        Assert.assertTrue("Something went wrong!", textExisting.contentEquals("Please enter valid account number"));
    }

    @Test
    public void passwordFieldsMustMatchIsBeingValidated() //Ask Zsuzsi what is the most efficient way to do it, is it need to compare the exact string of the message??
    {
        WebElement pssw1Field = DriverInitiation.driver.findElement(By.xpath("//*[@id=\"account-box\"]/form/div[11]/input"));
        WebElement pssw2Field = DriverInitiation.driver.findElement(By.xpath("//*[@id=\"account-box\"]/form/div[12]/input"));
        pssw1Field.sendKeys("123456789");
        pssw2Field.sendKeys("12345678");
        String pssw1Text = pssw1Field.getAttribute("value");
        String pssw2Text = pssw2Field.getAttribute("value");
        if (pssw1Text != pssw2Text)
        {
            WebElement NotMatchNotification = DriverInitiation.driver.findElement(By.xpath("//*[@id=\"account-box\"]/form/div[13]"));
            Assert.assertTrue(NotMatchNotification.isDisplayed());
            String textNoMatch = NotMatchNotification.getAttribute("innerHTML");
            Assert.assertTrue("Something went wrong!", textNoMatch.contentEquals("Password doesn't match."));
        }
        System.out.println("Password fields must match");
    }
}
