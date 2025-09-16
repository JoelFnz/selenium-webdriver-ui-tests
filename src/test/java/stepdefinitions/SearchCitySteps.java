package stepdefinitions;

import io.cucumber.java.en.When;
import pageobjects.SearchCityPage;
import utils.ScenarioContext;

import javax.inject.Inject;

public class SearchCitySteps extends BaseSteps {
    private final SearchCityPage searchCityPage;

    @Inject
    public SearchCitySteps(ScenarioContext context) {
        super(context);
        searchCityPage = new SearchCityPage(context.getDriver(), context.getWait());
    }

    @When("I type {string} on the search bar")
    public void iTypeOnTheSearchBar(String text) {
        searchCityPage.searchCity(text);
    }

    @When("I click on the first result")
    public void iClickOnTheFirstResult() {
        searchCityPage.clickFirstResult();
    }

    @When("I click the search bar")
    public void iClickTheSearchBar() {
        searchCityPage.clickSearchBar();
    }

    @When("I click the current location label")
    public void iClickTheCurrentLocationLabel() {
        searchCityPage.clickCurrentLocationLabel();
    }
}
