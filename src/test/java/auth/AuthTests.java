package auth;

import api.auth.LoginApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.auth.LoginRequest;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {
    private final LoginApi loginApi = new LoginApi();

    @Test
    public void loginTest() {
        loginApi.login(dataProviders.getValidUser()).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(LoginRequest.loginResponseSchema)));
    }
}
