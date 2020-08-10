package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class UserAdministrationPage {

    private final SelenideElement employeeNameField = $x("//input[@id='systemUser_employeeName_empName']");
    private final SelenideElement userNameField = $x("//input[@id='systemUser_userName']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");

    public void fillUserForm() {
        employeeNameField.sendKeys(Property.getProperty("employeeName"));
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

    public void fillUserCreationFormAndSubmit() throws InterruptedException {
        addUser();
        fillUserForm();
        Thread.sleep(1000);
        submitCreationForm();
        checkSuccessMessage();
    }
}
