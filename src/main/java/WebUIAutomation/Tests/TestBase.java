package WebUIAutomation.Tests;

import WebUIAutomation.DriverInitiation;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class TestBase {


    Properties properties = new Properties();
    {
        try {
            //Loading the config properties file
            properties.load(new FileInputStream("C:\\Users\\Luisa_Fernanda_Munoz\\Documents\\Mentoring\\TAM-2019\\src\\WebUIAutomation\\config.properties"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void startBrowser()
    {
        System.setProperty("webdriver.chrome.driver", properties.getProperty("webdriverUrl"));
        DriverInitiation.startingBrowser();
    }
}
