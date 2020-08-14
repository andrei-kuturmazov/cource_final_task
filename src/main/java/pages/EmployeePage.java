package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;

import static com.codeborne.selenide.Selenide.$x;

public class EmployeePage {

    private final SelenideElement pimTabLink = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement employeeTabLink = $x("//a[@id='menu_pim_viewEmployeeList']");
    private final SelenideElement addEmployeeButton = $x("//input[@id='btnAdd']");
    private final SelenideElement firstNameField = $x("//input[@id='firstName']");
    private final SelenideElement lastNameField = $x("//input[@id='lastName']");
    private final SelenideElement saveButton = $x("//input[@id='btnSave']");
    private final SelenideElement employeeIdField = $x("//input[@id='employeeId']");
    private final SelenideElement idHeader = $x("//a[contains(text(), 'Id')]");
    private final SelenideElement jobLink = $x("//ul[@id='sidenav']/li/a[contains(text(), 'Job')]");
    private final SelenideElement jobTitle = $x("//select[@id='job_job_title']");
    private final SelenideElement salesManagerOption = $x("//option[contains(text(), 'Sales Manager')]");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement dialogConfirmButton = $x("//input[@id='dialogDeleteBtn']");
    private final SelenideElement successMessage = $x("//div[@class ='message success fadable']");
    public static String employeeId;

    /* Steps */

    @Step("Switch to Employee list Tab")
    public void switchToEmployeeList() {
        pimTabLink.click();
        employeeTabLink.click();
    }

    @Step("Create Sales Manager test employee")
    public void createSalesManagerEmployee() {
        switchToEmployeeList();
        fillEmployeeForm();
        addingSalesManagerJob();
    }

    @Step("Fill Employee form with data")
    public void fillEmployeeForm() {
        addEmployeeButton.click();
        firstNameField.sendKeys(Property.getProperty("employeeName"));
        lastNameField.sendKeys(Property.getProperty("employeeLastName"));
        employeeId = employeeIdField.getValue();
        saveButton.click();
    }

    @Step("Add Sales Manager job vacancy")
    public void addingSalesManagerJob() {
        jobLink.click();
        saveButton.click();
        jobTitle.click();
        salesManagerOption.click();
        saveButton.click();
    }

    @Step("Sort employees list by descending")
    public void sortEmployeeIdByDescending() {
        idHeader.click();
        idHeader.click();
    }

    @Step("Delete test employee")
    public void deleteEmployee() {
        switchToEmployeeList();
        sortEmployeeIdByDescending();
        confirmEmployeeDeleting();
    }

    @Step("Confirm employee deleting")
    public void confirmEmployeeDeleting() {
        $x(String.format("//a[contains(text(), %s)]/parent::td/preceding-sibling::td", employeeId)).click();
        deleteButton.click();
        dialogConfirmButton.click();
    }

    @Step("Check success message interaction")
    public boolean checkSuccessMessage() {
        return successMessage.isDisplayed();
    }
}
