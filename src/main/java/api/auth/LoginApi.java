package api.auth;

import base.BaseApi;
import io.restassured.response.Response;
import models.auth.LoginRequest;

public class LoginApi extends BaseApi {
    private final String path = "auth";

    public Response login(LoginRequest loginModel) {
        logs.info("Login POST");
        setRequestData(path, loginModel);
        return apiCallManager(POST);
    }
}
