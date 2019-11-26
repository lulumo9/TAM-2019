package TestFramework.LoggingFeature;

import org.apache.http.client.methods.HttpGet;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AllEmployeeList extends BaseClassLogging {

    @Test
    public void loggingSuccessfullyAllEmployeeList()
    {
        logger.info("The endpoint for this action is " + BASE_ENDPOINT + "/employees");

        HttpGet getRequest = new HttpGet(BASE_ENDPOINT + "/employees");
        logger.info("Sending request");

        try {
            response = client.execute(getRequest);
            logger.info("Receiving response");
        } catch (IOException e)
        {
            logger.error("Error while --- ");
            e.printStackTrace();
        }

        int actualStatus = response.getStatusLine().getStatusCode();
        logger.info("Receiving the status response code");
        Assert.assertEquals(200, actualStatus);


        System.out.println("Hi there!");
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.fatal("This is a fatal message");
        logger.trace("This is trace message");
        logger.info("This is information message");
        System.out.println("Completed");


    }
}
