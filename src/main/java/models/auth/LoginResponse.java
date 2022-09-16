package models.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponse {
    @JsonProperty("token")
    private String token;

    public String getToken() {
        return token;
    }
}
