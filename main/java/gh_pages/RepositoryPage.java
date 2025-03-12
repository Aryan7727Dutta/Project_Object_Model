package gh_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RepositoryPage {
    private WebDriver driver;
    private By plusButton = By.xpath("//a[@class='text-center btn btn-primary ml-2']"); // Clicking the "+" button
    private By newRepoOption = By.cssSelector(".Box-sc-g0xbh4-0.cQdyWD.prc-Link-Link-85e08");
    private By repoNameField = By.id(":rh:");
    private By createRepoButton = By.xpath("//button[contains(@class,'prc-Button-ButtonBase')]");
    public RepositoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNewRepository() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(plusButton).click();

    }

    public void enterRepositoryName(String repoName) throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(repoNameField).sendKeys(repoName);
    }



    public void clickCreateRepository() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(createRepoButton).click();
    }
}
