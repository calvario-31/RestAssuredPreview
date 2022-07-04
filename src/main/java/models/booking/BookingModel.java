package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public class BookingModel extends BaseModel {
    private final String firstname;
    private final String lastname;
    @JsonProperty("totalprice")
    private final int totalPrice;
    @JsonProperty("depositpaid")
    private final boolean paid;
    @JsonProperty("additionalneeds")
    private final String additionalNeeds;
    @JsonProperty("bookingdates")
    private final BookingDates bookingDates;

    public BookingModel() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        totalPrice = faker.number().numberBetween(5, 100);
        paid = faker.bool().bool();
        additionalNeeds = faker.animal().name();
        bookingDates = new BookingDates();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public BookingDates getBookingDates() {
        return bookingDates;
    }
}
