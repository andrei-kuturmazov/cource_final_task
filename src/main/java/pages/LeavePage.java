package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LeavePage {

    private final SelenideElement leaveMenuTabLink = $x("//a[@id='menu_leave_viewLeaveModule']");
    private final SelenideElement assignLeaveLink = $x("//a[@id='menu_leave_assignLeave']");
    private final SelenideElement employeeNameAssignLeave = $x("//input[@id='assignleave_txtEmployee_empName']");
    private final SelenideElement leaveTypeDropdown = $x("//select[@id='assignleave_txtLeaveType']");
    private final SelenideElement flmsLeaveOption = $x("//option[@value='2']");
    private final SelenideElement startDateLeaveCalendar = $x("//input[@id='assignleave_txtFromDate']");
    private final SelenideElement firstDateOfMonth = $x("//a[contains(text(), '1')]");
    private final SelenideElement endDateLeaveCalendar = $x("//input[@id='assignleave_txtToDate']");
    private final SelenideElement fifthDateOfMonth = $x("//a[contains(text(), '5')]");
    private final SelenideElement assignButton = $x("//input[@id='assignBtn']");
    private final SelenideElement confirmButton = $x("//input[@id='confirmOkButton']");

    public void switchToAssignLeaveTab() {
        leaveMenuTabLink.click();
        assignLeaveLink.click();
    }

    public void fillLeaveForm() throws InterruptedException {
        employeeNameAssignLeave.sendKeys("Linda Anderson");
        leaveTypeDropdown.click();
        flmsLeaveOption.click();
        startDateLeaveCalendar.click();
        firstDateOfMonth.click();
        endDateLeaveCalendar.click();
        fifthDateOfMonth.click();
        Thread.sleep(1000);
        assignButton.click();
        confirmButton.click();
    }
}
