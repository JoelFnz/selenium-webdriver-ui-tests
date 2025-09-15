package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScenarioContext;
import utils.files.EnvReader;

import javax.inject.Inject;
import java.time.Duration;

public class DriverHooks {
    private ScenarioContext context;

    @Inject
    public DriverHooks(ScenarioContext context) {
        this.context = context;
    }

    @Before(order = 1)
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        context.addDriver(new ChromeDriver(options));
        Duration waitDuration = Duration.ofSeconds(EnvReader.getEnvData().getMaxWait());
        context.addWait(new WebDriverWait(context.getDriver(), waitDuration));
        context.getDriver().get(EnvReader.getEnvData().getHost());
    }

    @After(order = 0)
    public void teardown() {
        if (context.getDriver() != null) {
            context.getDriver().quit();
        }
    }
}
