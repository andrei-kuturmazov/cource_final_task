package tests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import utils.TestInit;

public class FlowTest extends TestInit {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Login test")
    @Order(1)
    void loginTest() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.enterCredentialsAndSubmitLogin();
        loginPage.switchToAdminTabPanel();
        //loginPage.addNewUser();
        //loginPage.fillUserCreationFormAndSubmit();
        loginPage.switchToJobTitlesTab();
        loginPage.addNewJobTitle();
        loginPage.addNewCandidate();

        Thread.sleep(5000);
    }
}
