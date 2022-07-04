package utilities.managers;

import io.restassured.response.Response;
import org.testng.Assert;
import utilities.Logs;

public class ResponseManager {
    private final Logs log = new Logs();
    private final Response response;
    private final int expectedStatusCode;

    public ResponseManager(Response response, int expectedStatusCode) {
        this.response = response;
        this.expectedStatusCode = expectedStatusCode;
    }

    public <T> T getBodyFromResponse(Class<T> clazz) {
        log.debug("Getting body from response");
        return response.getBody().as(clazz);
    }

    public void verifyStatusCode() {
        log.info("Verifying status code");
        Assert.assertEquals(response.getStatusCode(), expectedStatusCode);
    }
}
