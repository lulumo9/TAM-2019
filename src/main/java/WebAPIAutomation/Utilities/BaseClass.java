package WebAPIAutomation.Utilities;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    public CloseableHttpClient client;
    public CloseableHttpResponse response;
    public static final String BASE_ENDPOINT = "http://dummy.restapiexample.com/api/v1";

    public Properties properties = new Properties();
    {
        try {
            //Loading the config properties file
            properties.load(new FileInputStream("C:\\Users\\Luisa_Fernanda_Munoz\\Documents\\Mentoring\\TAM-2019\\src\\main\\java\\WebAPIAutomation\\Tests\\config.properties"));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp()
    {
        client = HttpClientBuilder.create().build();
    }

    public void checkStatusCode() {

        int actualStatus = response.getStatusLine().getStatusCode();
        Assert.assertEquals(200, actualStatus);
    }

    public void returnBodyText() throws IOException
    {
        String jSonBody = EntityUtils.toString(response.getEntity());               //EntityUtils.toString will return the entire Json content of the body
        System.out.println(jSonBody);
    }

    public Object getValueFor(JSONObject jsonObject, String key)
    {
        return jsonObject.get(key);             //I am returning a type 'Object' because the actual value might be any type (String, boolean, int, ...)
    }
}


