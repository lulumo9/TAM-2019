package WebUIAutomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverInitiation {

    public static WebDriver driver = new ChromeDriver();

    public static void startingBrowser()
    {

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); /*I am giving time to the URL to load*/
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://sportbetting.azurewebsites.net/sportsbetting-web/");
    }

    public static void closingBrowser()
    {
        driver.close();
    }
}
