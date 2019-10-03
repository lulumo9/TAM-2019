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

import static WebAPIAutomation.Utilities.Employee.EMPLOYEE_ID;


public class CreateNewEmployee extends BaseClass {

    @Test
    public void ableToCreateNewEmployee_POST() throws IOException
    {
        //Create an HttpPost with a valid EndPoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/create");

        //Define JSON to post and set as Entity
        String jSon;
        jSon = "{\"name\":\"WebAPIFixedFile\",\"salary\":\"20191003\",\"age\":\"28\"}";
        request.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(200, actualStatusCode);
        //I have checked manually on Postman and once, I created a new record in database, status code returned is 200 (instead of 201)

        //I am taking the body here to print the ID of the new employee
        String jSonBody = EntityUtils.toString(response.getEntity());                             //EntityUtils.toString will return the entire Json content of the body
        JSONObject jsonObject = new JSONObject(jSonBody);
        String NewEmployeeIdValue = (String) getValueFor(jsonObject, EMPLOYEE_ID);        //Method 'getValueFor' created at the beginning of the class
        System.out.println("New employee has been saved successfully in DB with the Id: " + NewEmployeeIdValue);
    }

    @Test
    public void ableToCreateNewEmployee_POST2() throws IOException
    {
        //Create an HttpPost with a valid EndPoint
        HttpPost request = new HttpPost(BASE_ENDPOINT + "/create");

        //Define JSON to post and set as Entity
        String jSon;
        jSon = "{\"name\":\"WebAPIFixedFile\",\"salary\":\"20191003\",\"age\":\"28\"}";
        request.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        //Send
        response = client.execute(request);
        int actualStatusCode = response.getStatusLine().getStatusCode();

        Assert.assertEquals(200, actualStatusCode);
        //I have checked manually on Postman and once, I created a new record in database, status code returned is 200 (instead of 201)

        //I am taking the body here to print the ID of the new employee
        String jSonBody = EntityUtils.toString(response.getEntity());                             //EntityUtils.toString will return the entire Json content of the body
        JSONObject jsonObject = new JSONObject(jSonBody);
        String NewEmployeeIdValue = (String) getValueFor(jsonObject, EMPLOYEE_ID);        //Method 'getValueFor' created at the beginning of the class
        System.out.println("New employee has been saved successfully in DB with the Id: " + NewEmployeeIdValue);
    }
}
