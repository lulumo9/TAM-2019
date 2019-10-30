package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import WebUIAutomation.Pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginPageTest extends TestBase{

    @Test
    public void pageIsDisplayed()
    {
        String webTitle = DriverInitiation.driver.getTitle();
        Assert.assertTrue ("Something went wrong!", webTitle.contentEquals("SportsBet Login"));
        System.out.println("Login page is displayed, please proceed to sign up or sign in");
    }

    @Test
    public void ableToClickSignUp()
    {
        LoginPage.clickingSingupLink();
        String boxTitle = DriverInitiation.driver.findElement(By.className("box-header")).getText();
        Assert.assertTrue("Something went wrong!", boxTitle.contentEquals("Player Registration") );
        System.out.println("Registration form is shown, please proceed");
    }

    @Test
    public void ableToClickSignIn()
    {
        LoginPage.clickingSigninLink();
        String webTitle = DriverInitiation.driver.getTitle();
        Assert.assertTrue ("Something went wrong!", webTitle.contentEquals("SportsBet Login"));
        System.out.println("Please proceed to sign in");
    }

    @Test
    public void ableToLogin()
    {
        LoginPage.UserAndPasswordInput(properties.getProperty("alreadyRegisterUserName"), properties.getProperty("alreadyRegisterPassword"));
        LoginPage.clickingLoginButton();
        Assert.assertTrue ("Unable to login", DriverInitiation.driver.findElement(LoginPage.accountHeader).isDisplayed());
        System.out.println("User has login, account details are shown");
    }

    @Test
    public void UnableToLoginWithIncorrectCredentials()
    {
        LoginPage.UserAndPasswordInput(properties.getProperty("alreadyRegisterUserName"), properties.getProperty("incorrectPassword"));
        LoginPage.clickingLoginButton();
        Assert.assertTrue(DriverInitiation.driver.findElement(LoginPage.incorrectNotification).isEnabled());
        System.out.println("Unable to login with incorrect credentials");
    }

    @Test
    public void unableToLoginWithAnyEmptyField()
    {
        LoginPage.gettingTextInFields();
        if (LoginPage.userFieldText.isEmpty() || LoginPage.psswFieldText.isEmpty())
        {
            Assert.assertTrue(DriverInitiation.driver.findElement(LoginPage.incorrectNotification).isEnabled());
        }
        System.out.println("Unable to login with empty fields");
    }
}
