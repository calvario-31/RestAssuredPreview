package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;
import org.testng.asserts.SoftAssert;

public class Booking extends BaseModel {
    public static String schemaPath = "booking/BookingModel.json";
    @JsonProperty("firstname")
    private final String firstname;
    @JsonProperty("lastname")
    private final String lastname;
    @JsonProperty("totalprice")
    private final int totalPrice;
    @JsonProperty("depositpaid")
    private final boolean paid;
    @JsonProperty("additionalneeds")
    private final String additionalNeeds;
    @JsonProperty("bookingdates")
    private final BookingDates bookingDates;

    public Booking() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        totalPrice = faker.number().numberBetween(5, 100);
        paid = faker.bool().bool();
        additionalNeeds = faker.animal().name();
        bookingDates = new BookingDates();
    }

    public Booking isEqualsTo(Booking booking) {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(booking.getFirstname(), firstname);
        softAssert.assertEquals(booking.getLastname(), lastname);
        softAssert.assertEquals(booking.getTotalPrice(), totalPrice);
        softAssert.assertEquals(booking.getAdditionalNeeds(), additionalNeeds);
        softAssert.assertEquals(booking.getBookingDates().getCheckIn(), bookingDates.getCheckIn());
        softAssert.assertEquals(booking.getBookingDates().getCheckOut(), bookingDates.getCheckOut());
        softAssert.assertAll();
        return this;
    }

    public void isEqualsTo(BookingPartial bookingModel) {
        var softAssert = new SoftAssert();
        softAssert.assertEquals(bookingModel.getFirstname(), firstname);
        softAssert.assertEquals(bookingModel.getLastname(), lastname);
        softAssert.assertEquals(bookingModel.getAdditionalNeeds(), additionalNeeds);
        softAssert.assertAll();
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
