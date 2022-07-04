package ping;

import api.ping.HealthCheckApi;
import base.BaseTest;
import org.testng.annotations.Test;

public class HealthCheckTests extends BaseTest {
    private final HealthCheckApi healthCheckAPI = new HealthCheckApi();

    @Test
    public void healthCheckTest() {
        healthCheckAPI.healthCheck();
        healthCheckAPI.verifyStatusCode();
    }
}
