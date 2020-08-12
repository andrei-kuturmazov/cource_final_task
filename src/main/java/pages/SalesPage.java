package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SalesPage {

    private final SelenideElement pimTabLink = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement salesProfile = $x("//td[contains(text(), 'Sales ')]/preceding-sibling::td[1]/a");
    private final SelenideElement fullNameField = $x("//input[@id='personal_txtEmpFirstName']");
    private final SelenideElement middleNameField = $x("//input[@id='personal_txtEmpMiddleName']");
    private final SelenideElement lastNameField = $x("//input[@id='personal_txtEmpLastName']");
    private final SelenideElement employeeIdField = $x("//input[@id='personal_txtEmployeeId']");
    private final SelenideElement otherIdField = $x("//input[@id='personal_txtOtherID']");
    private final SelenideElement driversLicenseField = $x("//input[@id='personal_txtLicenNo']");
    private final SelenideElement driversLicenseExpireDateField = $x("//input[@id='personal_txtLicExpDate']");
    private final SelenideElement martialStatusDropdown = $x("//select[@id='personal_cmbMarital']");
    private final SelenideElement nationalityDropDown = $x("//select[@id='personal_cmbNation']");
    private final SelenideElement dateOfBirth = $x("//input[@id='personal_DOB']");
    private final SelenideElement editButton = $x("//input[@id='btnSave']");
    private final SelenideElement addAttachmentButton = $x("//input[@id='btnAddAttachment']");

    public void switchToPIMTab() {
        pimTabLink.click();
    }

    public void openSalesProfile() {
        switchToPIMTab();
        salesProfile.click();
    }

    public void checkPersonalDetailsElements() {
        fullNameField.shouldBe(Condition.visible);
        middleNameField.shouldBe(Condition.visible);
        lastNameField.shouldBe(Condition.visible);
        employeeIdField.shouldBe(Condition.visible);
        otherIdField.shouldBe(Condition.visible);
        driversLicenseField.shouldBe(Condition.visible);
        driversLicenseExpireDateField.shouldBe(Condition.visible);
        martialStatusDropdown.shouldBe(Condition.visible);
        nationalityDropDown.shouldBe(Condition.visible);
        dateOfBirth.shouldBe(Condition.visible);
        editButton.shouldBe(Condition.visible);
        addAttachmentButton.shouldBe(Condition.visible);
    }
}
