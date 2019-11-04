package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import WebUIAutomation.Pages.AccountDetails;
import WebUIAutomation.Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountPageTest extends TestBase {

    @Before
    public void loginToAccount()
    {
        LoginPage.UserAndPasswordInput(properties.getProperty("alreadyRegisterUserName"), properties.getProperty("alreadyRegisterPassword"));
        LoginPage.clickingLoginButton();
        Assert.assertTrue ("Unable to login", DriverInitiation.driver.findElement(LoginPage.accountHeader).isDisplayed());
    }

    @Test
    public void ableToClickOnEvents()
    {
        AccountDetails.clickingEventsButton();
        Assert.assertTrue("Something went wrong", DriverInitiation.driver.findElement(AccountDetails.eventHeader).isDisplayed());
        System.out.println("Event page is displayed");
        ableToClickOnHome();
    }

    @Test
    public void ableToClickOnHome()
    {
        AccountDetails.clickingHomeButton();
        Assert.assertTrue("Something went wrong", DriverInitiation.driver.findElement(AccountDetails.accountHeader).isDisplayed());
        System.out.println("Home page is displayed");
    }

    @Test
    public void ableToLogOut()
    {
        AccountDetails.clickingLogOutButton();
        String webTitle = DriverInitiation.driver.getTitle();
        Assert.assertTrue ("Something went wrong!", webTitle.contentEquals("SportsBet Login"));
        System.out.println("User has logged out");
    }

    @Test
    public void ableToSwitchLanguage()
    {
        AccountDetails.selectingDifferentLanguage();
        String hungarianText = DriverInitiation.driver.findElement(AccountDetails.accountHeader).getText();
        Assert.assertTrue("Something went wrong", hungarianText.contentEquals("Fiók részletei"));
        System.out.println("Language has been changed to Hungarian");
    }
}
