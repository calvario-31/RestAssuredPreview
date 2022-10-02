package booking;

import api.booking.BookingApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.booking.Booking;
import models.booking.BookingPartial;
import models.booking.BookingResponse;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {
    private final BookingApi bookingApi = new BookingApi();

    @BeforeMethod
    public void setup() {
        bookingApi.setAuth(false);
    }

    @Test
    public void crudBookingTest() {
        var bookingModel = new Booking();
        //CREATE
        var bookingId = bookingApi.createBooking(bookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(BookingResponse.schemaPath)))
                .extract().body().as(BookingResponse.class).getBookingId();

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(Booking.schemaPath)))
                .extract().body().as(Booking.class)
                .isEqualsTo(bookingModel);

        //UPDATE
        bookingModel = new Booking();
        bookingApi.updateBooking(bookingId, bookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(Booking.schemaPath)));

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(Booking.schemaPath)))
                .extract().body().as(Booking.class)
                .isEqualsTo(bookingModel);

        //PARTIAL UPDATE
        var partialBookingModel = new BookingPartial();
        bookingApi.partialUpdateBooking(bookingId, partialBookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(Booking.schemaPath)));

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(Booking.schemaPath)))
                .extract().body().as(Booking.class)
                .isEqualsTo(partialBookingModel);

        //DELETE
        bookingApi.deleteBooking(bookingId).then()
                .assertThat()
                .statusCode(201);

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(404);
    }
}
