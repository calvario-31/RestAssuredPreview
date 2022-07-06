package base;

import data.DataProviders;
import io.restassured.response.Response;
import org.testng.Assert;
import utilities.Logs;

public abstract class BaseTest {
    private final Logs log = new Logs();
    protected Response response;
    protected DataProviders dataProviders = new DataProviders();

    protected void verifyResponseCode(int expectedStatusCode) {
        log.info("Verifying response code");
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }

    protected void verifyResponseTime(long responseTime) {
        log.info("Verifying response time");
        Assert.assertTrue(response.getTime() <= responseTime);
    }
}
