package models.booking;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.javafaker.Faker;

public class BookingPartial extends BaseModel {
    @JsonProperty("firstname")
    private final String firstname;
    @JsonProperty("lastname")
    private final String lastname;
    @JsonProperty("additionalneeds")
    private final String additionalNeeds;

    public BookingPartial() {
        var faker = new Faker();
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        additionalNeeds = faker.animal().name();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }
}
