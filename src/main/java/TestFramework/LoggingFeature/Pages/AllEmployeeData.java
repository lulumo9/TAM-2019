package TestFramework.LoggingFeature.Pages;


import TestFramework.LoggingFeature.Utilities.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;


public class AllEmployeeData extends BaseClass {

    @Test
    public void returnAllEmployeeDataCheckingStatusCode()
    {
        logger.info("Entering to all the employees data method");
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/employees");
        try {
            response = client.execute(get);
        } catch (IOException e) {

            logger.error("Error message while --- ");
            e.printStackTrace();
        }

        //Checking status code
        checkStatusCode();

        //Since code is 200, I am printing all employees data, contented in the body
        //returnBodyText();
        System.out.println("Hi there!");

        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.fatal("This is a fatal message");
        System.out.println("Completed");
    }
}
