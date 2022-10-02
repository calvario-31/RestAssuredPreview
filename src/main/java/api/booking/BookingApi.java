package api.booking;

import base.BaseApi;
import io.restassured.response.Response;
import models.booking.Booking;
import models.booking.BookingPartial;

import static io.restassured.http.Method.DELETE;
import static io.restassured.http.Method.GET;
import static io.restassured.http.Method.PATCH;
import static io.restassured.http.Method.POST;
import static io.restassured.http.Method.PUT;

public class BookingApi extends BaseApi {
    private final String path = "booking";
    private final String keyPathParameter = "id";
    private final String pathID = String.format("%s/{%s}", path, keyPathParameter);

    public Response createBooking(Booking booking) {
        logs.info("Booking POST");
        setResourcePath(path);
        setRequestBody(booking);
        return apiCallManager(POST);
    }

    public Response getBooking(int bookingId) {
        logs.info("Booking GET");
        setPathParameter(keyPathParameter, String.valueOf(bookingId));
        setResourcePath(pathID);
        return apiCallManager(GET);
    }

    public Response updateBooking(int bookingId, Booking booking) {
        logs.info("Booking PUT");
        setPathParameter(keyPathParameter, String.valueOf(bookingId));
        setResourcePath(pathID);
        setRequestBody(booking);
        return apiCallManager(PUT);
    }

    public Response partialUpdateBooking(int bookingId, BookingPartial booking) {
        logs.info("Booking PATCH");
        setPathParameter(keyPathParameter, String.valueOf(bookingId));
        setResourcePath(pathID);
        setRequestBody(booking);
        return apiCallManager(PATCH);
    }

    public Response deleteBooking(int bookingId) {
        logs.info("Booking DELETE");
        setPathParameter(keyPathParameter, String.valueOf(bookingId));
        setResourcePath(pathID);
        return apiCallManager(DELETE);
    }
}
