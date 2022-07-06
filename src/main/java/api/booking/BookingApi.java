package api.booking;

import base.BaseApi;
import io.restassured.response.Response;
import models.booking.BookingModel;

public class BookingApi extends BaseApi {
    private final String path = "booking";

    private String getPathById(int bookingId) {
        return String.format("%s/%d", path, bookingId);
    }

    public Response createBooking(BookingModel bookingModel) {
        log.info("Booking POST");
        setBasePath(path);
        setRequestBody(bookingModel);
        return apiCallManager(POST);
    }

    public Response getBooking(int bookingId) {
        log.info("Booking GET");
        setBasePath(getPathById(bookingId));
        return apiCallManager(GET);
    }

    public Response updateBooking(int bookingId, BookingModel bookingModel) {
        log.info("Booking PUT");
        setBasePath(getPathById(bookingId));
        setRequestBody(bookingModel);
        return apiCallManager(PUT);
    }

    public Response deleteBooking(int bookingId) {
        log.info("Booking DELETE");
        setBasePath(getPathById(bookingId));
        return apiCallManager(DELETE);
    }
}
