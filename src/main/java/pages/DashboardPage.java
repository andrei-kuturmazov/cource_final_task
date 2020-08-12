package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

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

    public void switchToDashboardTab() {
        dashBoardTabLink.click();
    }

    public void checkDashboardElements() {
        dashBoardTitle.shouldBe(Condition.visible);
        checkQuickLaunchElements();
        checkEmployeeDistributionElements();
    }

    public void checkQuickLaunchElements() {
        assignLeaveLink.shouldBe(Condition.visible);
        leaveListLink.shouldBe(Condition.visible);
        timeSheetLink.shouldBe(Condition.visible);
    }

    public void checkEmployeeDistributionElements() {
        dashBoardDiagram.shouldBe(Condition.visible);
        dashBoardLegend.shouldBe(Condition.visible);
        dashBoardPendingRequests.shouldBe(Condition.visible);
    }
}
