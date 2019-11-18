package TestFramework.LoggingFeature.Tests;


import TestFramework.LoggingFeature.Utilities.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

import java.io.IOException;


public class AllEmployeeData extends BaseClass {

    @Test
    public void returnAllEmployeeDataCheckingStatusCode() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/employees");
        response = client.execute(get);

        //Checking status code
        checkStatusCode();

        //Since code is 200, I am printing all employees data, contented in the body
        returnBodyText();
        logger.info("The list of all the employees is being displayed");
    }
}
