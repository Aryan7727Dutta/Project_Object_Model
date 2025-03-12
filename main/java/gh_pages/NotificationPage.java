package gh_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NotificationPage {
    private WebDriver driver;
    private By notificationIcon = By.xpath("//summary[@aria-label='View notifications']");

    public NotificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openNotifications() {
        driver.findElement(notificationIcon).click();
    }
}
