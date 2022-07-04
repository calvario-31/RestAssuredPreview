package api.booking;

import base.BaseApi;
import models.booking.BookingModel;

public class BookingApi extends BaseApi {
    public BookingApi() {
        super("booking");
    }

    public BookingApi(String token) {
        super("booking", token);
    }

    public void createBooking(BookingModel bookingModel) {
        log.info("booking POST");
        setRequestBody(bookingModel);
        apiCallManager(POST, 200);
    }
}
