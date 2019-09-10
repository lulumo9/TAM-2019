package WebUIAutomation.Pages;

import WebUIAutomation.DriverInitiation;
import org.openqa.selenium.By;

public class LoginPage {

    static By userField = By.xpath("//*[@id='userinfo']/form/fieldset/input[1]");
    static By passwordField = By.xpath("//*[@id='userinfo']/form/fieldset/input[2]");
    static By loginButton = By.id("login-button");
    static By signinLink = By.xpath("/html/body/main/p/a[1]");
    static By signUpLink = By.xpath("/html/body/main/p/a[2]");


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
}





