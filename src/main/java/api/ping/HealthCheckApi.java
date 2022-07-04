package api.ping;

import base.BaseApi;

public class HealthCheckApi extends BaseApi {

    public HealthCheckApi() {
        super("ping");
    }

    public void healthCheck() {
        log.info("health check GET");
        apiCallManager(GET, 201);
    }
}
