package booking;

import api.booking.BookingApi;
import base.BaseTest;
import models.booking.BookingModel;
import models.booking.BookingResponse;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {
    private final BookingApi bookingApi = new BookingApi();

    @Test
    public void crudBookingTest() {
        response = bookingApi.createBooking(new BookingModel());
        verifyResponseCode(200);
        var bookingId = response.getBody().as(BookingResponse.class).getBookingId();

        response = bookingApi.getBooking(bookingId);
        verifyResponseCode(200);

        response = bookingApi.updateBooking(bookingId, new BookingModel());
        verifyResponseCode(200);

        response = bookingApi.getBooking(bookingId);
        verifyResponseCode(200);

        response = bookingApi.deleteBooking(bookingId);
        verifyResponseCode(201);

        response = bookingApi.getBooking(bookingId);
        verifyResponseCode(404);
    }
}
