package TestFramework.LoggingFeature.Tests;

import WebAPIAutomation.Utilities.BaseClass;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;


public class DeletingEmployee extends BaseClass {

    @Test
    public void deleteHasBeenSuccessful() throws IOException
    {
        HttpDelete request = new HttpDelete("http://dummy.restapiexample.com/api/v1/delete/100257");
        response = client.execute(request);

        //Until this point employee has been deleted, now I want to confirm data is empty or false as appear on link after deleting this one
        //EntityUtils.toString will return the entire Json content of the body
        String jSonBody = EntityUtils.toString(response.getEntity());

        Assert.assertEquals("{\"success\":{\"text\":\"successfully! deleted Records\"}}", jSonBody);
        System.out.println("Employee has been deleted successfully");
    }
}

