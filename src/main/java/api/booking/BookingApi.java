package api.booking;

import base.BaseApi;
import io.restassured.response.Response;
import models.booking.BookingModel;
import models.booking.BookingPartialModel;

public class BookingApi extends BaseApi {
    private final String path = "booking";

    private String getPathById(int bookingId) {
        return String.format("%s/%d", path, bookingId);
    }

    public Response createBooking(BookingModel bookingModel) {
        logs.info("Booking POST");
        setRequestData(path, bookingModel);
        return apiCallManager(POST);
    }

    public Response getBooking(int bookingId) {
        logs.info("Booking GET");
        setRequestData(getPathById(bookingId));
        return apiCallManager(GET);
    }

    public Response updateBooking(int bookingId, BookingModel bookingModel) {
        logs.info("Booking PUT");
        setRequestData(getPathById(bookingId), bookingModel);
        return apiCallManager(PUT);
    }

    public Response partialUpdateBooking(int bookingId, BookingPartialModel bookingModel) {
        logs.info("Booking PATCH");
        setRequestData(getPathById(bookingId), bookingModel);
        return apiCallManager(PATCH);
    }

    public Response deleteBooking(int bookingId) {
        logs.info("Booking DELETE");
        setRequestData(getPathById(bookingId));
        return apiCallManager(DELETE);
    }
}
