package TestFramework.LoggingFeature.Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AllEmployeeDataWithoutExtending {

    public static Logger logger = LogManager.getLogger(AllEmployeeData.class);

    @Test
    public void returnAllEmployeeDataCheckingStatusCode() throws IOException {

        String text = "ABC";
        Assert.assertEquals("ABC", text);
        System.out.println("Hi there!");

        logger.trace("This is trace message");
        logger.info("This is information message");
        System.out.println("Completed");
    }
}
