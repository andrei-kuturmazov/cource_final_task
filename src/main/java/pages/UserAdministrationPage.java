package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class UserAdministrationPage {

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
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");

    @Step("Fill user creation form with correct data")
    public void fillUserForm() {
        employeeField.sendKeys(Property.getProperty("employeeName"));
        userNameField.sendKeys(Property.getProperty("userName"));
    }

    @Step("Submit new user creation")
    public void submitCreationForm() {
        saveButton.click();
    }

    @Step("Check successful user creation")
    public void checkSuccessMessage() {
        successMessage.isDisplayed();
    }

    public void addUser() {
        addButton.click();
    }

    @Step("Check validation message interaction for mandatory fields")
    public void checkValidationMessage() {
        saveButton.click();
        employeeFieldValidationMessage.isDisplayed();
        userNameFieldValidationMessage.isDisplayed();
    }

    @Step("Check user adding form specific elements")
    public void checkFormElements() {
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
        addUser();
        fillUserForm();
        Thread.sleep(1000);
        submitCreationForm();
        checkSuccessMessage();
    }
}
