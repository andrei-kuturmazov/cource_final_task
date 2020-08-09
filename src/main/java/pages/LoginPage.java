package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import utils.Property;


import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public String baseUrl = Property.getProperty("url");

    private final SelenideElement loginField = $x("//input[@id='txtUsername']");
    private final SelenideElement passwordField = $x("//input[@id='txtPassword']");
    private final SelenideElement loginButton = $x("//input[@id='btnLogin']");
    private final SelenideElement adminPanelButton = $x("//a[@id='menu_admin_viewAdminModule']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement employeeNameField = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement userNameField = $x("//input[@id='systemUser_userName']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement recruitmentTabLink = $x("//a[@id='menu_recruitment_viewRecruitmentModule']");
    private final SelenideElement candidateFirstNameField = $x("//input[@id='addCandidate_firstName']");
    private final SelenideElement candidateLastNameField = $x("//input[@id='addCandidate_lastName']");
    private final SelenideElement candidateEmail = $x("//input[@id='addCandidate_email']");
    private final SelenideElement userLink = $x("//a[@id='welcome']");
    private final SelenideElement logoutLink = $x("//a[contains(text(), 'Logout')]");
    private final SelenideElement errorMessage = $x("//div[@class='message error']");
    private final SelenideElement pimTabLink = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement salesProfile = $x("//td[contains(text(), 'Sales ')]/preceding-sibling::td[1]/a");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");

    public void openLoginPage() {
        Selenide.open(baseUrl);
    }

    public void loginToApp() {
        loginField.sendKeys(Property.getProperty("login"));
        passwordField.sendKeys(Property.getProperty("password"));
        loginButton.click();
    }

    public void switchToAdminTabPanel() {
        adminPanelButton.click();
    }

    public void addUser() {
        addButton.click();
    }

    public void inputEmployeeName() {
        employeeNameField.sendKeys(Property.getProperty("employeeName"));
    }

    public void inputUserName() {
        userNameField.sendKeys(Property.getProperty("userName"));
    }

    public void submitCreationForm() {
        formSaveButton.click();
    }

    public void fillUserCreationFormAndSubmit() throws InterruptedException {
        addUser();
        inputEmployeeName();
        inputUserName();
        Thread.sleep(1000);
        submitCreationForm();
        checkSuccessMessage();
    }

    public void checkSuccessMessage() {
        successMessage.isDisplayed();
    }

    public void logoutFromApp() {
        userLink.click();
        logoutLink.click();
    }

    public void addCandidate() {
        recruitmentTabLink.click();
        addButton.click();
        candidateFirstNameField.sendKeys("Hello");
        candidateLastNameField.sendKeys("World");
        candidateEmail.sendKeys("hello-world@gmail.com");
        formSaveButton.click();
    }

    public void switchToPIMTab() {
        pimTabLink.click();
    }

    public void addCandidateAndCheckCreation() {
        addCandidate();
        errorMessage.shouldNotBe(Condition.visible);
    }

    public void openSalesProfile() {
        switchToPIMTab();
        salesProfile.click();
    }
}
