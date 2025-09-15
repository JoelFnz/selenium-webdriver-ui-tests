package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CityWeatherPage extends PageObject {
    private static final By CITY_NAME_LOC = By.className("header-loc");

    public CityWeatherPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, By.xpath("//div[contains(@class,'weather-card__body')]"));
    }

    public String getCityName() {
        return getElement(CITY_NAME_LOC).getText();
    }
}
