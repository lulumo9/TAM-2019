package WebUIAutomation.Pages;

import WebUIAutomation.DriverInitiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

    static By userNameField = By.xpath("//*[@id=\"account-box\"]/form/div[1]/input");
    static By nameField = By.xpath("//*[@id=\"account-box\"]/form/div[4]/input");
    static By doBField = By.xpath("//*[@id=\"account-box\"]/form/div[6]/input");
    static By aNumberField = By.xpath("//*[@id=\"account-box\"]/form/div[7]/input");
    static By currencyDropDown = By.xpath("//*[@id=\"account-box\"]/form/div[9]/select");
    static By passwordField = By.xpath("//*[@id=\"account-box\"]/form/div[11]/input");
    static By pssConfirmedField = By.xpath("//*[@id=\"account-box\"]/form/div[12]/input");
    static By saveButton = By.xpath("//*[@id=\"account-box\"]/form/button");
    static By feedbackButton = By.xpath("//*[@id=\"account-box\"]/button");
    static By showButton = By.xpath("//*[@id=\"account-box\"]/div[3]/button]");

    public static void fillingForm(String userName, String name, String aNumber, String password, String passConfirmed)
    {
        DriverInitiation.driver.findElement(userNameField).sendKeys(userName);
        DriverInitiation.driver.findElement(nameField).sendKeys(name);
        DriverInitiation.driver.findElement(doBField).sendKeys("07/04/1991");
        DriverInitiation.driver.findElement(aNumberField).sendKeys(aNumber);
        //Selecting currency from DropDown
        WebElement currencyList = DriverInitiation.driver.findElement(currencyDropDown);
        Select options = new Select(currencyList);                                     //"Select" class from Selenium
        options.selectByVisibleText("EUR");
        //
        DriverInitiation.driver.findElement(passwordField).sendKeys(password);
        DriverInitiation.driver.findElement(pssConfirmedField).sendKeys(passConfirmed);
    }

    public static void clickingSaveButton()
    {
        DriverInitiation.driver.findElement(saveButton).click();
    }

    public static void clickingFeedbackButton()
    {
        DriverInitiation.driver.findElement(feedbackButton).click();
    }

    public static void clickingShowButton()
    {
        DriverInitiation.driver.findElement(showButton).click();
    }
}
