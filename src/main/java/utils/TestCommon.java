package utils;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import pages.LoginPage;

public class TestCommon {

    LoginPage loginPage = new LoginPage();

    @BeforeEach
    void login() {
        loginPage.openLoginPage();
        loginPage.loginToApp();
    }

    @AfterEach
    public void logout() {
        loginPage.logoutFromApp();
    }
}
