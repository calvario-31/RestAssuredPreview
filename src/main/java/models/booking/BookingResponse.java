package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse extends BaseModel {
    public final static String schemaPath = "booking/BookingResponse.json";
    @JsonProperty("bookingid")
    private int bookingId;
    @JsonProperty("booking")
    private Booking booking;

    public int getBookingId() {
        return bookingId;
    }

    public Booking getBooking() {
        return booking;
    }
}
