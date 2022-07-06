package utilities;

import io.restassured.filter.FilterContext;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.internal.support.Prettifier;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class RequestFilter extends RequestLoggingFilter {
    private final Logs log = new Logs();

    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        var response = ctx.next(requestSpec, responseSpec);

        var token = requestSpec.getHeaders().getValue("Authorization");

        if (token == null) {
            token = "--";
        }

        var payload = new Prettifier().getPrettifiedBodyIfPossible(requestSpec);

        log.printRequest(requestSpec.getURI(),
                requestSpec.getMethod(),
                requestSpec.getContentType(),
                token,
                payload,
                response.getStatusCode(),
                response.getTime(),
                response.getBody().asPrettyString());
        return response;
    }
}
