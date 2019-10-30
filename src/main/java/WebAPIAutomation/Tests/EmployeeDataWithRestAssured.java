package WebAPIAutomation.Tests;

import WebAPIAutomation.Utilities.BaseClass;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static WebAPIAutomation.Utilities.Employee.*;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.when;


public class EmployeeDataWithRestAssured extends BaseClass {

    public String json;

    public void settingEmployee()
    {
        // use RestAssured to make an HTML Call
        Response response = get(BASE_ENDPOINT + "/employee/105011").andReturn();
        json = response.getBody().asString();
    }

    @Test
    public void checkingStatusCodeWithRestAssured() {
        when().
                get(BASE_ENDPOINT + "/employee/101862").
                then().statusCode(200);
    }

    @Test
    public void checkingEmployeeIdWithRestAssured()
    {
        settingEmployee();
        // Use the JsonPath parsing library of RestAssured to Parse the JSON
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("105011", jsonPath.getString(EMPLOYEE_ID));

    }

    @Test
    public void checkingEmployeeNameWithRestAssured()
    {
        settingEmployee();
        // Use the JsonPath parsing library of RestAssured to Parse the JSON
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("WebAPIFixedFile", jsonPath.getString(EMPLOYEE_NAME));
    }

    @Test
    public void checkingEmployeeSalaryWithRestAssured()
    {
        settingEmployee();
        // Use the JsonPath parsing library of RestAssured to Parse the JSON
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("20191003", jsonPath.getString(EMPLOYEE_SALARY));
    }

    @Test
    public void checkingEmployeeAgeWithRestAssured()
    {
        settingEmployee();
        // Use the JsonPath parsing library of RestAssured to Parse the JSON
        JsonPath jsonPath = new JsonPath(json);
        Assert.assertEquals("28", jsonPath.getString(EMPLOYEE_AGE));
    }
}
