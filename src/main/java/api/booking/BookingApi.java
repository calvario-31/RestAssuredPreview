package api.booking;

import base.BaseApi;
import io.restassured.response.Response;
import models.booking.Booking;
import models.booking.BookingPartial;

public class BookingApi extends BaseApi {
    private final String path = "booking";

    private String getPathById(int bookingId) {
        return String.format("%s/%d", path, bookingId);
    }

    public Response createBooking(Booking booking) {
        logs.info("Booking POST");
        setRequestData(path, booking);
        return apiCallManager(POST);
    }

    public Response getBooking(int bookingId) {
        logs.info("Booking GET");
        setRequestData(getPathById(bookingId));
        return apiCallManager(GET);
    }

    public Response updateBooking(int bookingId, Booking booking) {
        logs.info("Booking PUT");
        setRequestData(getPathById(bookingId), booking);
        return apiCallManager(PUT);
    }

    public Response partialUpdateBooking(int bookingId, BookingPartial bookingModel) {
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
