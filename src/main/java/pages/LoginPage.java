package pages;

import com.codeborne.selenide.SelenideElement;
import utils.Property;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    public String baseUrl = Property.getProperty("url");

    private final SelenideElement loginField = $x("//input[@id='txtUsername']");
    private final SelenideElement passwordField = $x("//input[@id='txtPassword']");
    private final SelenideElement loginButton = $x("//input[@id='btnLogin']");

}
