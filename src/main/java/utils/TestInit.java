package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import pages.*;


public class TestInit extends TestCommon {

    public LeavePage leavePage = new LeavePage();
    public DashboardPage dashboardPage = new DashboardPage();
    public JobTitlesPage jobTitlesPage = new JobTitlesPage();
    public RecruitmentPage recruitmentPage = new RecruitmentPage();
    public UserPage userPage = new UserPage();
    public SalesPage salesPage = new SalesPage();
    public EmployeePage employeePage = new EmployeePage();

    @BeforeAll
    static void setUp() {
        Configuration.timeout = 5000;
        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.remote = "http://localhost:4444/wd/hub";
//        Configuration.browserSize = "1920x1080";
//        Configuration.browserCapabilities.setCapability("enableVNC", true);
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
        Selenide.closeWebDriver();
    }
}
