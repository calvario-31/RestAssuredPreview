package api.auth;

import base.BaseApi;
import io.restassured.response.Response;
import models.auth.LoginRequest;

import static io.restassured.http.Method.POST;

public class LoginApi extends BaseApi {
    private final String path = "auth";

    public Response login(LoginRequest login) {
        logs.info("Login POST");
        setResourcePath(path);
        setRequestBody(login);
        return apiCallManager(POST);
    }
}
