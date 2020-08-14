package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private final SelenideElement dashBoardTabLink = $x("//a[@id='menu_dashboard_index']");
    private final SelenideElement assignLeaveLink = $x("//span[contains(text(), 'Assign Leave')]/parent::a/parent::div");
    private final SelenideElement leaveListLink = $x("//span[contains(text(), 'Leave List')]/parent::a/parent::div");
    private final SelenideElement timeSheetLink = $x("//span[contains(text(), 'Timesheets')]/parent::a/parent::div");
    private final SelenideElement dashBoardTitle = $x("//h1[contains(text(), 'Dashboard')]");
    private final SelenideElement dashBoardDiagram = $x("//div[@id='dashboard__employeeDistribution']");
    private final SelenideElement dashBoardLegend = $x("//div[@id='panel_draggable_1_1']");
    private final SelenideElement dashBoardPendingRequests = $x("//div[@id='task-list-group-panel-menu_holder']");

    /* Steps */

    @Step("Switch to Dashboard Tab")
    public void switchToDashboardTab() {
        dashBoardTabLink.click();
    }

    @Step("Check Dashboard page elements")
    public void checkDashboardElements() {
        checkDashboardTitle();
        checkQuickLaunchElements();
        checkEmployeeDistributionElements();
    }

    @Step("Check Dashboard Title Interaction")
    public void checkDashboardTitle() {
        dashBoardTitle.shouldBe(Condition.visible);
    }

    @Step("Check QuickLaunch Block elements")
    public void checkQuickLaunchElements() {
        assignLeaveLink.shouldBe(Condition.visible);
        leaveListLink.shouldBe(Condition.visible);
        timeSheetLink.shouldBe(Condition.visible);
    }

    @Step("Check Employee Distribution Block elements")
    public void checkEmployeeDistributionElements() {
        dashBoardDiagram.shouldBe(Condition.visible);
        dashBoardLegend.shouldBe(Condition.visible);
        dashBoardPendingRequests.shouldBe(Condition.visible);
    }
}
