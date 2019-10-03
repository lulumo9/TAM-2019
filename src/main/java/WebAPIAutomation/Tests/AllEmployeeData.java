package WebAPIAutomation.Tests;

import WebAPIAutomation.Utilities.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.junit.Test;
import java.io.IOException;


public class AllEmployeeData extends BaseClass {

    @Test
    public void returnAllEmployeeDataCheckingStatusCode() throws IOException {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/employees");
        response = client.execute(get);

        //Printing all employees data, contented in the body
        returnBodyText();

        //Checking status code
        isStatusCode200();
    }
}
