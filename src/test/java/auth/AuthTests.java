package auth;

import api.auth.LoginApi;
import base.BaseTest;
import models.auth.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {
    private final LoginApi loginApi = new LoginApi();

    @Test
    public void loginTest() {
        response = loginApi.login(dataProviders.getValidUser());
        verifyResponseCode(200);

        var body = response.getBody().as(LoginResponse.class);
        Assert.assertEquals(body.getToken().length(), 15);
    }
}
