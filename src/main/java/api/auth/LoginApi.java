package api.auth;

import base.BaseApi;
import models.auth.LoginModel;

public class LoginApi extends BaseApi {
    public LoginApi() {
        super("auth");
    }

    public void login(LoginModel loginModel) {
        log.info("login POST");
        setRequestBody(loginModel);
        apiCallManager(POST, 200);
    }
}
