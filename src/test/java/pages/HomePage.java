package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class HomePage extends Form {
    private final IButton consentBtn = getElementFactory().getButton(By.xpath("//div[contains(@class, 'policy-accept')]"), "Consent Button");
    private final ITextBox textFeild = getElementFactory().getTextBox(By.xpath("//input[@type='text']"), "Input Field");
    private final By cityListLocator = By.xpath("//div[@class='results-container']//div[contains(@class, 'search-bar-result')]");

    public HomePage() {
        super(By.xpath("//body[contains(@class, 'home')]"), "Homepage");
    }

    public void clickForConsent() {
        consentBtn.click();
    }

    public void inputText(String text) {
        textFeild.type(text);
    }

    public boolean isCityListDisplayed() {
        return AqualityServices.getConditionalWait().waitFor(() -> !getCityLabelList().isEmpty(),
                "City list did not appear within the expected time.");
    }

    private List<ILabel> getCityLabelList() {
        return getElementFactory().findElements(cityListLocator, "City Items", ElementType.LABEL);
    }

    public void clickCityByIndex(int index) {
        getCityLabelList().get(index).click();
    }
}
