package utils;

import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v137.emulation.Emulation;
import transformations.types.Geolocation;

import java.util.Optional;

@UtilityClass
public class GeolocationUtils {

    public void setLocation(WebDriver driver, Geolocation location) throws IllegalArgumentException {
        if (driver instanceof ChromeDriver chromeDriver) {
            chromeDriver.getDevTools().createSession();
            chromeDriver.getDevTools().send(Emulation.setGeolocationOverride(
                    Optional.of(location.getLatitude()),
                    Optional.of(location.getLongitude()),
                    Optional.of(150f),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty(),
                    Optional.empty()
            ));
        } else {
            throw new IllegalArgumentException("Geolocation settings are not implemented for driver " +
                                               driver.getClass().getSimpleName());
        }
    }
}
