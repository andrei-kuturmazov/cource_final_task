package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import utils.Property;


import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public String baseUrl = Property.getProperty("url");

    private final SelenideElement loginField = $x("//input[@id='txtUsername']");
    private final SelenideElement passwordField = $x("//input[@id='txtPassword']");
    private final SelenideElement loginButton = $x("//input[@id='btnLogin']");
    private final SelenideElement userLink = $x("//a[@id='welcome']");
    private final SelenideElement logoutLink = $x("//a[contains(text(), 'Logout')]");

    @Step("Open login page")
    public void openLoginPage() {
        Selenide.open(baseUrl);
    }

    @Step("Login to app as administrator")
    public void loginToApp() {
        loginField.sendKeys(Property.getProperty("login"));
        passwordField.sendKeys(Property.getProperty("password"));
        loginButton.click();
    }

    @Step("Logout from application")
    public void logoutFromApp() {
        userLink.click();
        logoutLink.click();
    }
}
