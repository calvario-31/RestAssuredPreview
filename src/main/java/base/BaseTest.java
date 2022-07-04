package base;

import utilities.CommonFlows;

public class BaseTest {
    protected String token;
    protected CommonFlows commonFlows = new CommonFlows();

    protected void assignToken() {
        token = commonFlows.loginValidUser().getToken();
    }
}
