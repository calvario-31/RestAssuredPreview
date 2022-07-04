package base;

import utilities.Logs;
import utilities.managers.RequestManager;
import utilities.managers.ResponseManager;

public abstract class BaseApi {
    protected final String GET = "GET";
    protected final String POST = "POST";
    protected final String PUT = "PUT";
    protected final String PATCH = "PATCH";
    protected final String DELETE = "DELETE";

    private final RequestManager requestManager;
    protected ResponseManager responseManager;
    protected Logs log = new Logs();

    public BaseApi(String apiUrl) {
        requestManager = new RequestManager(apiUrl);
    }

    public BaseApi(String apiUrl, String token) {
        this(apiUrl);
        requestManager.setToken(token);
    }

    protected void apiCallManager(String method, int expectedStatusCode) {
        var response = requestManager.callApi(method);
        responseManager = new ResponseManager(response, expectedStatusCode);
    }

    protected void setRequestBody(BaseModel model) {
        requestManager.setRequestBody(model);
    }

    public void verifyStatusCode() {
        responseManager.verifyStatusCode();
    }

    public <T> T getBodyFromResponse(Class<T> clazz) {
        return responseManager.getBodyFromResponse(clazz);
    }
}
