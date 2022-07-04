package booking;

import api.booking.BookingApi;
import base.BaseTest;
import models.booking.BookingModel;
import models.booking.BookingResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {
    private final BookingApi bookingApi = new BookingApi();

    @BeforeMethod
    public void setUp() {
        assignToken();
    }

    @Test
    public void createBookingTest() {
        var payload = new BookingModel();
        bookingApi.createBooking(payload);
        bookingApi.verifyStatusCode();

        var booking = bookingApi.getBodyFromResponse(BookingResponse.class);
        System.out.println(booking.getBookingId());
    }
}
