package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeePage {

    private final SelenideElement pimTabLink = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement employeeTabLink = $x("//a[@id='menu_pim_viewEmployeeList']");
    private final SelenideElement addEmployeeButton = $x("//input[@id='btnAdd']");
    private final SelenideElement firstNameField = $x("//input[@id='firstName']");
    private final SelenideElement lastNameField = $x("//input[@id='lastName']");
    private final SelenideElement saveUserButton = $x("//input[@id='btnSave']");
    private final SelenideElement employeeIdField = $x("//input[@id='employeeId']");
    private final SelenideElement idHeader = $x("//a[contains(text(), 'Id')]");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement dialogConfirmButton = $x("//input[@id='dialogDeleteBtn']");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");
    private String employeeId;
    private String employeeSelectCheckbox = String.format("//a[contains(text(), %s )]/parent::td/preceding-sibling::td", employeeId);

    public void switchToEmployeeList() {
        pimTabLink.click();
        employeeTabLink.click();
    }

    public void fillEmployeeForm() {
        addEmployeeButton.click();
        firstNameField.sendKeys(Property.getProperty("employeeName"));
        lastNameField.sendKeys(Property.getProperty("employeeLastName"));
        employeeId = employeeIdField.getText();
        saveUserButton.click();
    }

    public void createTestEmployee() {
        switchToEmployeeList();
        fillEmployeeForm();
    }

    public void sortEmployeeIdByDescending() {
        idHeader.click();
        idHeader.click();
    }

    public void confirmEmployeeDeleting() {
        $x(employeeSelectCheckbox).click();
        deleteButton.click();
        dialogConfirmButton.click();
    }

    public void deleteEmployee() {
        switchToEmployeeList();
        sortEmployeeIdByDescending();
        confirmEmployeeDeleting();
    }

    public boolean checkSuccessMessage() {
        return successMessage.isDisplayed();
    }
}
