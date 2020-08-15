package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class JobTitlesPage {

    private static final List<String> jobTitles = Arrays.asList("The old master", "Master Chef", "National Hero");

    private final SelenideElement jobDropdown = $x("//a[@id='menu_admin_Job']");
    private final SelenideElement jobTitlesLink = $x("//a[@id='menu_admin_viewJobTitleList']");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");
    private final SelenideElement jobTitleField = $x("//input[@id='jobTitle_jobTitle']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement deleteConfirmationButton = $x("//input[@id='dialogDeleteBtn']");

    /* Steps */

    @Step("Add button click")
    public void addButtonClick() {
        addButton.click();
    }

    @Step("Form save button click")
    public void formSaveButtonClick() {
        formSaveButton.click();
    }

    @Step("Input Job title name")
    public void inputJobTitle(String item) {
        jobTitleField.sendKeys(item);
    }

    @Step("Switch to job titles tab")
    public void switchToJobTitlesTab() {
        jobDropdown.hover();
        jobTitlesLink.click();
    }

    @Step("Add List of new job titles")
    public void addJobTitle() {
        for (String item : jobTitles) {
            addButtonClick();
            inputJobTitle(item);
            formSaveButtonClick();
            checkSuccessMessage();
        }
    }

    @Step("Select Test Job Titles")
    public void selectTestItem(String xPath) {
        $x(xPath).click();
    }

    @Step("Delete and confirm ")
    public void confirmJobTitleDeleting() {
        deleteButton.click();
        deleteConfirmationButton.click();
    }

    @Step("Delete created job titles")
    public void deleteJobTitles() {
        for (String item : jobTitles) {
            String xPath = String.format("//a[contains(text(), '%s')]/parent::td/preceding-sibling::td", item);
            selectTestItem(xPath);
        }
        confirmJobTitleDeleting();
        checkSuccessMessage();
    }

    @Step("Check success message interaction")
    public void checkSuccessMessage() {
        successMessage.isDisplayed();
    }
}
