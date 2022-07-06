package api.ping;

import base.BaseApi;
import io.restassured.response.Response;

public class HealthCheckApi extends BaseApi {
    private final String path = "ping";

    public Response healthCheck() {
        log.info("Health Check GET");
        setBasePath(path);
        return apiCallManager(GET);
    }
}
