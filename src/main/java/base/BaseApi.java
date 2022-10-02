package base;

import io.restassured.http.Method;
import io.restassured.response.Response;
import utilities.Logs;
import utilities.RequestManager;

public abstract class BaseApi {
    private final RequestManager requestManager;
    private boolean isAuth = true;
    protected Logs logs = new Logs();

    public BaseApi() {
        requestManager = new RequestManager(isAuth);
    }

    protected Response apiCallManager(Method method) {
        return requestManager.callApi(method);
    }

    protected void setResourcePath(String path) {
        requestManager.setResourcePath(path);
    }

    protected void setPathParameter(String key, String value) {
        requestManager.setPathParameter(key, value);
    }

    protected void setRequestBody(BaseModel model) {
        requestManager.setRequestBody(model);
    }

    public void setAuth(boolean auth) {
        isAuth = auth;
    }
}
