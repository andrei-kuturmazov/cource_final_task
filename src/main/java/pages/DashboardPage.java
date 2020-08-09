package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class DashboardPage {

    private final SelenideElement dashBoardTabLink = $x("//a[@id='menu_dashboard_index']");
    private final SelenideElement dashBoardDiagram = $x("//div[@id='dashboard__employeeDistribution']");
    private final SelenideElement dashBoardLegend = $x("//div[@id='panel_draggable_1_1']");
    private final SelenideElement dashBoardPendingRequests = $x("//div[@id='task-list-group-panel-menu_holder']");

    public void switchToDashboardTab() {
        dashBoardTabLink.click();
    }

    public void checkDashboardElements() {
        dashBoardDiagram.shouldBe(Condition.visible);
        dashBoardLegend.shouldBe(Condition.visible);
        dashBoardPendingRequests.shouldBe(Condition.visible);
    }
}
