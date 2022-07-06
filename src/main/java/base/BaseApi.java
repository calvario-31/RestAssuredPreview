package base;

import io.restassured.response.Response;
import utilities.Logs;
import utilities.managers.RequestManager;

public abstract class BaseApi {
    protected final String GET = "GET";
    protected final String POST = "POST";
    protected final String PUT = "PUT";
    protected final String PATCH = "PATCH";
    protected final String DELETE = "DELETE";

    private final RequestManager requestManager;
    protected Logs log = new Logs();

    public BaseApi() {
        requestManager = new RequestManager();
    }

    protected Response apiCallManager(String method) {
        return requestManager.callApi(method);
    }

    protected void setRequestBody(BaseModel model) {
        requestManager.setRequestBody(model);
    }

    protected void setBasePath(String value) {
        requestManager.setBasePath(value);
    }
}
