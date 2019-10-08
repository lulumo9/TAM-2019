package WebAPIAutomation.Tests;

import WebAPIAutomation.Utilities.BaseClass;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

import static WebAPIAutomation.Utilities.Employee.*;


public class CreateNewEmployee extends BaseClass {

    @Test
    public void ableToCreateNewEmployeeUsingConfigFile_POST() throws IOException
    {
        //Create an HttpPost with a valid EndPoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/create");

        //Define JSON to post and set as Entity
        String jSon;
        jSon = "{\"" + EMPLOYEE_NAME + "\":\"" + properties.getProperty("newEmployeeName") + "\",\"" +
                EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";
        request.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(200, actualStatusCode);
        //I have checked manually on Postman and once, I created a new record in database, status code returned is 200 (instead of 201)

        //I am taking the body here to print the ID of the new employee
        String jSonBody = EntityUtils.toString(response.getEntity());                             //EntityUtils.toString will return the entire Json content of the body
        JSONObject jsonObject = new JSONObject(jSonBody);

        //I will take every value in the fields and compare it with what user has entered
        String EmployeeIdRecorded = (String) getValueFor(jsonObject, EMPLOYEE_ID);
        String EmployeeNameRecorded = (String) getValueFor(jsonObject, EMPLOYEE_NAME);
        String EmployeeSalaryRecorded = (String) getValueFor(jsonObject, EMPLOYEE_SALARY);
        String EmployeeAgeRecorded = (String) getValueFor(jsonObject, EMPLOYEE_AGE);

        Assert.assertEquals("Something went wrong!, input was not saved", properties.getProperty("newEmployeeName").contentEquals(EmployeeNameRecorded));
        Assert.assertEquals("Something went wrong!, input was not saved", properties.getProperty("newEmployeeName").contentEquals(EmployeeSalaryRecorded));
        Assert.assertEquals("Something went wrong!, input was not saved", properties.getProperty("newEmployeeName").contentEquals(EmployeeAgeRecorded));

        System.out.println("New employee has been saved successfully in DB with the Id: " + EmployeeIdRecorded);
    }
}
