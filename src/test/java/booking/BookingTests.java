package booking;

import api.booking.BookingApi;
import base.BaseTest;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.booking.BookingModel;
import models.booking.BookingPartialModel;
import models.booking.BookingResponse;
import org.testng.annotations.Test;

public class BookingTests extends BaseTest {
    private final BookingApi bookingApi = new BookingApi();
    private final String bookingResponseSchema = "booking/BookingResponse.json";
    private final String bookingModelSchema = "booking/BookingModel.json";

    @Test
    public void crudBookingTest() {
        var bookingModel = new BookingModel();

        //CREATE
        var bookingId = bookingApi.createBooking(bookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingResponseSchema)))
                .extract().body().as(BookingResponse.class).getBookingId();

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingModelSchema)));

        //UPDATE
        bookingModel = new BookingModel();
        bookingApi.updateBooking(bookingId, bookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingModelSchema)));

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingModelSchema)))
                .extract().body().as(BookingModel.class);

        //PARTIAL UPDATE
        var partialBookingModel = new BookingPartialModel();
        bookingApi.partialUpdateBooking(bookingId, partialBookingModel).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingModelSchema)));

        //GET
        bookingApi.getBooking(bookingId).then()
                .assertThat()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchema(getSchema(bookingModelSchema)));

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
