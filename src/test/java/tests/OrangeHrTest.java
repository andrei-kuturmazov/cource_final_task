package tests;


import org.junit.jupiter.api.*;
import utils.TestInit;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrangeHrTest extends TestInit {

    @Test
    @DisplayName("Create test employee")
    @Order(1)
    void createTestEmployee() {
        employeePage.createSalesManagerEmployee();
    }

    @Test
    @DisplayName("User creation test")
    @Order(2)
    void checkUserCreation() {
        userPage.switchToAdminTabPanel()
                .checkFormElements()
                .checkValidationMessage()
                .fillUserCreationFormAndSubmit();
        Assertions.assertTrue(userPage.checkSuccessMessage());
    }

    @Test
    @DisplayName("Job titles adding test")
    @Order(3)
    void checkJobTitlesAdding() {
        userPage.switchToAdminTabPanel();
        jobTitlesPage.switchToJobTitlesTab()
                .addJobTitle();
    }

    @Test
    @DisplayName("Job titles deleting test")
    @Order(4)
    void checkJobTitlesDeleting() {
        userPage.switchToAdminTabPanel();
        jobTitlesPage.switchToJobTitlesTab()
                .deleteJobTitles();
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
        dashboardPage.switchToDashboardTab()
                .checkDashboardElements();

    }

    @Test
    @DisplayName("Sales manager profile test")
    @Order(7)
    void checkSalesProfile() {
        salesPage.openSalesProfile()
                .checkPersonalDetailsFormElements()
                .checkSalesManagerPersonalInfo();

    }

    @Test
    @DisplayName("Assign leave form test")
    @Order(8)
    void checkAssignLeave() {
        leavePage.switchToAssignLeaveTab()
                .checkFormValidationMessage()
                .checkFormElements()
                .createLeaveRequest();
        Assertions.assertTrue(leavePage.checkSuccessMessage());
    }

    @Test
    @DisplayName("Test employee delete")
    @Order(9)
    void deleteTestEmployee() {
        employeePage.deleteEmployee();
        Assertions.assertTrue(employeePage.checkSuccessMessage());
    }
}
