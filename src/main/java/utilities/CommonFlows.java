package utilities;

import api.auth.LoginApi;
import data.DataProviders;
import models.auth.LoginResponse;
import org.testng.Assert;

public class CommonFlows {
    public LoginResponse loginValidUser() {
        var loginApi = new LoginApi();
        var validUser = new DataProviders().getValidUser();

        loginApi.login(validUser);
        loginApi.verifyStatusCode();
        var loginResponse = loginApi.getBodyFromResponse(LoginResponse.class);

        Assert.assertEquals(loginResponse.getToken().length(), 15);
        return loginResponse;
    }
}
