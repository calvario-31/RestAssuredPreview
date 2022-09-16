package models.auth;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest extends BaseModel {
    public final static String loginResponseSchema = "login/LoginResponse.json";
    @JsonProperty("username")
    private final String username;
    @JsonProperty("password")
    private final String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
