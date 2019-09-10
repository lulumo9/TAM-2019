package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import WebUIAutomation.Pages.LoginPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPageTest {

    static By accountHeader = By.xpath("//*[@id=\"player-info\"]/div");

    @Before
    public void startBrowser()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Luisa_Fernanda_Munoz\\Downloads\\SELENIUM\\chromedriver_win32\\chromedriver.exe");
        DriverInitiation.startingBrowser();
    }

    @Test
    public void pageIsDisplayed()
    {
        String webTitle = DriverInitiation.driver.getTitle();
        Assert.assertTrue ("Something went wrong!", webTitle.contentEquals("SportsBet Login"));
        //Assert.assertTrue ("Something went wrong!", DriverInitiation.driver.findElement(By.xpath("/html/body/header")).isDisplayed());
        System.out.println("Login page is displayed, please proceed to sign up or sign in");
    }

    @Test
    public void ableToLogin()
    {
        LoginPage.UserAndPasswordInput("lulumo", "ATM2019");
        LoginPage.clickingLoginButton();
        Assert.assertTrue ("Unable to login", DriverInitiation.driver.findElement(accountHeader).isDisplayed());
        System.out.println("User has login, account details are shown");
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
    public void UnableToLoginWithIncorrectCredentials()
    {
        LoginPage.UserAndPasswordInput("lulumo", "Testing123");
        LoginPage.clickingLoginButton();
        Assert.assertTrue(DriverInitiation.driver.findElement(By.xpath("//*[@id=\"userinfo\"]/form/fieldset/div")).isEnabled());
        System.out.println("Unable to login with incorrect credentials");
    }

    @Test
    public void unableToLoginWithAnyEmptyField()
    {
        WebElement userField = DriverInitiation.driver.findElement(By.xpath("//*[@id='userinfo']/form/fieldset/input[1]"));
        WebElement psswField = DriverInitiation.driver.findElement(By.xpath("//*[@id='userinfo']/form/fieldset/input[2]"));
        userField.sendKeys("lulumo");               //Input test on user field and leaving password field empty
        String userFieldText = userField.getAttribute("value");
        String psswFieldText = psswField.getAttribute("value");
        LoginPage.clickingLoginButton();
        if (userFieldText.isEmpty() || psswFieldText.isEmpty())
        {
            Assert.assertTrue(DriverInitiation.driver.findElement(By.xpath("//*[@id=\"userinfo\"]/form/fieldset/div")).isEnabled());
        }
        System.out.println("Unable to login with empty fields");
    }
}
