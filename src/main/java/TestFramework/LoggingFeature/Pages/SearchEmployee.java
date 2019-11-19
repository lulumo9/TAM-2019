package TestFramework.LoggingFeature.Pages;

import WebAPIAutomation.Utilities.BaseClass;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static WebAPIAutomation.Utilities.Employee.*;

public class SearchEmployee extends BaseClass {

    @Test
    public void returnEmployeeDataCheckingStatusCode() throws IOException
    {
        HttpGet get = new HttpGet(BASE_ENDPOINT + "/employee/105011");
        response = client.execute(get);
        //Checking status code
        int actualStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatus);

        String jSonBody = EntityUtils.toString(response.getEntity());                       //EntityUtils.toString will return the entire Json content of the body
        //System.out.println(jSonBody);
        JSONObject jsonObject = new JSONObject(jSonBody);
        //The Json object is a simpleMap, with keys and values
        String employeeIdValue = (String) getValueFor(jsonObject, EMPLOYEE_ID);             //Method 'getValueFor' created at the beginning of the class
        String employeeNameValue = (String) getValueFor(jsonObject, EMPLOYEE_NAME);
        String employeeSalaryValue = (String) getValueFor(jsonObject, EMPLOYEE_SALARY);
        String employeeAgeValue = (String) getValueFor(jsonObject, EMPLOYEE_AGE);

        System.out.println("Id: " + employeeIdValue + "\n" + "Name: " + employeeNameValue + "\n" + "Salary: " + employeeSalaryValue + "\n" + "Age: " + employeeAgeValue);
    }
}

