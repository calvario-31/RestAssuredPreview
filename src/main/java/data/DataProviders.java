package data;

import models.auth.LoginRequest;

public class DataProviders {
    public LoginRequest getValidUser() {
        return new LoginRequest("admin", "password123");
    }
}
