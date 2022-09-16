package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public class BookingModel extends BaseModel {
    @JsonProperty("firstname")
    private String firstname;
    @JsonProperty("lastname")
    private String lastname;
    @JsonProperty("totalprice")
    private int totalPrice;
    @JsonProperty("depositpaid")
    private boolean paid;
    @JsonProperty("additionalneeds")
    private String additionalNeeds;
    @JsonProperty("bookingdates")
    private BookingDates bookingDates;

    public BookingModel() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        totalPrice = faker.number().numberBetween(5, 100);
        paid = faker.bool().bool();
        additionalNeeds = faker.animal().name();
        bookingDates = new BookingDates();
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    public void setBookingDates(BookingDates bookingDates) {
        this.bookingDates = bookingDates;
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
