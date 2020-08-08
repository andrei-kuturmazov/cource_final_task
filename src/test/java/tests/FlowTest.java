package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class FlowTest {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Login test")
    @Order(1)
    void loginTest() {
        loginPage.openLoginPage();
        loginPage.enterCredentialsAndSubmitLogin();
    }
}
