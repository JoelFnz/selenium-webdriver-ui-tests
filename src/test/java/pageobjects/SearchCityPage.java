package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchCityPage extends PageObject {
    private final static By CITY_INPUT_LOC = By.name("query");
    private final static By SEARCH_RESULTS_LOC = By.xpath("//div[contains(@class,'source-radar')]");

    public SearchCityPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, CITY_INPUT_LOC);
    }

    @Step("Clear the city input and type {text}")
    public void searchCity(String text) {
        clearAndType(getElement(CITY_INPUT_LOC), text);
    }

    @Step("Click the first result from the search")
    public void clickFirstResult() {
        getElements(SEARCH_RESULTS_LOC).get(0).click();
    }
}
