package stepdefinitions;

import io.cucumber.java.en.Given;
import pageobjects.AccuWeatherPage;
import utils.ScenarioContext;

import javax.inject.Inject;

public class AccuWeatherSteps extends BaseSteps {
    private final AccuWeatherPage accuWeatherPage;

    @Inject
    public AccuWeatherSteps(ScenarioContext context) {
        super(context);
        accuWeatherPage = new AccuWeatherPage(context.get("driver"), context.get("wait"));
    }

    @Given("I am on the AccuWeather webpage")
    public void iAmOnTheAccuWeatherWebpage() {
        accuWeatherPage.waitForPageToLoad();
    }
}
