package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccuWeatherPage extends PageObject {

    public AccuWeatherPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait, By.xpath("//div[contains(@class,'nearby-locations-list')]"));
    }
}
