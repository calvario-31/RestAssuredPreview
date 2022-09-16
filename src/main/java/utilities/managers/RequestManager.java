package utilities.managers;

import base.BaseModel;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Logs;
import utilities.RequestFilter;

public class RequestManager {
    private final RequestSpecification request;
    private final String mainUrl = "https://restful-booker.herokuapp.com";
    private final Logs logs = new Logs();

    public RequestManager() {
        request = buildRequestSpec();
    }

    public RequestSpecification buildRequestSpec() {
        var authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("admin");
        authScheme.setPassword("password123");

        var spec = RestAssured.requestSpecification =
                new RequestSpecBuilder()
                        .setBaseUri(mainUrl)
                        .setAuth(authScheme)
                        .setContentType(ContentType.JSON)
                        .build();

        return RestAssured.given().spec(spec).filter(new RequestFilter());
    }

    public void setRequestBody(BaseModel model) {
        logs.debug("Setting request body");
        request.body(model);
    }

    public void setBasePath(String value) {
        logs.debug("Setting base path: " + value);
        request.basePath(value);
    }

    public Response callApi(String method) {
        logs.debug("Calling api with method " + method);
        return request.request(method);
    }
}
