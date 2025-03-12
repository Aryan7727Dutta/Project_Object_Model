package gh_testcases;
import org.openqa.selenium.JavascriptExecutor;
import gh_pages.LoginPage;
import gh_pages.RepositoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateRepositoryTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private RepositoryPage repositoryPage;

    @BeforeClass
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);
        repositoryPage = new RepositoryPage(driver);
    }

    @Test(priority = 1)
    public void createNewRepository() throws InterruptedException {
        driver.get("https://github.com/login");

        loginPage.login("duttaryan2002@gmail.com", "duttaryan123");
        Thread.sleep(2000);
        driver.get("https://github.com/Aryan7727Dutta?tab=repositories");

        repositoryPage.clickNewRepository();

        String repoName = "TestRepo_" + System.currentTimeMillis();
        String repoDescription = "This is a test repository";

        repositoryPage.enterRepositoryName(repoName);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        repositoryPage.clickCreateRepository();
    }



    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
