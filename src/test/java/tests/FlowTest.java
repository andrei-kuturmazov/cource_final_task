package tests;


import org.junit.jupiter.api.*;
import pages.LoginPage;
import utils.TestInit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlowTest extends TestInit {

    LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Login test")
    @Order(1)
    void loginTest() {
        loginPage.openLoginPage();
        loginPage.loginToApp();
    }

    @Test
    @DisplayName("Check User creation")
    @Order(2)
    void checkUserCreation() throws InterruptedException {
        loginPage.switchToAdminTabPanel();
        loginPage.fillUserCreationFormAndSubmit();
    }

    @Test
    @DisplayName("Check Job titles adding")
    @Order(3)
    void checkJobTitlesAdding() {
        loginPage.switchToAdminTabPanel();
        loginPage.switchToJobTitlesTab();
        loginPage.addJobTitle();
    }

    @Test
    @DisplayName("Check job titles delete")
    @Order(4)
    void checkJobTitlesDeleting() {
        loginPage.deleteJobTitles();
    }

    @Test
    @DisplayName("Check candidate adding")
    @Order(5)
    void checkCandidateAdding() {
        loginPage.addCandidateAndCheckCreation();
    }

    @Test
    @DisplayName("Check dashboard elements interaction")
    @Order(6)
    void checkDashboardElements() {
        loginPage.switchToDashboardTab();
        loginPage.checkDashboardElements();
    }
    @Test
    @DisplayName("Check sales manager profile")
    @Order(7)
    void checkSalesProfile() {
        loginPage.openSalesProfile();
    }

    @Test
    @DisplayName("Check logout option")
    @Order(8)
    void checkLogout() throws InterruptedException {
        loginPage.logoutFromApp();
        Thread.sleep(2000);
    }
}
