package pages;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class WeatherPage extends Form {
    private final ILabel weatherPageHeader = getElementFactory().getLabel(By.xpath("//h1[@class='header-loc']"), "City Header");

    public WeatherPage() {
        super(By.className("three-day"), "Weather Page");
    }

    public String getCityHeaderText() {
        weatherPageHeader.state().waitForDisplayed();
        return weatherPageHeader.getText();
    }
}
