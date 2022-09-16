package auth;

import api.auth.LoginApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.auth.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {
    private final LoginApi loginApi = new LoginApi();
    private final String loginResponseSchema = "login/LoginResponse.json";

    @Test
    public void loginTest() {

        var token = loginApi.login(dataProviders.getValidUser()).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(loginResponseSchema)))
                .extract().body().as(LoginResponse.class).getToken();

        Assert.assertEquals(token.length(), 15);
    }
}
