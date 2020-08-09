package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.Arrays;
import java.util.List;

import static com.codeborne.selenide.Selenide.$x;

public class JobTitlesPage {

    private static List<String> jobTitles = Arrays.asList("The old master", "Master Chef", "National Hero");

    private final SelenideElement jobDropdown = $x("//a[@id='menu_admin_Job']");
    private final SelenideElement jobTitlesLink = $x("//a[@id='menu_admin_viewJobTitleList']");
    private final SelenideElement successMessage = $x("//div[@class='fadable']");
    private final SelenideElement jobTitleField = $x("//input[@id='jobTitle_jobTitle']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement deleteButton = $x("//input[@id='btnDelete']");
    private final SelenideElement deleteConfirmationButton = $x("//input[@id='dialogDeleteBtn']");

    public void switchToJobTitlesTab() {
        jobDropdown.hover();
        jobTitlesLink.click();
    }

    public void addJobTitle() {
        for (String item : jobTitles) {
            addButton.click();
            jobTitleField.sendKeys(item);
            formSaveButton.click();
            checkSuccessMessage();
        }
    }

    public void deleteJobTitles() {
        for (String item : jobTitles) {
            String xPath = String.format("//a[contains(text(), '%s')]/parent::td/preceding-sibling::td", item);
            $x(xPath).click();
        }
        deleteButton.click();
        deleteConfirmationButton.click();
        checkSuccessMessage();
    }

    public void checkSuccessMessage() {
        successMessage.isDisplayed();
    }
}
