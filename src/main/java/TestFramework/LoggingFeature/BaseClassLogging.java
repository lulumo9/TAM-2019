package TestFramework.LoggingFeature;


import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;

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
}
