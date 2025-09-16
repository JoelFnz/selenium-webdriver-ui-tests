package stepdefinitions;

import io.cucumber.java.en.Given;
import transformations.types.Geolocation;
import utils.GeolocationUtils;
import utils.ScenarioContext;

import javax.inject.Inject;

public class DriverSteps extends BaseSteps {

    @Inject
    public DriverSteps(ScenarioContext context) {
        super(context);
    }

    @Given("my current location is {geolocation}")
    public void setCurrentLocationTo(Geolocation geolocation) {
        GeolocationUtils.setLocation(context.getDriver(), geolocation);
    }
}
