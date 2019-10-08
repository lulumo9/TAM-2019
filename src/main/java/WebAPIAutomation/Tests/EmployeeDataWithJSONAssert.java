package WebAPIAutomation.Tests;

import WebAPIAutomation.Utilities.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;


public class EmployeeDataWithJSONAssert extends BaseClass
{
    @Test
    public void testEmployeeDataWithJSONAssert() throws IOException
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/employee/105011");
        response = client.execute(get);

        String jSonBody = EntityUtils.toString(response.getEntity());                  //EntityUtils.toString will return the entire Json content of the body/System.out.println(jSonBody);
        System.out.println(jSonBody);
        JSONAssert.assertEquals("{id:\"105011\",employee_name:\"WebAPIFixedFile\",employee_salary:\"20191003\",employee_age:\"28\",profile_image:\"\"}", jSonBody, JSONCompareMode.STRICT);
    }
}



