package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class LeavePage {

    private final SelenideElement leaveMenuTabLink = $x("//a[@id='menu_leave_viewLeaveModule']");
    private final SelenideElement assignLeaveLink = $x("//a[@id='menu_leave_assignLeave']");
    private final SelenideElement assignLeaveLabel = $x("//h1[contains(text(), 'Assign Leave')]");
    private final SelenideElement employeeNameLabel = $x("//label[contains(text(), 'Employee Name')]");
    private final SelenideElement employeeNameField = $x("//input[@id='assignleave_txtEmployee_empName']");
    private final SelenideElement employeeFieldValidationMessage = $x("//span[@for='assignleave_txtEmployee_empName']");
    private final SelenideElement leaveTypeLabel = $x("//label[contains(text(), 'Leave Type')]");
    private final SelenideElement leaveTypeDropdown = $x("//select[@id='assignleave_txtLeaveType']");
    private final SelenideElement leaveTypeValidationMessage = $x("//span[@for='assignleave_txtLeaveType']");
    private final SelenideElement flmsLeaveOption = $x("//option[@value='2']");
    private final SelenideElement leaveBalanceLabel = $x("//label[contains(text(), 'Leave Balance')]");
    private final SelenideElement startDateLabel = $x("//label[contains(text(), 'From Date')]");
    private final SelenideElement startDateLeaveCalendar = $x("//input[@id='assignleave_txtFromDate']");
    private final SelenideElement startDateValidationMessage = $x("//span[@for='assignleave_txtFromDate']");
    private final SelenideElement firstDateOfMonth = $x("//a[contains(text(), '1')]");
    private final SelenideElement endDateLabel = $x("//label[contains(text(), 'To Date')]");
    private final SelenideElement endDateLeaveCalendar = $x("//input[@id='assignleave_txtToDate']");
    private final SelenideElement endDateValidationMessage = $x("//span[@for='assignleave_txtToDate']");
    private final SelenideElement fifthDateOfMonth = $x("//a[contains(text(), '5')]");
    private final SelenideElement commentFieldLabel = $x("//label[contains(text(), 'Comment')]");
    private final SelenideElement commentField = $x("//textarea[@id='assignleave_txtComment']");
    private final SelenideElement assignButton = $x("//input[@id='assignBtn']");
    private final SelenideElement confirmButton = $x("//input[@id='confirmOkButton']");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");

    public void switchToAssignLeaveTab() {
        leaveMenuTabLink.click();
        assignLeaveLink.click();
    }

    public void submitForm() {
        assignButton.click();
    }

    public void confirmForm() {
        confirmButton.click();
    }

    @Step("Check validation message interaction for mandatory fields")
    public void checkFormValidationMessage() {
        submitForm();
        employeeFieldValidationMessage.shouldBe(Condition.visible);
        leaveTypeValidationMessage.shouldBe(Condition.visible);
        startDateValidationMessage.shouldBe(Condition.visible);
        endDateValidationMessage.shouldBe(Condition.visible);
    }

    @Step("Check leave form main elements")
    public void checkFormElements() {
        assignLeaveLabel.shouldBe(Condition.visible);
        leaveBalanceLabel.shouldBe(Condition.visible);
        checkEmployeeFieldBlock();
        checkLeaveTypeBlock();
        checkStartDateBlock();
        checkEndDateBlock();
        checkCommentsBlock();
    }

    public void checkEmployeeFieldBlock() {
        employeeNameLabel.shouldBe(Condition.visible);
        employeeNameField.shouldBe(Condition.visible);
    }

    public void checkLeaveTypeBlock() {
        leaveTypeLabel.shouldBe(Condition.visible);
        leaveTypeDropdown.shouldBe(Condition.visible);
    }

    public void checkStartDateBlock() {
        startDateLabel.shouldBe(Condition.visible);
        startDateLeaveCalendar.shouldBe(Condition.visible);
    }

    public void checkEndDateBlock() {
        endDateLabel.shouldBe(Condition.visible);
        endDateLeaveCalendar.shouldBe(Condition.visible);
    }

    public void checkCommentsBlock() {
        commentFieldLabel.shouldBe(Condition.visible);
        commentField.shouldBe(Condition.visible);
    }

    public void fillLeaveForm() throws InterruptedException {
        employeeNameField.sendKeys(Property.getProperty("leaveUser"));
        leaveTypeDropdown.click();
        flmsLeaveOption.click();
        startDateLeaveCalendar.click();
        firstDateOfMonth.click();
        endDateLeaveCalendar.click();
        fifthDateOfMonth.click();
        Thread.sleep(1000);
        submitForm();
        confirmForm();
    }

    public boolean checkSuccessMessagePresent() {
        return successMessage.isDisplayed();
    }
}
