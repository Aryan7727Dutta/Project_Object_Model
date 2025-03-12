package gh_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage {
    private WebDriver driver;

    private By homeLink = By.xpath("//a[contains(@href, '/home')]");
    private By repositoriesTab = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[2]/nav[1]/ul[1]/li[2]/a[1]/span[1]");
    private By notificationsTab = By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[1]/div[2]/notification-indicator[1]/a[1]");

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHome() {
        driver.get("https://github.com/Aryan7727Dutta");
        System.out.println("Navigated to Home Page");
    }

    public void goToRepositories() {
        driver.findElement(repositoriesTab).click();
        System.out.println("Navigated to Repositories");
    }

    public void goToNotifications() {
        driver.findElement(notificationsTab).click();
        System.out.println("Navigated to Notifications");
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully");
        }
    }
}
