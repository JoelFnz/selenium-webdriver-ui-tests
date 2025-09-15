package pageobjects;

import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

@AllArgsConstructor
public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final By uniqueLocator;

    public boolean isPageLoaded() {
        return getElement(uniqueLocator).isDisplayed();
    }

    public void waitForPageToLoad() throws TimeoutException {
        wait.until(d -> isPageLoaded());
    }

    public boolean isPageLoadedAfterWait() {
        try {
            waitForPageToLoad();
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    protected void clearAndType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    protected WebElement getElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected List<WebElement> getElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
}
