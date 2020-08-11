package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SalesPage {

    private final SelenideElement pimTabLink = $x("//a[@id='menu_pim_viewPimModule']");
    private final SelenideElement salesProfile = $x("//td[contains(text(), 'Sales ')]/preceding-sibling::td[1]/a");

    public void switchToPIMTab() {
        pimTabLink.click();
    }

    public void openSalesProfile() {
        switchToPIMTab();
        salesProfile.click();
    }
}
