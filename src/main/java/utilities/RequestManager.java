package utilities;

import base.BaseModel;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestManager {
    private final RequestSpecification request;
    private final String mainUrl = "https://restful-booker.herokuapp.com";
    private final Logs logs = new Logs();

    public RequestManager(boolean isAuth) {
        request = buildRequestSpec(isAuth);
    }

    public RequestSpecification buildRequestSpec(boolean isAuth) {
        var spec = RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(mainUrl)
                        .setContentType(ContentType.JSON)
                        .build();

        if (isAuth) {
            assignAuth();
        }

        return RestAssured.given().spec(spec).filter(new RequestFilter());
    }

    private void assignAuth() {
        var authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password123");
        RestAssured.authentication = authScheme;
    }

    public void setRequestBody(BaseModel model) {
        logs.debug("Setting request body");
        request.body(model);
    }

    public void setResourcePath(String value) {
        logs.debug("Setting base path: " + value);
        request.basePath(value);
    }

    public void setPathParameter(String key, String value) {
        logs.debug("Setting path parameter: " + value);
        request.pathParam(key, value);
    }

    public Response callApi(Method method) {
        return request.request(method);
    }
}
