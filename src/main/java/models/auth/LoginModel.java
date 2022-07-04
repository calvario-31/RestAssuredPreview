package models.auth;

import base.BaseModel;

public class LoginModel extends BaseModel {
    private final String username;
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
