package data;

import models.auth.LoginModel;

public class DataProviders {
    public LoginModel getValidUser() {
        return new LoginModel("admin", "password123");
    }
}
