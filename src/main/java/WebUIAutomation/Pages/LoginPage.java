package WebUIAutomation.Pages;

import WebUIAutomation.DriverInitiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public static By userField = By.xpath("//*[@id='userinfo']/form/fieldset/input[1]");
    public static By passwordField = By.xpath("//*[@id='userinfo']/form/fieldset/input[2]");
    static By loginButton = By.id("login-button");
    static By signinLink = By.xpath("/html/body/main/p/a[1]");
    static By signUpLink = By.xpath("/html/body/main/p/a[2]");

    public static By accountHeader = By.xpath("//*[@id=\"player-info\"]/div");
    public static By incorrectNotification = By.xpath("//*[@id=\"userinfo\"]/form/fieldset/div");

    public static String userFieldText;
    public static String psswFieldText;

    public static void UserAndPasswordInput(String userName, String Password)
    {
        DriverInitiation.driver.findElement(userField).sendKeys(userName);
        DriverInitiation.driver.findElement(passwordField).sendKeys(Password);
    }

    public static void clickingLoginButton()
    {
        DriverInitiation.driver.findElement(loginButton).click();
    }

    public static void clickingSigninLink()
    {
        DriverInitiation.driver.findElement(signinLink).click();
    }

    public static void clickingSingupLink()
    {
        DriverInitiation.driver.findElement(signUpLink).click();
    }

    public static void gettingTextInFields()
    {
        WebElement userField = DriverInitiation.driver.findElement(By.xpath("//*[@id='userinfo']/form/fieldset/input[1]"));
        WebElement psswField = DriverInitiation.driver.findElement(By.xpath("//*[@id='userinfo']/form/fieldset/input[2]"));
        userField.sendKeys("lulumo");               //Input test on user field and leaving password field empty
        userFieldText = userField.getAttribute("value");
        psswFieldText = psswField.getAttribute("value");
    }
}





