package tests;


import org.junit.jupiter.api.*;
import pages.*;
import utils.TestInit;

import static io.qameta.allure.Allure.step;

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
        step("Main page open and login as administrator", () -> {
            loginPage.openLoginPage();
            loginPage.loginToApp();
        });
        step("Create test employee", () -> employeePage.createSalesManagerEmployee());
    }

    @Test
    @DisplayName("User creation test")
    @Order(2)
    void checkUserCreation() {
        step("Switch to user administration tab", () -> userPage.switchToAdminTabPanel());
        step("Check form header and fields", () -> userPage.checkFormElements());
        step("Check validation message interaction", () -> userPage.checkValidationMessage());
        step("Fill users form with valid data and submit", () -> userPage.fillUserCreationFormAndSubmit());
        step("Check success message interaction", () -> Assertions.assertTrue(userPage.checkSuccessMessage()));
    }

    @Test
    @DisplayName("Job titles adding test")
    @Order(3)
    void checkJobTitlesAdding() {
        step("Switch to user administration tab", () -> userPage.switchToAdminTabPanel());
        step("Switch to job titles tab", () -> jobTitlesPage.switchToJobTitlesTab());
        step("Add new job titles", () -> jobTitlesPage.addJobTitle());
    }

    @Test
    @DisplayName("Job titles deleting test")
    @Order(4)
    void checkJobTitlesDeleting() {
        step("Delete added job titles", () -> jobTitlesPage.deleteJobTitles());
    }

    @Test
    @DisplayName("Candidate adding test")
    @Order(5)
    void checkCandidateAdding() {
        step("Add new candidate", () -> recruitmentPage.addCandidateAndCheckCreation());
    }

    @Test
    @DisplayName("Dashboard elements interaction test")
    @Order(6)
    void checkDashboardElements() {
        step("Check Dashboard tab elements", () -> {
            dashboardPage.switchToDashboardTab();
            dashboardPage.checkDashboardElements();
        });
    }

    @Test
    @DisplayName("Sales manager profile test")
    @Order(7)
    void checkSalesProfile() {
        step("Switch to Sales manager profile", () -> salesPage.openSalesProfile());
        step("Check Sales manager personal profile fields", () -> salesPage.checkPersonalDetailsElements());
        step("Log information about manager from profile", () -> salesPage.getSalesManagerPersonalInfo());
    }

    @Test
    @DisplayName("Assign leave form test")
    @Order(8)
    void checkAssignLeave() {
        step("Check Assign Leave Form message", () -> {
            leavePage.switchToAssignLeaveTab();
            leavePage.checkFormValidationMessage();
        });

        step("Check Form elements", () -> leavePage.checkFormElements());
        step("Fill form with data", () -> leavePage.fillLeaveForm());
        step("Check success message interaction", () -> Assertions.assertTrue(leavePage.checkSuccessMessage()));
    }

    @Test
    @DisplayName("Logout functionality test")
    @Order(9)
    void checkLogout() {
        step("Delete created test employee and test user", ()-> {
            employeePage.deleteEmployee();
            Assertions.assertTrue(employeePage.checkSuccessMessage());
        });
        step("Check logout functionality", () -> loginPage.logoutFromApp());
    }
}
