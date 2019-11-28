package TestFramework.LoggingFeature;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.junit.Before;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseClassLogging {

    public static Logger logger = LogManager.getLogger(BaseClassLogging.class);
    public CloseableHttpClient client;
    public CloseableHttpResponse response;
    public static final String BASE_ENDPOINT = "http://dummy.restapiexample.com/api/v1";

    @Before
    public void setUp()
    {
        client = HttpClientBuilder.create().build();
    }

    public Object getValueFor(JSONObject jsonObject, String key)
    {
        return jsonObject.get(key);             //I am returning a type 'Object' because the actual value might be any type (String, boolean, int, ...)
    }

    public Properties properties = new Properties();
    {
        try {
            //Loading the config properties file
            properties.load(new FileInputStream("C:\\Users\\Luisa_Fernanda_Munoz\\Documents\\Mentoring\\TAM-2019\\src\\main\\java\\TestFramework\\LoggingFeature\\Utility\\config.properties"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
