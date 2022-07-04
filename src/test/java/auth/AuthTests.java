package auth;

import base.BaseTest;
import org.testng.annotations.Test;

public class AuthTests extends BaseTest {

    @Test
    public void loginTest() {
        commonFlows.loginValidUser();
    }
}
