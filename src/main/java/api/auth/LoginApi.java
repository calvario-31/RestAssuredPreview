package api.auth;

import base.BaseApi;
import io.restassured.response.Response;
import models.auth.LoginModel;

public class LoginApi extends BaseApi {
    private final String path = "auth";

    public Response login(LoginModel loginModel) {
        log.info("Login POST");
        setBasePath(path);
        setRequestBody(loginModel);
        return apiCallManager(POST);
    }
}
