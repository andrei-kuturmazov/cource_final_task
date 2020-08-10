package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class RecruitmentPage {

    private final SelenideElement recruitmentTabLink = $x("//a[@id='menu_recruitment_viewRecruitmentModule']");
    private final SelenideElement candidateFirstNameField = $x("//input[@id='addCandidate_firstName']");
    private final SelenideElement candidateLastNameField = $x("//input[@id='addCandidate_lastName']");
    private final SelenideElement candidateEmail = $x("//input[@id='addCandidate_email']");
    private final SelenideElement errorMessage = $x("//div[@class='message error']");
    private final SelenideElement formSaveButton = $x("//input[@id='btnSave']");
    private final SelenideElement addButton = $x("//div[@class='top']/input[@type='button']");

    public void addCandidate() {
        recruitmentTabLink.click();
        addButton.click();
        candidateFirstNameField.sendKeys("Hello");
        candidateLastNameField.sendKeys("World");
        candidateEmail.sendKeys("hello-world@gmail.com");
        formSaveButton.click();
    }

    public void addCandidateAndCheckCreation() {
        addCandidate();
        errorMessage.shouldNotBe(Condition.visible);
    }
}
