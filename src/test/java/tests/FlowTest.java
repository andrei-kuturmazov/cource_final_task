package tests;


import org.junit.jupiter.api.*;
import pages.LeavePage;
import pages.LoginPage;
import utils.TestInit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FlowTest extends TestInit {

    LoginPage loginPage = new LoginPage();
    LeavePage leavePage = new LeavePage();

    @Test
    @DisplayName("Login test")
    @Order(1)
    void loginTest() {
        loginPage.openLoginPage();
        loginPage.loginToApp();
    }

    @Test
    @DisplayName("User creation test")
    @Order(2)
    void checkUserCreation() throws InterruptedException {
        loginPage.switchToAdminTabPanel();
        loginPage.fillUserCreationFormAndSubmit();
    }

    @Test
    @DisplayName("Job titles adding test")
    @Order(3)
    void checkJobTitlesAdding() {
        loginPage.switchToAdminTabPanel();
        loginPage.switchToJobTitlesTab();
        loginPage.addJobTitle();
    }

    @Test
    @DisplayName("Job titles deleting test")
    @Order(4)
    void checkJobTitlesDeleting() {
        loginPage.deleteJobTitles();
    }

    @Test
    @DisplayName("Candidate adding test")
    @Order(5)
    void checkCandidateAdding() {
        loginPage.addCandidateAndCheckCreation();
    }

    @Test
    @DisplayName("Dashboard elements interaction test")
    @Order(6)
    void checkDashboardElements() {
        loginPage.switchToDashboardTab();
        loginPage.checkDashboardElements();
    }
    @Test
    @DisplayName("Sales manager profile test")
    @Order(7)
    void checkSalesProfile() {
        loginPage.openSalesProfile();
    }

    @Test
    @DisplayName("assign leave form test")
    @Order(8)
    void checkAssignLeave() throws InterruptedException {
        leavePage.switchToAssignLeaveTab();
        leavePage.fillLeaveForm();
    }

    @Test
    @DisplayName("logout functionality test")
    @Order(9)
    void checkLogout() {
        loginPage.logoutFromApp();
    }
}
