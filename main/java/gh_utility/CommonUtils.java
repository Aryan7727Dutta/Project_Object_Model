package gh_utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CommonUtils {
    private WebDriver driver;

    public CommonUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementToBeVisible(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void enterText(WebElement element, String text) {
        waitForElementToBeVisible(element, 5);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        waitForElementToBeVisible(element, 5);
        element.click();
    }
}
