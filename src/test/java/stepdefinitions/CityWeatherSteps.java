package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.CityWeatherPage;
import utils.ScenarioContext;

import javax.inject.Inject;

public class CityWeatherSteps extends BaseSteps {
    private final CityWeatherPage cityWeatherPage;

    @Inject
    public CityWeatherSteps(ScenarioContext context) {
        super(context);
        cityWeatherPage = new CityWeatherPage(context.getDriver(), context.getWait());
    }

    @Then("the weather page for {string} should be displayed")
    public void isWeatherPageForCityDisplayed(String city) {
        Assert.assertTrue(cityWeatherPage.isPageLoadedAfterWait(), "No city weather webpage was loaded");
        boolean hasCityName = cityWeatherPage.getCityName().contains(city);
        Assert.assertTrue(hasCityName, "The city weather webpage doesn't contain the expected name: " + city);
    }
}
