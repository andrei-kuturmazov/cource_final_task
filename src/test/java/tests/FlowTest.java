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
    void loginTest() throws InterruptedException {
        loginPage.openLoginPage();
        loginPage.loginToApp();

        loginPage.switchToAdminTabPanel();
//        loginPage.addUser();
//        loginPage.fillUserCreationFormAndSubmit();
//        loginPage.switchToJobTitlesTab();
//        loginPage.addJobTitle();
//        loginPage.checkSuccessMessage();
//        loginPage.deleteJobTitles();
//        loginPage.addCandidateAndCheckCreation();
//        loginPage.switchToAssignLeaveTab();
//        loginPage.checkDashboardElements();
//        loginPage.logoutFromApp();
//        loginPage.openSalesProfile();

//        Thread.sleep(5000);
    }

    @Test
    @DisplayName("Check dashboard elements interaction")
    @Order(2)
    void checkDashboardElements() {
        loginPage.switchToDashboardTab();
        loginPage.checkDashboardElements();
    }

    @Test
    @DisplayName("Check logout option")
    @Order(3)
    void checkJobTitlesAdding() {
        loginPage.switchToAdminTabPanel();
        loginPage.switchToJobTitlesTab();
        loginPage.addJobTitle();
    }

    @Test
    @DisplayName("Delete added job titles")
    @Order(4)
    void checkJobTitlesDeleting() {
        loginPage.switchToAdminTabPanel();
        loginPage.switchToJobTitlesTab();
        loginPage.deleteJobTitles();
    }

    @Test
    @DisplayName("Check logout option")
    @Order(5)
    void checkLogout() {
        loginPage.logoutFromApp();
    }
}
