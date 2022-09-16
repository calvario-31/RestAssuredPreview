package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public class BookingPartialModel extends BaseModel {
    @JsonProperty("firstname")
    private final String firstname;
    @JsonProperty("lastname")
    private final String lastname;
    @JsonProperty("additionalneeds")
    private final String additionalNeeds;

    public BookingPartialModel() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        additionalNeeds = faker.animal().name();
    }
}
