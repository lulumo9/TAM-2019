package WebUIAutomation.Pages;

import WebUIAutomation.DriverInitiation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountDetails {

    public static By homeButton = By.linkText("Home");
    public static By eventsButton = By.linkText("Events");
    public static By logOutButton = By.linkText("Log out");
    public static By saveButton = By.xpath("//*[@id=\"player-info\"]/form/button");
    public static By languageList = By.xpath("//*[@id=\"menu\"]/select");

    public static By eventHeader = By.xpath("//*[@id='events-box']/div");
    public static By accountHeader = By.xpath("//*[@id=\"player-info\"]/div");

    public static void  clickingHomeButton(){

        DriverInitiation.driver.findElement(homeButton).click();
    }

    public static void clickingEventsButton(){

        DriverInitiation.driver.findElement(eventsButton).click();
    }

    public static void clickingLogOutButton(){

        DriverInitiation.driver.findElement(logOutButton).click();
    }

    public static void clickingSaveButton(){

        DriverInitiation.driver.findElement(saveButton).click();
    }

    public static void selectingDifferentLanguage(){

        //Selecting currency from DropDown
        WebElement changeList = DriverInitiation.driver.findElement(languageList);
        Select options = new Select(changeList);                                     //"Select" class from Selenium
        options.selectByVisibleText("HU");
    }
}
