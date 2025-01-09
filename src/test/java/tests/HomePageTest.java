package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WeatherPage;
import utils.TestDataReader;

public class HomePageTest extends BaseTest {
    private final HomePage homePage = new HomePage();

    @Test
    public void homePageTest() {
        homePage.clickForConsent();
        homePage.inputText(TestDataReader.getCityData().getCityName());
        Assert.assertTrue(homePage.isCityListDisplayed(), "Searched City list is not displayed.");
        homePage.clickCityByIndex(0);

        WeatherPage weatherPage = new WeatherPage();
        String actualHeaderText = weatherPage.getCityHeaderText();
        Assert.assertTrue(weatherPage.state().waitForDisplayed(), "Weather page is not displayed.");
        String expectedCityName = TestDataReader.getCityData().getCityName();
        Assert.assertTrue(actualHeaderText.contains(expectedCityName), "The city name is not found in the header text.");
    }
}
