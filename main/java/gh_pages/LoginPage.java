package gh_pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import gh_baseclass.BaseClass;

public class LoginPage {
    public WebDriver driver;
    public static final Logger logger = Logger.getLogger(LoginPage.class);
    public WebDriverWait wait;
    public BaseClass base;

    public By usernameField = By.id("login_field");
    public By passwordField = By.id("password");
    public By loginButton = By.name("commit");

    public LoginPage(WebDriver driver) throws InterruptedException {
        this.driver = driver;
        Thread.sleep(4000);
    }

    public void enterUsername(String username) {
        logger.info("Entering username: " + username);
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        logger.info("Entering password: [HIDDEN]");
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        logger.info("Clicking on Login button");
        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {
        logger.info("Starting login process...");
        enterUsername(username);
        enterPassword(password);
        clickLogin();
        logger.info("Login attempt completed.");
    }

    public boolean isLoginSuccessful() {

        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("github.com")) {
            System.out.println("Login successful!");
            logger.info("Login successful: ");
            return true;
        } else {
            System.out.println("Login failed! Current URL: " + currentUrl);
            logger.error("Login verification failed.");
            return false;
        }
    }
}
