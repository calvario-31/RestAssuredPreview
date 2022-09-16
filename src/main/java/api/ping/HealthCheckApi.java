package api.ping;

import base.BaseApi;
import io.restassured.response.Response;

public class HealthCheckApi extends BaseApi {
    private final String path = "ping";

    public Response healthCheck() {
        logs.info("Health Check GET");
        setRequestData(path);
        return apiCallManager(GET);
    }
}
