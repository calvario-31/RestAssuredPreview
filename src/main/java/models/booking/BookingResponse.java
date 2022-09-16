package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookingResponse extends BaseModel {
    @JsonProperty("bookingid")
    private int bookingId;
    @JsonProperty("booking")
    private BookingModel booking;

    public int getBookingId() {
        return bookingId;
    }

    public BookingModel getBooking() {
        return booking;
    }
}
