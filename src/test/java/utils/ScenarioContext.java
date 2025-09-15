package utils;

import io.cucumber.guice.ScenarioScoped;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

@ScenarioScoped
public class ScenarioContext {
    private static final String DRIVER_KEY = "driver";
    private static final String WAIT_KEY = "wait";
    private final Map<String, Object> context;

    public ScenarioContext() {
        context = new HashMap<>();
    }

    public <T> void add(String key, T value) {
        context.put(key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) context.get(key);
    }

    public WebDriver getDriver() {
        return get(DRIVER_KEY);
    }

    public WebDriverWait getWait() {
        return get(WAIT_KEY);
    }

    public void addDriver(WebDriver driver) {
        add(DRIVER_KEY, driver);
    }

    public void addWait(WebDriverWait wait) {
        add(WAIT_KEY, wait);
    }
}
