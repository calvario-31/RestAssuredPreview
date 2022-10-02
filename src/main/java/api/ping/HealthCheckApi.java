package api.ping;

import base.BaseApi;
import io.restassured.response.Response;

import static io.restassured.http.Method.GET;

public class HealthCheckApi extends BaseApi {
    private final String path = "ping";

    public Response healthCheck() {
        logs.info("Health Check GET");
        setResourcePath(path);
        return apiCallManager(GET);
    }
}
