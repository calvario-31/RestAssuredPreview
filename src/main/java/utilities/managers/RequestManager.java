package utilities.managers;

import base.BaseModel;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.Logs;
import utilities.RequestFilter;

public class RequestManager {
    private final RequestSpecification request;
    private final String mainUrl = "https://restful-booker.herokuapp.com";
    protected Logs log = new Logs();

    public RequestManager(String apiUrl) {
        request = buildRequestSpec(apiUrl);
    }

    public RequestSpecification buildRequestSpec(String apiUrl) {
        var spec = RestAssured.requestSpecification =
                new RequestSpecBuilder().
                        setBaseUri(mainUrl).
                        setBasePath(apiUrl).
                        setContentType(ContentType.JSON).
                        build();

        return RestAssured.given().spec(spec).filter(new RequestFilter());
    }

    public void setToken(String token) {
        log.info("Setting token");
        request.header("Basic", token);
    }

    public void setRequestBody(BaseModel model) {
        log.info("Setting request body");
        request.body(model);
    }

    public Response callApi(String method) {
        log.info("Calling api " + method);
        return request.request(method);
    }
}
