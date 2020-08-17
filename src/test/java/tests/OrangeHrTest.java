package tests;


import org.junit.jupiter.api.*;
import pages.*;
import utils.TestInit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrangeHrTest extends TestInit {

    LoginPage loginPage = new LoginPage();
    LeavePage leavePage = new LeavePage();
    DashboardPage dashboardPage = new DashboardPage();
    JobTitlesPage jobTitlesPage = new JobTitlesPage();
    RecruitmentPage recruitmentPage = new RecruitmentPage();
    UserPage userPage = new UserPage();
    SalesPage salesPage = new SalesPage();
    EmployeePage employeePage = new EmployeePage();

    @Test
    @DisplayName("Login test")
    @Order(1)
    void loginTest() {
        loginPage.openLoginPage();
        loginPage.loginToApp();
        employeePage.createSalesManagerEmployee();
    }

    @Test
    @DisplayName("User creation test")
    @Order(2)
    void checkUserCreation() {
        userPage.switchToAdminTabPanel();
        userPage.checkFormElements();
        userPage.checkValidationMessage();
        userPage.fillUserCreationFormAndSubmit();
        Assertions.assertTrue(userPage.checkSuccessMessage());
    }

    @Test
    @DisplayName("Job titles adding test")
    @Order(3)
    void checkJobTitlesAdding() {
        userPage.switchToAdminTabPanel();
        jobTitlesPage.switchToJobTitlesTab();
        jobTitlesPage.addJobTitle();
    }

    @Test
    @DisplayName("Job titles deleting test")
    @Order(4)
    void checkJobTitlesDeleting() {
        jobTitlesPage.deleteJobTitles();
    }

    @Test
    @DisplayName("Candidate adding test")
    @Order(5)
    void checkCandidateAdding() {
        recruitmentPage.addCandidateAndCheckCreation();
    }

    @Test
    @DisplayName("Dashboard elements interaction test")
    @Order(6)
    void checkDashboardElements() {
        dashboardPage.switchToDashboardTab();
        dashboardPage.checkDashboardElements();

    }

    @Test
    @DisplayName("Sales manager profile test")
    @Order(7)
    void checkSalesProfile() {
        salesPage.openSalesProfile();
        salesPage.checkPersonalDetailsFormElements();
        salesPage.checkSalesManagerPersonalInfo();
    }

    @Test
    @DisplayName("Assign leave form test")
    @Order(8)
    void checkAssignLeave() {
        leavePage.switchToAssignLeaveTab();
        leavePage.checkFormValidationMessage();
        leavePage.checkFormElements();
        leavePage.createLeaveRequest();
        Assertions.assertTrue(leavePage.checkSuccessMessage());
    }

    @Test
    @DisplayName("Logout functionality test")
    @Order(9)
    void checkLogout() {
        employeePage.deleteEmployee();
        Assertions.assertTrue(employeePage.checkSuccessMessage());
        loginPage.logoutFromApp();
    }
}
