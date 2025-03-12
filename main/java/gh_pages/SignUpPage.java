package gh_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;
    private By signUpLink = By.linkText("Sign up");
    private By usernameField = By.id("user[login]");
    private By emailField = By.id("user[email]");
    private By passwordField = By.id("user[password]");
    private By signUpButton = By.xpath("//button[contains(text(),'Sign up for GitHub')]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToSignUp() {
        driver.findElement(signUpLink).click();
    }

    public void signUp(String username, String email, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signUpButton).click();
    }
}
