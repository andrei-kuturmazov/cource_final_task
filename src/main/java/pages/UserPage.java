package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class UserPage {

    private final SelenideElement adminPanelButton = $x("//a[@id='menu_admin_viewAdminModule']");
    private final SelenideElement formHeader = $x("//h1[@id='UserHeading']");
    private final SelenideElement userRoleLabel = $x("//label[contains(text(), 'User Role')]");
    private final SelenideElement userRoleDropDown = $x("//select[@id='systemUser_userType']");
    private final SelenideElement employeeLabel = $x("//label[contains(text(), 'Employee Name')]");
    private final SelenideElement employeeField = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement employeeFieldValidationMessage = $x("//span[@for='systemUser_employeeName_empName']");
    private final SelenideElement userNameLabel = $x("//label[contains(text(), 'Username')]");
    private final SelenideElement userNameField = $x("//input[@id='systemUser_userName']");
    private final SelenideElement userNameFieldValidationMessage = $x("//span[@for='systemUser_userName']");
    private final SelenideElement statusLabel = $x("//label[contains(text(), 'Status')]");
    private final SelenideElement statusDropDown = $x("//select[@id='systemUser_status']");
    private final SelenideElement passwordFieldLabel = $x("//label[@for='systemUser_password']");
    private final SelenideElement passwordField = $x("//input[@id='systemUser_password']");
    private final SelenideElement passwordFieldDescription = $x("//div[@class='helpText']/span[contains(text(),'For a strong')]");
    private final SelenideElement confirmPasswordLabel = $x("//label[contains(text(), 'Confirm Password')]");
    private final SelenideElement confirmPasswordField = $x("//input[@id='systemUser_confirmPassword']");
    private final SelenideElement saveButton = $x("//input[@id='btnSave']");
    private final SelenideElement cancelButton = $x("//input[@id='btnCancel']");
    private final SelenideElement addButton = $x("//input[@id='btnAdd']");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");

    public void switchToAdminTabPanel() {
        adminPanelButton.click();
    }

    public void fillUserForm() {
        employeeField.sendKeys(String.format("%s %s", Property.getProperty("employeeName"), Property.getProperty("employeeLastName")));
        userNameField.sendKeys(Property.getProperty("userName"));
    }

    public void submitCreationForm() {
        saveButton.click();
    }

    public void openUserForm() {
        addButton.click();
    }

    public void checkValidationMessage() {
        saveButton.click();
        employeeFieldValidationMessage.shouldBe(Condition.visible);
        userNameFieldValidationMessage.shouldBe(Condition.visible);
    }

    public void checkFormElements() {
        openUserForm();
        formHeader.shouldBe(Condition.visible);
        checkUserRoleBlock();
        checkEmployeeNameBlock();
        checkUserNameBlock();
        checkStatusBlock();
        checkPasswordBlock();
        checkConfirmPasswordBlock();
        checkButtonsBlock();
    }

    public void checkUserRoleBlock() {
        userRoleLabel.shouldBe(Condition.visible);
        userRoleDropDown.shouldBe(Condition.visible);
    }

    public void checkEmployeeNameBlock() {
        employeeLabel.shouldBe(Condition.visible);
        employeeField.shouldBe(Condition.visible);
    }

    public void checkUserNameBlock() {
        userNameLabel.shouldBe(Condition.visible);
        userNameField.shouldBe(Condition.visible);
    }

    public void checkStatusBlock() {
        statusLabel.shouldBe(Condition.visible);
        statusDropDown.shouldBe(Condition.visible);
    }

    public void checkPasswordBlock() {
        passwordFieldLabel.shouldBe(Condition.visible);
        passwordField.shouldBe(Condition.visible);
        passwordFieldDescription.shouldBe(Condition.visible);
    }

    public void checkConfirmPasswordBlock() {
        confirmPasswordLabel.shouldBe(Condition.visible);
        confirmPasswordField.shouldBe(Condition.visible);
    }

    public void checkButtonsBlock() {
        saveButton.shouldBe(Condition.visible);
        cancelButton.shouldBe(Condition.visible);
    }

    public void fillUserCreationFormAndSubmit() throws InterruptedException {
        fillUserForm();
        Thread.sleep(1000);
        submitCreationForm();
    }

    public boolean checkSuccessMessage() {
        return successMessage.waitUntil(Condition.visible, 1000).isDisplayed();
    }
}
