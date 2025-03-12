package gh_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;
    private By profileDropdown = By.xpath("//summary[@aria-label='View profile and more']");
    private By signOutButton = By.xpath("//button[contains(text(),'Sign out')]");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(profileDropdown).click();
        driver.findElement(signOutButton).click();
    }
}
