package models.auth;

import base.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginModel extends BaseModel {
    @JsonProperty("username")
    private final String username;
    @JsonProperty("password")
    private final String password;

    public LoginModel(String username, String password) {
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
