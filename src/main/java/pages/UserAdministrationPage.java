package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
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
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");

    public void fillUserForm() {
        employeeField.sendKeys(Property.getProperty("employeeName"));
        userNameField.sendKeys(Property.getProperty("userName"));
    }

    public void submitCreationForm() {
        formSaveButton.click();
    }

    public void checkSuccessMessage() {
        successMessage.isDisplayed();
    }

    public void addUser() {
        addButton.click();
    }

    public void checkValidationMessage() {
        formSaveButton.click();
        employeeFieldValidationMessage.isDisplayed();
        userNameFieldValidationMessage.isDisplayed();
    }

    public void checkFormElements() {
        formHeader.shouldBe(Condition.visible);
        userRoleLabel.shouldBe(Condition.visible);
        userRoleDropDown.shouldBe(Condition.visible);
        employeeLabel.shouldBe(Condition.visible);
        employeeField.shouldBe(Condition.visible);
        userNameLabel.shouldBe(Condition.visible);
        userNameField.shouldBe(Condition.visible);
        statusLabel.shouldBe(Condition.visible);
    }

    public void fillUserCreationFormAndSubmit() throws InterruptedException {
        addUser();
        fillUserForm();
        Thread.sleep(1000);
        submitCreationForm();
        checkSuccessMessage();
    }
}
