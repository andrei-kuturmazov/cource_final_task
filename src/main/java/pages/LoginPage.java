package pages;

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
    private final SelenideElement addUserButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement employeeNameField = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement userNameField = $x("//input[@id='systemUser_userName']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");


    public void openLoginPage() {
        Selenide.open(baseUrl);
    }

    public void enterCredentialsAndSubmitLogin() {
        loginField.sendKeys(Property.getProperty("login"));
        passwordField.sendKeys(Property.getProperty("password"));
        loginButton.click();
    }

    public void switchToAdminTabPanel() {
        adminPanelButton.click();
    }

    public void addNewUser() {
        addUserButton.click();
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

    public void fillUserCreationFormAndSubmit() {
        inputEmployeeName();
        inputUserName();
        submitCreationForm();
    }
}
