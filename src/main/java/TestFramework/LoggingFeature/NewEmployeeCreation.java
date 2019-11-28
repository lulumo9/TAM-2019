package TestFramework.LoggingFeature;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static TestFramework.LoggingFeature.Utility.EmployeeData.*;

public class NewEmployeeCreation extends BaseClassLogging{

    @Test
    public void ableToCreateANewEmployeeSuccessfully() throws IOException {
        logger.info("The post request will be send to the endpoint" + BASE_ENDPOINT + "/create");
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_NAME + "\":\"" + properties.getProperty("newEmployeeName") + "\",\"" +
                EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";
        logger.info("Sending post request with following data: " + jSon);
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        //Taking status code from response
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        //System.out.println("Status response code is: " + actualStatusCode);
        logger.info("Status response code is 200 OK");

        //Taking the body of the response to confirm employee was create with the same data sent
        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        JSONObject jsonObject = new JSONObject(jSonBody);                               //Passing the string to the JSon object

        //I will take every value in the fields and compare it with what user has entered
        String EmployeeIdRecorded = (String) getValueFor(jsonObject, EMPLOYEE_ID);
        String EmployeeNameRecorded = (String) getValueFor(jsonObject, EMPLOYEE_NAME);
        String EmployeeSalaryRecorded = (String) getValueFor(jsonObject, EMPLOYEE_SALARY);
        String EmployeeAgeRecorded = (String) getValueFor(jsonObject, EMPLOYEE_AGE);


        Assert.assertEquals("Something went wrong! - name was not saved",EmployeeNameRecorded, properties.getProperty("newEmployeeName"));
        Assert.assertEquals("Something went wrong! - salary name was not saved",EmployeeSalaryRecorded, properties.getProperty("newEmployeeSalary"));
        Assert.assertEquals("Something went wrong! - age name was not saved",EmployeeAgeRecorded, properties.getProperty("newEmployeeAge"));
        logger.info("New employee has been successfully created with the data/request sent");

        System.out.println("New employee has been saved successfully in DB with the Id: " + EmployeeIdRecorded);
        logger.info("Message confirmed the creation of the new employee and return the ID given for the same: " + EmployeeIdRecorded);
    }

    @Test
    public void UnableToCreateDuplicatedEmployeeName() throws IOException
    {
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_NAME + "\":\"" + properties.getProperty("AlreadyExistingEmployeeName") + "\",\"" +
                EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";
        logger.info("Sending post request with following data: " + jSon);
        logger.info("Please note request contains an already existing 'Employee name': " + properties.getProperty("AlreadyExistingEmployeeName"));
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        //Taking status code from response
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        logger.info("Status response code is 200 OK");

        //Taking the body of the response to confirm employee was create with the same data sent
        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        Assert.assertTrue(jSonBody.contains("Integrity constraint violation: 1062 Duplicate entry"));
        logger.error("Error message displayed, since employee name already exists in the system");
    }

    @Test
    public void UnableToAssignEmployeeIDSinceSystemProvidesIt() throws IOException
    {
        logger.info("The post request will be send to the endpoint" + BASE_ENDPOINT + "/create");
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_ID + "\":\"" + properties.getProperty("NOTneededEmployeeID") + "\",\"" +
                EMPLOYEE_NAME + "\":\"" + properties.getProperty("newEmployeeName") + "\",\"" +
                EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";
        logger.info("Sending post request with following data: " + jSon);
        logger.info("Please note request contains an 'Employee id': which is not needed - " + properties.getProperty("NOTneededEmployeeID"));
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        //Taking status code from response
        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatusCode);
        //System.out.println("Status response code is: " + actualStatusCode);
        logger.info("Status response code is 200 OK");

        //Taking the body of the response to confirm employee was create with the same data sent
        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        JSONObject jsonObject = new JSONObject(jSonBody);                               //Passing the string to the JSon object

        //I will take every value in the fields and compare it with what user has entered
        String EmployeeIdRecorded = (String) getValueFor(jsonObject, EMPLOYEE_ID);

        Assert.assertNotEquals("Something went wrong! - employee id entered has been assigned to the employee created", EmployeeIdRecorded, properties.getProperty("NOTneededEmployeeID"));
        System.out.println("New employee has been saved successfully in DB with the Id: " + EmployeeIdRecorded);
        logger.info("New employee has been successfully created with an ID automatically assigned by the system: " + EmployeeIdRecorded);
    }

    @Test
    public void UnableToCreateEmployeeWithoutName() throws IOException
    {
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";

        logger.info("Sending post request with following data: " + jSon);
        logger.info("Please note, request does not contain 'Employee name' for testing purposes");
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        Assert.assertTrue(jSonBody.contains("Column 'employee_name' cannot be null"));
        logger.error("Error message displayed, since employee name cannot be null");
    }

    @Test
    public void UnableToCreateEmployeeWithoutSalary() throws IOException
    {
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_NAME + "\":\"" + properties.getProperty("AlreadyExistingEmployeeName") + "\",\"" +
                EMPLOYEE_AGE + "\":\"" + properties.getProperty("newEmployeeAge") + "\"}";

        logger.info("Sending post request with following data: " + jSon);
        logger.info("Please note, request does not contain 'Employee salary' for testing purposes");
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        Assert.assertTrue(jSonBody.contains("Column 'employee_salary' cannot be null"));
        logger.error("Error message displayed, since employee salary cannot be null");
    }

    @Test
    public void UnableToCreateEmployeeWithoutAge() throws IOException
    {
        HttpPost requestPost = new HttpPost(BASE_ENDPOINT + "/create");

        String jSon;
        jSon = "{\"" + EMPLOYEE_NAME + "\":\"" + properties.getProperty("newEmployeeName") + "\",\"" +
                EMPLOYEE_SALARY + "\":\"" + properties.getProperty("newEmployeeSalary") + "\"}";

        logger.info("Sending post request with following data: " + jSon);
        logger.info("Please note, request does not contain 'Employee age' for testing purposes");
        requestPost.setEntity(new StringEntity(jSon, ContentType.APPLICATION_JSON));

        try {
            response = client.execute(requestPost);
            logger.info("Receiving response and saving into a variable");
        } catch (IOException e) {
            logger.error("This is an error message thrown by the 'execute' method");
            e.printStackTrace();
        }

        String jSonBody = EntityUtils.toString(response.getEntity());                 //EntityUtils.toString will return the entire Json content of the body
        logger.info("Response obtained:" + jSonBody);
        Assert.assertTrue(jSonBody.contains("Column 'employee_age' cannot be null"));
        logger.error("Error message displayed, since employee age cannot be null");
    }
}
